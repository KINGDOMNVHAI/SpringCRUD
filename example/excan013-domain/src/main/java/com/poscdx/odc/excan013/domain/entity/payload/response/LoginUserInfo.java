package com.poscdx.odc.excan013.domain.entity.payload.response;

import com.poscdx.odc.excan013.domain.entity.ExcanRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserInfo {
    private String id;
    private String username;
    private String email;
    private int roleId;
    private String roleName;
    private String avatar;
}
