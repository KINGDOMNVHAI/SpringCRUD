package com.poscodx.odc.excan013.service.rest;

import com.poscdx.odc.excan013.domain.entity.EStatus;
import com.poscdx.odc.excan013.domain.entity.ExcanPermission;
import com.poscdx.odc.excan013.domain.entity.ExcanRole;
import com.poscdx.odc.excan013.domain.entity.payload.response.RoleResponse;
import com.poscdx.odc.excan013.domain.lifecycle.ServiceLifecycle;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequiredArgsConstructor
//@CrossOrigin(origins = "${cross.origins}")
@CrossOrigin(origins = "*")
@RequestMapping("/role")
public class Level2RoleAndPermissionResource {
    private final ServiceLifecycle serviceLifecycle;

    @GetMapping("/all")
    public ResponseEntity<?> getAllRole(){
        List<ExcanRole> result = serviceLifecycle.requestExcanRoleService().findAll();
        return ResponseEntity.status(HttpStatus.OK)
                .body(result);
    }

    @GetMapping("/byCondition")
    public ResponseEntity<?> getRolesByCondition(@RequestParam String roleName, @RequestParam String statusId){
        RoleResponse result = serviceLifecycle.requestExcanRoleService().findRoleByCondition(roleName, statusId);
        return ResponseEntity.status(result.getCode())
                .body(result);
    }

    @GetMapping("/all-permission")
    public ResponseEntity<?> getAllPermission(){
        List<ExcanPermission> result = serviceLifecycle.requestExcanPermissionService().findAll();
        return ResponseEntity.status(HttpStatus.OK)
                .body(result);
    }

    @GetMapping("/permission")
    public ResponseEntity<?> getPermissionOfRoleByRoleId(@RequestParam int roleId){
        List<ExcanPermission> result = serviceLifecycle.requestExcanPermissionService().findAll();
        return ResponseEntity.status(HttpStatus.OK)
                .body(result);
    }

    @PostMapping("")
    public ResponseEntity<?> addRole(@Valid @RequestBody ExcanRole excanRole){
        excanRole.setCreateAt(new Date());
        RoleResponse result = serviceLifecycle.requestExcanRoleService().addRole(excanRole);
        return ResponseEntity.status(result.getCode())
                .body(result);
    }

    @GetMapping("")
    public ResponseEntity<?> getRoleById(@RequestParam int id){
        ExcanRole result = serviceLifecycle.requestExcanRoleService().find(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(result);
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteRoleById(@RequestParam int id){
        serviceLifecycle.requestExcanRoleService().remove(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Delete role successfully!");
    }

    @PutMapping("")
    public ResponseEntity<?> updateRole(@Valid @RequestBody ExcanRole excanRole){
        excanRole.setUpdateAt(new Date());
        RoleResponse result = serviceLifecycle.requestExcanRoleService().updateRole(excanRole);
        return ResponseEntity.status(result.getCode())
                .body(result);
    }

    @PutMapping("/permission")
    public ResponseEntity<?> updatePermission(@RequestBody ExcanPermission permission){
        List<ExcanPermission> listUpdate = new ArrayList<>();
        listUpdate.add(permission);
        serviceLifecycle.requestExcanPermissionService().modify(listUpdate);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Update permission successfully!");
    }

    @GetMapping("/all-status")
    public ResponseEntity<?> getAllStatus(){
        Map<Integer, String> result = new HashMap<>();
        for(EStatus status : EStatus.values()){
            result.put(status.getValue(), status.name());
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(result);
    }
}
