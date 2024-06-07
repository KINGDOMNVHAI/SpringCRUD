package com.poscodx.odc.excan013.store.repository;

import com.poscodx.odc.excan013.store.jpo.ExcanRoleJpo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ExcanRoleRepository
    extends JpaRepository<ExcanRoleJpo, Integer>
{
    Optional<ExcanRoleJpo> findById(Integer id);
    List<ExcanRoleJpo> findByName(String name);
}
