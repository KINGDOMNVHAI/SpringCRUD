package com.poscdx.odc.excan013.domain.spec;

import com.poscdx.odc.excan013.domain.entity.ExcanEQuestion;
import com.poscdx.odc.excan013.domain.entity.ExcanQuestion;
import com.poscdx.odc.excan013.domain.entity.payload.request.SubmitExamRequest;
import com.poscdx.odc.excan013.domain.lifecycle.ServiceLifecycle;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;

public interface Level2DoingExamService {

    List<ExcanQuestion> findQuestionsByExamId(ServiceLifecycle serviceLifecycle, int examId);
    ResponseEntity<?> startExam (ServiceLifecycle serviceLifecycle, int examId);

    ResponseEntity<?> saveExam(ServiceLifecycle serviceLifecycle, int id, SubmitExamRequest requestData);
}
