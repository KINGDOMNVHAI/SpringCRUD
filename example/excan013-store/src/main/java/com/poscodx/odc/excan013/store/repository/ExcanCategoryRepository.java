package com.poscodx.odc.excan013.store.repository;

import com.poscodx.odc.excan013.store.jpo.ExcanCategoryJpo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExcanCategoryRepository
    extends JpaRepository<ExcanCategoryJpo, Integer>
{
}
