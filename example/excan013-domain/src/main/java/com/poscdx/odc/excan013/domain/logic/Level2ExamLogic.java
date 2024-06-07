package com.poscdx.odc.excan013.domain.logic;

import com.google.gson.Gson;
import com.poscdx.odc.excan013.domain.entity.ExcanCandidate;
import com.poscdx.odc.excan013.domain.entity.ExcanExam;
import com.poscdx.odc.excan013.domain.entity.ExcanSItem;
import com.poscdx.odc.excan013.domain.entity.ExcanSetting;
import com.poscdx.odc.excan013.domain.spec.ExcanCandidateService;
import com.poscdx.odc.excan013.domain.spec.ExcanExamService;
import com.poscdx.odc.excan013.domain.spec.ExcanSItemService;
import com.poscdx.odc.excan013.domain.spec.ExcanSettingService;
import com.poscdx.odc.excan013.domain.spec.Level2ExamService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
public class Level2ExamLogic implements Level2ExamService {

    private final ExcanSettingService excanSettingService;

    private final ExcanSItemService excanSItemService;

    private final ExcanExamService excanExamService;

    private final ExcanCandidateService excanCandidateService;

    @Override
    public void createProfileInf(Map<String, Object> data) {
        Gson gson = new Gson();
        ExcanSetting pojo = gson.fromJson(gson.toJsonTree(data.get("profileInf")), ExcanSetting.class);
        ExcanSetting newProfile = excanSettingService.register(pojo);

        List<Map<String, Object>> itemList = (List<Map<String, Object>>) data.get("profileItemList");
        itemList.forEach(item -> {
            ExcanSItem element = gson.fromJson(gson.toJsonTree(item), ExcanSItem.class);
            element.setSettingId(newProfile.getId());
            excanSItemService.register(element);
        });
    }

    @Override
    public void updateProfileInf(Map<String, Object> data) {
        Gson gson = new Gson();
        ExcanSetting pojo = gson.fromJson(gson.toJsonTree(data.get("profileInf")), ExcanSetting.class);
        ExcanSetting original = excanSettingService.find(pojo.getId());
        original.setName(pojo.getName());
        original.setDuration(pojo.getDuration());
        original.setDescription(pojo.getDescription());
        original.setStatus(pojo.getStatus());
        original.setNumberOfQuestion(pojo.getNumberOfQuestion());
        original.setUpdateBy(pojo.getUpdateBy());
        excanSettingService.modify(original);

        List<Map<String, Object>> itemList = (List<Map<String, Object>>) data.get("profileItemList");
        for (int i = 0; i < itemList.size(); i++) {
            Map<String, Object> item = itemList.get(i);
            ExcanSItem element = gson.fromJson(gson.toJsonTree(item), ExcanSItem.class);
            element.setSettingId(pojo.getId());
            if ("add".equals(item.get("modify"))) {
                excanSItemService.register(element);
            } else if ("remove".equals(item.get("modify"))) {
                excanSItemService.remove(element.getId());
            } else {
                ExcanSItem originalItem = excanSItemService.find(element.getId());
                originalItem.setCategoryId(element.getCategoryId());
                originalItem.setLevel(element.getLevel());
                originalItem.setNumberOfQuestion(element.getNumberOfQuestion());
                originalItem.setUpdateBy(element.getUpdateBy());
                excanSItemService.modify(originalItem);
            }
        }
    }

    @Override
    public ExcanExam createExamInf(Map<String, Object> data) {
        Gson gson = new Gson();
        ExcanExam pojo = gson.fromJson(gson.toJsonTree(data.get("examInf")), ExcanExam.class);
        ExcanExam newExam = excanExamService.register(pojo);
        excanExamService.generateExam(newExam.getId(), newExam.getSettingId(), newExam.getCreateBy());
        return newExam;
    }

    @Override
    public void updateExamInf(Map<String, Object> data) {
        Gson gson = new Gson();
        ExcanExam pojo = gson.fromJson(gson.toJsonTree(data.get("examInf")), ExcanExam.class);
        ExcanExam original = excanExamService.find(pojo.getId());
        original.setSettingId(pojo.getSettingId());
        original.setStatus(1);
        original.setDesc(pojo.getDesc());
        original.setUpdateBy(pojo.getUpdateBy());
        ExcanExam updatedElement = excanExamService.modify(original);
        excanExamService.generateExam(updatedElement.getId(),
                updatedElement.getSettingId(), pojo.getUpdateBy());
    }

    @Override
    public ExcanExam retakeExamInf(Map<String, Object> data) {
        Gson gson = new Gson();
        ExcanExam pojo = gson.fromJson(gson.toJsonTree(data.get("examInf")), ExcanExam.class);
        ExcanExam original = excanExamService.find(pojo.getId());

        if (ObjectUtils.isNotEmpty(original)) {
            deleteExamInf(pojo.getId());
            // create new Exam
            pojo.setStatus(1);
            ExcanExam newExam = excanExamService.register(pojo);
            excanExamService.generateExam(newExam.getId(), newExam.getSettingId(), newExam.getCreateBy());

            // update status of candidate to 6: accept
            int candidateId = pojo.getCandidateId();
            Optional<ExcanCandidate> candidate = Optional.ofNullable(excanCandidateService.find(candidateId));
            if (candidate.isPresent()) {
                ExcanCandidate updatingCandidate = candidate.get();
                //TODO: reset avatar if need, ExcanCandidate append Constants into link
                int indexOfOriginAvatar = updatingCandidate.getAvatar().lastIndexOf("/Candidate");
                String originAvatarPath = updatingCandidate.getAvatar().substring(indexOfOriginAvatar+1);
                updatingCandidate.setAvatar(originAvatarPath);
                updatingCandidate.setStatus(6);
                excanCandidateService.modify(updatingCandidate);
            }

            return newExam;
        }
        return null;
    }

    @Override
    public void deleteExamInf(int examId) {
        excanExamService.remove(examId);
    }
}
