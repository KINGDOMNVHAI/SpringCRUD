package com.poscodx.odc.excan013.store.repository;

import com.poscodx.odc.excan013.store.jpo.ExcanPermissionJpo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExcanPermissionRepository
    extends JpaRepository<ExcanPermissionJpo, Integer>
{
    Optional<ExcanPermissionJpo> findById(int id);
}
