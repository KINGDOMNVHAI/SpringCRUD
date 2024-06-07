package com.poscodx.odc.excan013.service.rest;

import com.poscdx.odc.excan013.domain.DTO.SettingSearchDTO;
import com.poscdx.odc.excan013.domain.entity.ExcanExam;
import com.poscdx.odc.excan013.domain.entity.ExcanSItem;
import com.poscdx.odc.excan013.domain.entity.ExcanSetting;
import com.poscdx.odc.excan013.domain.lifecycle.ServiceLifecycle;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/exam")
public class Level2ExamResource {

    private final ServiceLifecycle serviceLifecycle;

    @CrossOrigin
    @PreAuthorize("hasAuthority('GET_EXAM_SETTING')")
    @GetMapping("/searchProfile")
    public List<ExcanSetting> searchProfile(SettingSearchDTO requestParam) {
        return this.serviceLifecycle.requestExcanSettingService().search(requestParam);
    }

    @CrossOrigin
//    @PreAuthorize("hasAuthority('GET_EXAM_SETTING')")
    @GetMapping("/getProfileInf")
    public ExcanSetting getProfileInfo(int profileId) {
        return this.serviceLifecycle.requestExcanSettingService().find(profileId);
    }

    @CrossOrigin
    @PreAuthorize("hasAuthority('GET_EXAM_SETTING')")
    @GetMapping("/searchProfileItem")
    public List<ExcanSItem> searchProfileItem(String profileId) {
        return this.serviceLifecycle.requestExcanSItemService().search(profileId);
    }

    @CrossOrigin
    @PreAuthorize("hasAuthority('ADD_EXAM_SETTING')")
    @PutMapping("/createProfileInf")
    public void createProfileInf(@RequestBody Map<String, Object> data) {
        this.serviceLifecycle.requestLevel2ExamService().createProfileInf(data);
    }

    @CrossOrigin
    @PreAuthorize("hasAuthority('UPDATE_EXAM_SETTING')")
    @PostMapping("/updateProfileInf")
    public void updateProfileInf(@RequestBody Map<String, Object> data) {
        this.serviceLifecycle.requestLevel2ExamService().updateProfileInf(data);
    }

    @CrossOrigin
    @PreAuthorize("hasAuthority('GET_EXAM')")
    @GetMapping("/getExamInfByCandidateId")
    public ExcanExam getExamInfByCandidateId(int candidateId) {
        return this.serviceLifecycle.requestExcanExamService().findByCandidateId(candidateId);
    }

    @CrossOrigin
    @PreAuthorize("hasAnyAuthority(['ADD_EXAM,UPDATE_EXAM'])")
    @GetMapping("/generateExamQuestion")
    public int generateExamQuestion(int examId, int profileId, String creator) {
        return this.serviceLifecycle.requestExcanExamService().generateExam(examId, profileId, creator);
    }

    @CrossOrigin
    @PreAuthorize("hasAuthority('ADD_EXAM')")
    @PutMapping("/createExamInf")
    public ExcanExam createExamInf(@RequestBody Map<String, Object> data) {
        return this.serviceLifecycle.requestLevel2ExamService().createExamInf(data);
    }

    @CrossOrigin
    @PreAuthorize("hasAuthority('UPDATE_EXAM')")
    @PostMapping("/updateExamInf")
    public void updateExamInf(@RequestBody Map<String, Object> data) {
        this.serviceLifecycle.requestLevel2ExamService().updateExamInf(data);
    }

    @CrossOrigin
    @PreAuthorize("hasAuthority('UPDATE_EXAM')")
    @PostMapping("/retakeExamInf")
    public ExcanExam retakeExamInf(@RequestBody Map<String, Object> data) {
        return this.serviceLifecycle.requestLevel2ExamService().retakeExamInf(data);
    }

    @CrossOrigin
    @PreAuthorize("hasAuthority('UPDATE_EXAM')")
    @DeleteMapping("/deleteExamInf")
    public void deleteExamInf(@RequestParam int examId) {
        this.serviceLifecycle.requestLevel2ExamService().deleteExamInf(examId);
    }
}
