package com.poscdx.odc.excan013.domain.entity.enums;

/**
 * Enum representing the status of a candidate.
 * @author 202304_Cuong
 * @since 2024-1-2
 */
public enum CandidateStatus {
    NEW(1),
    PASS(2),
    PENDING(3),
    REJECT(4),
    CHECKING(5);
    private int value;
    CandidateStatus(int value) {
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

}
