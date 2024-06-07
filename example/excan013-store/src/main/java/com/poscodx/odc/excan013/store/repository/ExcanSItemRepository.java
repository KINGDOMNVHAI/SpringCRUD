package com.poscodx.odc.excan013.store.repository;

import com.poscodx.odc.excan013.store.jpo.ExcanSItemJpo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExcanSItemRepository
    extends JpaRepository<ExcanSItemJpo, Integer>
{
    @Query(nativeQuery = true,
            value = "SELECT " +
                    "  T1.ID " +
                    "  , T1.CATEGORY_ID " +
                    "  , T1.LEVEL " +
                    "  , T1.NUMBER_OF_QUESTION " +
                    "  , T1.STATUS " +
                    "FROM tb_excan_setting_item T1 " +
                    "WHERE " +
                    "  T1.DELETE_AT IS NULL " +
                    "  AND T1.SETTING_ID = ?1 ")
    List<Object[]> search(String settingId);

    @Modifying
    @Query("update ExcanSItem e set e.deleteAt = NOW() where id = ?1")
    int deleteById(int id);

    @Modifying
    @Query("update ExcanSItem e set e.deleteAt = NOW() where settingId = ?1")
    int deleteBySettingId(int id);
}
