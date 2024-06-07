package com.poscodx.odc.excan013.store.jpo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.poscdx.odc.excan013.domain.entity.ExcanPermission;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.management.relation.Role;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Getter
@Setter
@Entity(name = "ExcanPermission")
@Table(name = "TB_EXCAN_PERMISSION", schema = "EXCAN013")
public class ExcanPermissionJpo
{
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "GROUP")
    private int group;

//    @ManyToMany(mappedBy = "permissions", fetch = FetchType.LAZY)
//    @JsonIgnore
//    Set<ExcanRoleJpo> roles;

    public ExcanPermissionJpo() {
    }

    public ExcanPermissionJpo(ExcanPermission entity) {
        BeanUtils.copyProperties(entity, this);
    }

    public ExcanPermission toDomain() {
        ExcanPermission retVal = new ExcanPermission();
        BeanUtils.copyProperties(this, retVal);
        return retVal;
    }

    public static List<ExcanPermission> toDomains(Iterable<ExcanPermissionJpo> jpos) {
        return StreamSupport.stream(jpos.spliterator(), false).map((ExcanPermissionJpo::toDomain)).collect(Collectors.toList());
    }

//    @Override
//    public void validateJpo()
//        throws PosBaseException
//    {
//    }
}
