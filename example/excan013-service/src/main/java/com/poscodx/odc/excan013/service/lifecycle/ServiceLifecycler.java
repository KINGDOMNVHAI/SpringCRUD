package com.poscodx.odc.excan013.service.lifecycle;

import com.poscdx.odc.excan013.domain.lifecycle.ServiceLifecycle;
import com.poscdx.odc.excan013.domain.spec.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ServiceLifecycler implements ServiceLifecycle {

    private final ExcanAnswerService excanAnswerService;
    private final ExcanCandidateService excanCandidateService;
    private final ExcanCategoryService excanCategoryService;
    private final ExcanEQuestionService excanEQuestionService;
    private final ExcanExamService excanExamService;
    private final ExcanMenuService excanMenuService;
    private final ExcanQuestionService excanQuestionService;
    private final ExcanRoleService excanRoleService;
    private final ExcanSettingService excanSettingService;
    private final ExcanSItemService excanSItemService;
    private final ExcanUserService excanUserService;
    private final ExcanPermissionService excanPermissionService;
    private final ExcanPerRoleService excanPerRoleService;
    private final ExcanAccessTokenService excanAccessTokenService;
    private final Level2CandidateService level2CandidateService;
    private final Level2DoingExamService level2DoingExamService;
    private final Level2ExamService level2ExamService;
    private final Level2QuestionService level2QuestionService;
    private final Level2UserService level2UserService;
    private final Level2ExamCheckingService level2ExamCheckingService;
    private final Level2DashboardService level2DashboardService;

    @Override
    public ExcanAnswerService requestExcanAnswerService() {
        return this.excanAnswerService;
    }

    @Override
    public ExcanCandidateService requestExcanCandidateService() {
        return this.excanCandidateService;
    }

    @Override
    public ExcanCategoryService requestExcanCategoryService() {
        return this.excanCategoryService;
    }

    @Override
    public ExcanEQuestionService requestExcanEQuestionService() {
        return this.excanEQuestionService;
    }

    @Override
    public ExcanExamService requestExcanExamService() {
        return this.excanExamService;
    }

    @Override
    public ExcanMenuService requestExcanMenuService() {
        return this.excanMenuService;
    }

    @Override
    public ExcanQuestionService requestExcanQuestionService() {
        return this.excanQuestionService;
    }

    @Override
    public ExcanRoleService requestExcanRoleService() {
        return this.excanRoleService;
    }

    @Override
    public ExcanSettingService requestExcanSettingService() {
        return this.excanSettingService;
    }

    @Override
    public ExcanSItemService requestExcanSItemService() {
        return this.excanSItemService;
    }

    @Override
    public ExcanUserService requestExcanUserService() {
        return this.excanUserService;
    }

    @Override
    public ExcanPermissionService requestExcanPermissionService() {
        return this.excanPermissionService;
    }

    @Override
    public ExcanPerRoleService requestExcanPerRoleService() {
        return this.excanPerRoleService;
    }

    @Override
    public Level2CandidateService requestLevel2CandidateService() {
        return this.level2CandidateService;
    }

    @Override
    public Level2DoingExamService requestLevel2DoingExamService() {
        return this.level2DoingExamService;
    }

    @Override
    public Level2ExamService requestLevel2ExamService() {
        return this.level2ExamService;
    }

    @Override
    public Level2QuestionService requestLevel2QuestionService() {
        return this.level2QuestionService;
    }

    @Override
    public Level2UserService requestLevel2UserService() {
        return this.level2UserService;
    }

    @Override
    public ExcanAccessTokenService requestExcanAccessTokenService() {
        return this.excanAccessTokenService;
    }

    @Override
    public Level2ExamCheckingService getLevel2ExamCheckingService() {
        return this.level2ExamCheckingService;
    }

    @Override
    public Level2DashboardService requestLevel2DashboardService() {
        return this.level2DashboardService;
    }
}
