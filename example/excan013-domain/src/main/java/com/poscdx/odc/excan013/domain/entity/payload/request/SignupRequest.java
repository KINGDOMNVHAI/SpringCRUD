package com.poscdx.odc.excan013.domain.entity.payload.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
public class SignupRequest {
  private String id;
  @NotBlank
  @Size(min = 3, max = 20)
//  @JsonProperty("username")
  private String name;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  private String role;

  @NotBlank
  @Size(min = 6, max = 40)
  private String password;

  private String phone;
  private String address;
  private String avatar;
  private String desc;
  private int status;
}
