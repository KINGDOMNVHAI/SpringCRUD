package com.poscdx.odc.excan013.domain.logic;

import com.poscdx.odc.excan013.domain.entity.ExcanCandidate;
import com.poscdx.odc.excan013.domain.entity.SearchCandidateDto;
import com.poscdx.odc.excan013.domain.store.ExcanCandidateStore;
import com.poscdx.odc.excan013.domain.spec.ExcanCandidateService;
import com.poscdx.odc.excan013.domain.utils.ExcelGenerator;

import javax.persistence.Tuple;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExcanCandidateLogic implements ExcanCandidateService
{
    private final ExcanCandidateStore store;

    public ExcanCandidateLogic(ExcanCandidateStore store) {
        this.store = store;
    }

    @Override
    public ExcanCandidate find(int id) {
        return this.store.retrieve(id);
    }

    @Override
    public List<ExcanCandidate> findAll() {
        return this.store.retrieveAll();
    }

    @Override
    public List<ExcanCandidate> findCandidateList(SearchCandidateDto searchDto) {
        List<Tuple> resultList =  this.store.retrieveByCond(searchDto);
        List<ExcanCandidate> resultDtoList = new ArrayList<>();
        ExcanCandidate resultItemDto;
        for (Tuple object : resultList) {
            resultItemDto = new ExcanCandidate(object);
            resultDtoList.add(resultItemDto);
        }
        return resultDtoList;
    }

    @Override
    public ExcanCandidate register(ExcanCandidate entity) {
        return this.store.create(entity);
    }

    @Override
    public void modify(ExcanCandidate entityList) {
        this.store.update(entityList);
    }

    @Override
    public void remove(int id) {
        this.store.delete(id);
    }

    /**
     * @return
     */
    @Override
    public List<ExcanCandidate> getCanCheckingListForDashboard() {
        List<Tuple> list = this.store.getCanCheckingListForDashboard();
        List<ExcanCandidate> resultList = new ArrayList<>();
        for (Tuple object : list) {
            resultList.add(new ExcanCandidate(object));
        }

        return resultList;
    }

    /**
     * @return
     */
    @Override
    public List<ExcanCandidate> getCanResultListForDashboard() {
        List<Tuple> list = this.store.getCanResultListForDashboard();
        List<ExcanCandidate> resultList = new ArrayList<>();
        for (Tuple object : list) {
            resultList.add(new ExcanCandidate(object));
        }

        return resultList;
    }
}
