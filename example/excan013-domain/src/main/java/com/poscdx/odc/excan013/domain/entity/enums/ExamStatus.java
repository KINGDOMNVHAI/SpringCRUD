package com.poscdx.odc.excan013.domain.entity.enums;

public enum ExamStatus {
    NEW(1),
    TESTING(2),
    COMPLETE(3);

    private int value;
    ExamStatus(int value) {
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
