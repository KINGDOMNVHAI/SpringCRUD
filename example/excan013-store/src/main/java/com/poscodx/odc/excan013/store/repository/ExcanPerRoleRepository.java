package com.poscodx.odc.excan013.store.repository;

import com.poscodx.odc.excan013.store.jpo.ExcanPerRoleJpo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ExcanPerRoleRepository
    extends JpaRepository<ExcanPerRoleJpo, Integer>
{
    List<ExcanPerRoleJpo> findByRoleId(int id);
}
