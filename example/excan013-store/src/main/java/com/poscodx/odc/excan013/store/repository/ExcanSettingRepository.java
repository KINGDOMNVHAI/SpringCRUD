package com.poscodx.odc.excan013.store.repository;

import com.poscodx.odc.excan013.store.jpo.ExcanSettingJpo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExcanSettingRepository
    extends JpaRepository<ExcanSettingJpo, Integer>
{
    List<ExcanSettingJpo> findByName(String name);

    @Query(nativeQuery = true,
            value = "SELECT " +
                    "  ID " +
                    "  , NAME " +
                    "  , DURATION " +
                    "  , NUMBER_OF_QUESTION " +
                    "  , DESCRIPTION " +
                    "  , STATUS " +
                    "  , CREATE_BY " +
                    "  , CREATE_AT " +
                    "FROM tb_excan_setting T1 " +
                    "WHERE " +
                    "  T1.DELETE_AT IS NULL " +
                    "  AND (?1 IS NULL OR T1.NAME = ?1) " +
                    "  AND (?2 IS NULL OR T1.CREATE_AT >= ?2) " +
                    "  AND (?3 IS NULL OR T1.CREATE_AT <= ?3) " +
                    "  AND (?4 IS NULL OR T1.STATUS = ?4) ")
    List<Object[]> search(String name, String createDateFrom, String createDateTo, String status);

    @Modifying
    @Query("update ExcanSetting e set e.deleteAt = NOW() where id = ?1")
    int deleteById(int id);
}
