package com.poscdx.odc.excan013.domain.entity.enums;

public enum QuestionLevel {

    EASY("Easy", 1),
    NORMAL("Normal", 2),
    HARD("Hard", 3),
    VERY_HARD("Very hard", 4);
    public final String name;
    public final int value;

    private QuestionLevel(String name, int value) {
        this.name = name;
        this.value = value;
    }
}
