package com.poscdx.odc.excan013.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class ExcanMenu
{
    private Integer id;
    private String menuCode;
    private String menuName;
    private int topMenu;
    private String url;
    private int permissionGroup;
    private String createBy;
    private Date createAt;
    private int status;

}
