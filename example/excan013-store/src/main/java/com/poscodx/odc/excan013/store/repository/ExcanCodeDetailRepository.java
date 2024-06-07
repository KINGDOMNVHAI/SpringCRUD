package com.poscodx.odc.excan013.store.repository;

import com.poscodx.odc.excan013.store.jpo.ExcanCodeDetailJpo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface ExcanCodeDetailRepository extends JpaRepository<ExcanCodeDetailJpo, Integer>
{
    List<ExcanCodeDetailJpo> findByCodeMaster(String codeMaster);

    List<ExcanCodeDetailJpo> findAllByIdIn(List<Integer> id);

    List<ExcanCodeDetailJpo> findAllByIdIn(Set<Integer> id);
}
