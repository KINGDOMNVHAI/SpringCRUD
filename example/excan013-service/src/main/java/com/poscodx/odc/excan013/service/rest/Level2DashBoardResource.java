package com.poscodx.odc.excan013.service.rest;

import com.poscdx.odc.excan013.domain.entity.ExcanCandidate;
import com.poscdx.odc.excan013.domain.entity.ExcanMenu;
import com.poscdx.odc.excan013.domain.lifecycle.ServiceLifecycle;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Router API for Dashboard page
 *
 * @author 202290_nh.hung724
 * @since 2023-12
 */
@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/dashboard")
public class Level2DashBoardResource {
    private final ServiceLifecycle serviceLifecycle;

    /**
     * Retrieves candidate statistics from the database.
     *
     * @return a JSON string containing the candidate statistics.
     */
    @CrossOrigin
    @GetMapping(path = "/stats/candidates")
//    @PreAuthorize("hasAuthority('VIEW_DASHBOARD')")
    public String getCandidateStats() {
        return this.serviceLifecycle.requestLevel2DashboardService().getCandidateStats();
    }

    /**
     * Retrieves the statistics of exams.
     *
     * @return a JSON string containing the average score, average time spent, and highest score of exams
     */
    @CrossOrigin
    @GetMapping(path = "/stats/exams")
//    @PreAuthorize("hasAuthority('VIEW_DASHBOARD')")
    public String getExamStats() {
        return this.serviceLifecycle.requestLevel2DashboardService().getExamStats();
    }

    /**
     * Retrieves statistics for the results.
     *
     * @return a JSON string containing the total number of passed, pending, and rejected candidates.
     */
    @CrossOrigin
    @GetMapping(path = "/stats/results")
//    @PreAuthorize("hasAuthority('VIEW_DASHBOARD')")
    public String getResultsStats() {
        return this.serviceLifecycle.requestLevel2DashboardService().getResultsStats();
    }
    @CrossOrigin
    @GetMapping(path = "/test")
//    @PreAuthorize("hasAuthority('VIEW_DASHBOARD')")
    public List<ExcanMenu> test() {
        return this.serviceLifecycle.requestExcanMenuService().findAll();
    }

    @CrossOrigin
    @GetMapping(path = "/list/checking")
    public List<ExcanCandidate> getCanCheckingList() {
        return this.serviceLifecycle.requestLevel2DashboardService().getCanCheckingList();
    }

    @CrossOrigin
    @GetMapping(path = "/list/result")
    public List<ExcanCandidate> getCanResultList() {
        return this.serviceLifecycle.requestLevel2DashboardService().getCanResultList();
    }
}
