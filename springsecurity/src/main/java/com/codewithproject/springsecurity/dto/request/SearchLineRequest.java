package com.codewithproject.springsecurity.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchLineRequest {
    private String email;
    private String brandCD;
    private Integer pageNum;
    private Integer pageSize;
}
