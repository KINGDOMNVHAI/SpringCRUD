package com.poscdx.odc.excan013.domain.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SettingSearchDTO {
    private String name;
    private String createdDateFrom;
    private String createdDateTo;
    private String status;
}
