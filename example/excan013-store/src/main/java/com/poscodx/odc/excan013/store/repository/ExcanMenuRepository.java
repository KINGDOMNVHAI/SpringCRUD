package com.poscodx.odc.excan013.store.repository;

import com.poscodx.odc.excan013.store.jpo.ExcanMenuJpo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExcanMenuRepository
    extends JpaRepository<ExcanMenuJpo, Integer>
{

    @Query(value= "SELECT M.*\n" +
            "FROM TB_EXCAN_MENU M\n" +
            "WHERE M.PERMISSION_GROUP IN :permissionList", nativeQuery = true)
    List<ExcanMenuJpo> getLeftMenuByPermission(@Param("permissionList")List<Integer> permissionList);
}
