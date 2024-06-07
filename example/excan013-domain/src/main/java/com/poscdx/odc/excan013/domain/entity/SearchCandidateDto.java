package com.poscdx.odc.excan013.domain.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SearchCandidateDto {

    private String name;
    private int[] status;
    private String email;
    private int score;
    private String createAt;
    private String interviewDateFrom;
    private String interviewDateTo;
}
