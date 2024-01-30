package com.codewithproject.springsecurity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@AllArgsConstructor
@Getter
public enum TypeQuestion {
    MULTI_CHOICE_RADIO(1),
    MULTI_CHOICE_CHECKBOX(2),
    ESSAY(3)
    ;

    private final Integer value;

    public static TypeQuestion of(int status) {
        return Stream.of(TypeQuestion.values())
                .filter(p -> p.getValue() == status)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
