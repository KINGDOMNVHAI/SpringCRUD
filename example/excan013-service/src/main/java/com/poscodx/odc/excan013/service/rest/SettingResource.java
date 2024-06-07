package com.poscodx.odc.excan013.service.rest;

import com.poscdx.odc.excan013.domain.DTO.SettingSearchDTO;
import com.poscdx.odc.excan013.domain.entity.ExcanSetting;
import com.poscdx.odc.excan013.domain.lifecycle.ServiceLifecycle;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/setting")
public class SettingResource {
    private final ServiceLifecycle serviceLifecycle;
    @GetMapping("{settingId}")
    ExcanSetting getSettingById(@PathVariable("settingId") int settingId) {
        return this.serviceLifecycle.requestExcanSettingService().find(settingId);
    }
}
