package com.poscdx.odc.excan013.domain.logic;

import com.poscdx.odc.excan013.domain.entity.ExcanCandidate;
import com.poscdx.odc.excan013.domain.entity.ExcanCodeDetail;
import com.poscdx.odc.excan013.domain.entity.SearchCandidateDto;
import com.poscdx.odc.excan013.domain.spec.ExcanCandidateService;
import com.poscdx.odc.excan013.domain.spec.ExcanCodeDetailService;
import com.poscdx.odc.excan013.domain.spec.Level2CandidateService;
import com.poscdx.odc.excan013.domain.utils.ExcelGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
@RequiredArgsConstructor
public class Level2CandidateLogic implements Level2CandidateService {

    private final ExcanCandidateService candidateService;
    private final ExcanCodeDetailService codeDetailService;

    @Override
    public ExcanCandidate find(int id) {
        log.info("Find candidate by id: {}", id);

        ExcanCandidate candidate = candidateService.find(id);
        if (candidate == null) {
            return null;
        }

        Map<Integer, ExcanCodeDetail> codeMap = getCodeDetailMap(Collections.singletonList(candidate));
        appendCodeDetails(candidate, codeMap);

        return candidate;
    }

    @Override
    public List<ExcanCandidate> findCandidateList(SearchCandidateDto searchDto) {
        log.info("Find candidate list by searchDto: {}", searchDto);
        List<ExcanCandidate> candidates = candidateService.findCandidateList(searchDto);
        Map<Integer, ExcanCodeDetail> codeMap = getCodeDetailMap(candidates);
        candidates.forEach(c -> appendCodeDetails(c, codeMap));
        return candidates;
    }

    @Override
    public void exportToExcel(HttpServletResponse response, SearchCandidateDto searchDto) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Candidate-" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);
        List<ExcanCandidate> listCandidate = this.findCandidateList(searchDto);
        ExcelGenerator generator = new ExcelGenerator(listCandidate);
        generator.generateExcelFile(response);
    }

    private Map<Integer, ExcanCodeDetail> getCodeDetailMap(List<ExcanCandidate> candidates) {
        Set<Integer> codeIds = new HashSet<>();
        candidates.forEach(c -> {
            codeIds.add(c.getPosition());
            codeIds.add(c.getDepartment());
            codeIds.add(c.getInterviewer());
            codeIds.add(c.getInterviewResult());
            codeIds.add(c.getYearOfExperience());
            codeIds.add(c.getUniversity());
        });

        List<ExcanCodeDetail> details = codeDetailService.findAllByIdIn(codeIds);
        Map<Integer, ExcanCodeDetail> codeMap = new HashMap<>();
        MapUtils.populateMap(codeMap, details, ExcanCodeDetail::getId);

        // Add empty code detail to avoid null pointer exception
        codeMap.put(0, ExcanCodeDetail.builder()
                .id(0)
                .name("")
                .build());
        codeMap.put(null, ExcanCodeDetail.builder()
                .id(0)
                .name("")
                .build());

        return codeMap;
    }

    private void appendCodeDetails(ExcanCandidate candidate, Map<Integer, ExcanCodeDetail> codeMap) {
        candidate.setPositionName(codeMap.get(candidate.getPosition()).getName());
        candidate.setDepartmentName(codeMap.get(candidate.getDepartment()).getName());
        candidate.setInterviewerName(codeMap.get(candidate.getInterviewer()).getName());
        candidate.setInterviewResultName(codeMap.get(candidate.getInterviewResult()).getName());
        candidate.setYearOfExperienceName(codeMap.get(candidate.getYearOfExperience()).getName());
        candidate.setUniversityName(codeMap.get(candidate.getUniversity()).getName());
    }
}
