package com.poscodx.odc.excan013.store.jpo;

import com.poscdx.odc.excan013.domain.entity.ExcanPerRole;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Getter
@Setter
@Entity(name = "ExcanPermissionRole")
@Table(name = "TB_EXCAN_PERMISSION_ROLE", schema = "EXCAN013")
public class ExcanPerRoleJpo
{
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "ROLE_ID")
    private int roleId;
    @Column(name = "PERMISSION_ID")
    private int permissionId;

    public ExcanPerRoleJpo() {
    }

    public ExcanPerRoleJpo(ExcanPerRole entity) {
        BeanUtils.copyProperties(entity, this);
    }

    public ExcanPerRole toDomain() {
        ExcanPerRole retVal = new ExcanPerRole();
        BeanUtils.copyProperties(this, retVal);
        return retVal;
    }

    public static List<ExcanPerRole> toDomains(Iterable<ExcanPerRoleJpo> jpos) {
        return StreamSupport.stream(jpos.spliterator(), false).map((ExcanPerRoleJpo::toDomain)).collect(Collectors.toList());
    }

//    @Override
//    public void validateJpo()
//        throws PosBaseException
//    {
//    }
}
