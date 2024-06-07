package com.poscdx.odc.excan013.domain.entity.payload.response;

import com.poscdx.odc.excan013.domain.entity.ExcanPermission;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class JwtResponse {
  private String token;
  private String type = "Bearer";
  private LoginUserInfo userInfo;
  private Map<Integer,List<ExcanPermission>> permissions;

  public JwtResponse(String accessToken, LoginUserInfo userInfo, Map<Integer,List<ExcanPermission>> permissions) {
    this.token = accessToken;
    this.userInfo = userInfo;
    this.permissions = permissions;
  }
}
