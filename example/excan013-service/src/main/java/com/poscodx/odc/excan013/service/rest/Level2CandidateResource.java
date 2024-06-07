package com.poscodx.odc.excan013.service.rest;

import com.poscdx.odc.excan013.domain.entity.ExcanCandidate;
import com.poscdx.odc.excan013.domain.entity.ExcanExam;
import com.poscdx.odc.excan013.domain.entity.SearchCandidateDto;
import com.poscdx.odc.excan013.domain.lifecycle.ServiceLifecycle;
import com.poscdx.odc.excan013.domain.utils.ExcelGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/candidates")
public class Level2CandidateResource {

    private final ServiceLifecycle serviceLifecycle;

    @CrossOrigin
    @PostMapping(path = "/search")
    @PreAuthorize("hasAuthority('GET_CANDIDATE')")
    public List<ExcanCandidate> getCandidateList(@RequestBody SearchCandidateDto searchDto) {
        return this.serviceLifecycle.requestLevel2CandidateService().findCandidateList(searchDto);
    }

    @CrossOrigin
    @GetMapping(path = "/{id}/exam")
    public ExcanExam findExam(@PathVariable("id") int id) {
        return this.serviceLifecycle.requestExcanExamService().findByCandidateId(id);
    }

    @CrossOrigin
    @GetMapping("/getInf")
//    @PreAuthorize("hasAuthority('GET_CANDIDATE')")
    public ExcanCandidate getInf(int candidateId) {
        return this.serviceLifecycle.requestExcanCandidateService().find(candidateId);
    }

    @CrossOrigin
    @GetMapping("/export-excel")
    public void exportToExcel(HttpServletResponse response, SearchCandidateDto searchDto) throws IOException {
        this.serviceLifecycle.requestLevel2CandidateService().exportToExcel(response, searchDto);
    }
}
