package com.poscodx.odc.excan013.service.rest;

import com.poscdx.odc.excan013.domain.entity.ExcanCandidate;
import com.poscdx.odc.excan013.domain.lifecycle.ServiceLifecycle;
import com.poscdx.odc.excan013.domain.spec.ExcanCandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/candidate")
public class CandidateResource {

    private final ServiceLifecycle serviceLifecycle;
    private final ExcanCandidateService excanCandidateService;

    @CrossOrigin
    @GetMapping(path = "/getAll")
    @PreAuthorize("hasAuthority('GET_CANDIDATE')")
    public List<ExcanCandidate> findAll() {
        return this.excanCandidateService.findAll();
    }

    @CrossOrigin
    @GetMapping(path = "/{id}")
//    @PreAuthorize("hasAuthority('GET_CANDIDATE')")
    public ExcanCandidate find(@PathVariable("id") int id) {
        return this.serviceLifecycle.requestLevel2CandidateService().find(id);
    }

    @CrossOrigin
    @PostMapping
    @PreAuthorize("hasAuthority('ADD_CANDIDATE')")
    public ExcanCandidate register(@RequestBody ExcanCandidate entity) {
        return this.excanCandidateService.register(entity);
    }

    @CrossOrigin
    @PutMapping
    @PreAuthorize("hasAuthority('UPDATE_CANDIDATE')")
    public void modify(@RequestBody ExcanCandidate entityList) {
        this.excanCandidateService.modify(entityList);
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.PUT, RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
    @DeleteMapping(path = "/{id}")
    @PreAuthorize("hasAuthority('DELETE_CANDIDATE')")
    public void remove(@PathVariable("id") int id) {
        this.excanCandidateService.remove(id);
    }
}
