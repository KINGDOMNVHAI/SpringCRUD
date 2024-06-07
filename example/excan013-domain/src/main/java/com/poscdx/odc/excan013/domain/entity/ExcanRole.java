package com.poscdx.odc.excan013.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class ExcanRole
{
    private Integer id;
//    @Enumerated(EnumType.STRING)
    @NotNull(message = "Role name is required")
    @NotBlank(message = "Role name is required")
    private String name;
    private String desc;
    private int status;
    private Date createAt;
    private String createBy;
    private Date updateAt;
    private String updateBy;
    private Date deleteAt;
    private Set<ExcanPermission> permissions;
}
