package com.poscodx.odc.excan013.store.jpo;

import com.poscdx.odc.excan013.domain.entity.ExcanPermission;
import com.poscdx.odc.excan013.domain.entity.ExcanRole;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Getter
@Setter
@Entity(name = "ExcanRole")
@Table(name = "TB_EXCAN_ROLE", schema = "EXCAN013")
public class ExcanRoleJpo
{
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DESCRIPTION")
    private String desc;
    @Column(name = "STATUS")
    private int status;
    @Column(name = "CREATE_AT")
    private Date createAt;
    @Column(name = "CREATE_BY")
    private String createBy;
    @Column(name = "UPDATE_AT")
    private Date updateAt;
    @Column(name = "UPDATE_BY")
    private String updateBy;
    @Column(name = "DELETE_AT")
    private Date deleteAt;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(  name = "TB_EXCAN_PERMISSION_ROLE",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id"))
    private Set<ExcanPermissionJpo> permissions = new HashSet<>();

    public ExcanRoleJpo() {
    }

    public ExcanRoleJpo(ExcanRole entity) {
        BeanUtils.copyProperties(entity, this);
        if(entity.getName() != null && !entity.getName().isEmpty()){
            this.name = entity.getName();
        }
    }

    public ExcanRole toDomain() {
        ExcanRole retVal = new ExcanRole();
        BeanUtils.copyProperties(this, retVal);
        if(this.name != null){
            retVal.setName(this.name);
        } else {
            retVal.setName("ROLE_USER");
        }
        if(this.permissions != null){
            retVal.setPermissions(this.permissions.stream().map(ExcanPermissionJpo::toDomain).collect(Collectors.toSet()));
        }
        return retVal;
    }

    public static List<ExcanRole> toDomains(Iterable<ExcanRoleJpo> jpos) {
        return StreamSupport.stream(jpos.spliterator(), false).map((ExcanRoleJpo::toDomain)).collect(Collectors.toList());
    }
}
