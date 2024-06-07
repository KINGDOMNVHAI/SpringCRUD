package com.poscdx.odc.excan013.domain.entity;

public enum EStatus {
  ACTIVE(1),
  INACTIVE(2);
  private int value;

  EStatus(int value) {
    this.value = value;
  }

  public int getValue(){
    return this.value;
  }
}
