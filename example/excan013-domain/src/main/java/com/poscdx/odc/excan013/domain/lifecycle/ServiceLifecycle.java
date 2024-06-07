package com.poscdx.odc.excan013.domain.lifecycle;

import com.poscdx.odc.excan013.domain.spec.*;

public interface ServiceLifecycle {

    ExcanAnswerService requestExcanAnswerService();
    ExcanCandidateService requestExcanCandidateService();
    ExcanCategoryService requestExcanCategoryService();
    ExcanEQuestionService requestExcanEQuestionService();
    ExcanExamService requestExcanExamService();
    ExcanMenuService requestExcanMenuService();
    ExcanQuestionService requestExcanQuestionService();
    ExcanRoleService requestExcanRoleService();
    ExcanSettingService requestExcanSettingService();
    ExcanSItemService requestExcanSItemService();
    ExcanUserService requestExcanUserService();
    ExcanPermissionService requestExcanPermissionService();
    ExcanPerRoleService requestExcanPerRoleService();
    Level2CandidateService requestLevel2CandidateService();
    Level2DoingExamService requestLevel2DoingExamService();
    Level2ExamService requestLevel2ExamService();
    Level2QuestionService requestLevel2QuestionService();
    Level2UserService requestLevel2UserService();
    ExcanAccessTokenService requestExcanAccessTokenService();

    Level2ExamCheckingService getLevel2ExamCheckingService();

    Level2DashboardService requestLevel2DashboardService();
}
