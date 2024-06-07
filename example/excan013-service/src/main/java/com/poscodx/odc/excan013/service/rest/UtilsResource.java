package com.poscodx.odc.excan013.service.rest;

import com.poscdx.odc.excan013.domain.entity.ExcanMenu;
import com.poscdx.odc.excan013.domain.lifecycle.ServiceLifecycle;
import com.poscdx.odc.excan013.domain.spec.UtilsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/utils")
public class UtilsResource {

    @Value("${minio.bucketName}")
    private String bucketName;

    private final UtilsService utilsService;
    private final ServiceLifecycle serviceLifecycle;

    @PostMapping(path = "/upload/{service}")
    public String uploadFile(@PathVariable("service") String serviceName,
                             @RequestParam("file") MultipartFile image) {
        return utilsService.uploadFile(bucketName, serviceName, image);
    }

    @CrossOrigin
    @PostMapping(path = "/file-delete/{service}")
    public String deleteFile(@PathVariable("service") String serviceName,
                             @RequestBody List<String> filenameList) {
        return utilsService.removeFile(bucketName, serviceName, filenameList);
    }

    @PostMapping(path = "/left-menu")
    public List<ExcanMenu> getLeftMenuByPermission(@RequestBody List<Integer> permissionList) {
        return serviceLifecycle.requestExcanMenuService().getLeftMenuByPermission(permissionList);
    }

}
