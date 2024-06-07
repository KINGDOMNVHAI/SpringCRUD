package com.poscdx.odc.excan013.domain.entity.enums;

public enum QuestionType {
    ONE_SELECTION("One selection", 1),
    MULTI_SELECTION("Multi selection", 2),
    FILL_IN_THE_BLANK("Fill in the blank", 3),
    SHORT_ANSWER("Short answer", 4);
    public final String name;
    public final int value;

    private QuestionType(String name, int value) {
        this.name = name;
        this.value = value;
    }

}
