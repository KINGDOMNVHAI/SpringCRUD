package com.codewithproject.springsecurity.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponseContentDto {
    private List<Object> content;
}
