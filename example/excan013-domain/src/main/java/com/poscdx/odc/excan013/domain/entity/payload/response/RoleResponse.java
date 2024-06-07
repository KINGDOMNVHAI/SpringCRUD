package com.poscdx.odc.excan013.domain.entity.payload.response;

import com.poscdx.odc.excan013.domain.entity.ExcanRole;
import com.poscdx.odc.excan013.domain.entity.ExcanUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleResponse {
    private Integer code;
    private List<?> data;
    private String message;
}
