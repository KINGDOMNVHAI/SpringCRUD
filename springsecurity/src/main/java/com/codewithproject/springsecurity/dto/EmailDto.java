package com.codewithproject.springsecurity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Annotations
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDto {
    private String recipient;
    private String msgBody;
    private String subject;
    private String attachment;
}
