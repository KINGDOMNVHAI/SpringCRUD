package com.poscdx.odc.excan013.domain.spec;

import com.poscdx.odc.excan013.domain.entity.ExcanExam;

import java.util.Map;

public interface Level2ExamService {

    void createProfileInf(Map<String, Object> data);

    void updateProfileInf(Map<String, Object> data);

    ExcanExam createExamInf(Map<String, Object> data);

    void updateExamInf(Map<String, Object> data);

    ExcanExam retakeExamInf(Map<String, Object> data);

    void deleteExamInf(int examId);


}
