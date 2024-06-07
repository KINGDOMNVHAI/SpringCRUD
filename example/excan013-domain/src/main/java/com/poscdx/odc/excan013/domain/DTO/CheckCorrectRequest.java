package com.poscdx.odc.excan013.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CheckCorrectRequest {
    private int examId;
    private int questionId;
    private int questionStatus;
}
