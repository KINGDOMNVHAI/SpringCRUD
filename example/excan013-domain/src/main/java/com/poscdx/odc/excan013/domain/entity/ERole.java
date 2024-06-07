package com.poscdx.odc.excan013.domain.entity;

public enum ERole {


  ROLE_ADMIN(1),
  ROLE_STAFF(2),
  ROLE_USER(3),
  ROLE_HR(4);

  private int value;

  ERole(int value) {
    this.value = value;
  }

  public int getValue(){
    return this.value;
  }
}
