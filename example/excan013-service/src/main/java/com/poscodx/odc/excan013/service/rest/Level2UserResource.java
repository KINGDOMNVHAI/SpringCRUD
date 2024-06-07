package com.poscodx.odc.excan013.service.rest;

import com.poscdx.odc.excan013.domain.entity.EStatus;
import com.poscdx.odc.excan013.domain.entity.ExcanUser;
import com.poscdx.odc.excan013.domain.entity.payload.response.UserResponse;
import com.poscdx.odc.excan013.domain.lifecycle.ServiceLifecycle;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
//@CrossOrigin(origins = "${cross.origins}")
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class Level2UserResource {

    private final ServiceLifecycle serviceLifecycle;
    private final PasswordEncoder encoder;

    @PostMapping("")
    @PreAuthorize("hasAuthority('ADD_USER')")
    public ResponseEntity<?> addNewUser(@Valid @RequestBody ExcanUser excanUser){
        excanUser.setPassword(encoder.encode(excanUser.getPassword()));
        UserResponse result = serviceLifecycle.requestLevel2UserService().addUser(excanUser);
        return ResponseEntity.status(result.getCode())
                .body(result);
    }

//    @PostMapping("/{serviceName}/file")
//    public ResponseEntity<?> uploadImageAvatar(@PathVariable String serviceName
//            ,@RequestParam("file") MultipartFile image){
//
//        System.out.println("MultipartFile: "+image+image.getOriginalFilename());
//        ModelAndView mav = new ModelAndView("jsonView");
//        serviceName += "/avatar";
//        Map<String, Object> glueResult = Utils.uploadFile(serviceName, image);
//
//        mav.addAllObjects(glueResult);
//        return ResponseEntity.status(HttpStatus.OK)
//                .body(mav);
//    }

//    @GetMapping("/{serviceName}/file/{fileName:.+}")
//    public ResponseEntity<?> getImageAvatar(@PathVariable String fileName
//            ,@PathVariable String serviceName){
//
//        ResponseEntity<Resource>  result = Utils.getFile(serviceName,fileName);
//        return ResponseEntity.status(HttpStatus.OK)
//                .body(result);
//    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('GET_USER')")
    public ResponseEntity<?> getAllUser(){
        UserResponse result = serviceLifecycle.requestLevel2UserService().findAll();
        return ResponseEntity.status(result.getCode())
                .body(result);
    }

    @GetMapping("")
    @PreAuthorize("hasAuthority('GET_USER')")
    public ResponseEntity<?> getUserById(@RequestParam String id){
        UserResponse result = serviceLifecycle.requestLevel2UserService().getUserResponseById(id);
        return ResponseEntity.status(result.getCode())
                .body(result);
    }

    @GetMapping("/byCondition")
    @PreAuthorize("hasAuthority('GET_USER')")
    public ResponseEntity<?> getUserByCondition(@RequestParam String userName, @RequestParam String roleId, @RequestParam String statusId){
        UserResponse result = serviceLifecycle.requestLevel2UserService().getUserByCondition(userName, roleId, statusId);
        return ResponseEntity.status(result.getCode())
                .body(result);
    }

    @PutMapping("")
    @PreAuthorize("hasAuthority('UPDATE_USER')")
    public ResponseEntity<?> updateUser(@RequestBody ExcanUser excanUser){
        if(String.valueOf(excanUser.getPassword()).isEmpty()){
            ExcanUser cacheUser = serviceLifecycle.requestLevel2UserService().findById(excanUser.getId());
            if(cacheUser!=null)
                excanUser.setPassword(cacheUser.getPassword());
        }else {
            excanUser.setPassword(encoder.encode(excanUser.getPassword()));
        }
        UserResponse result = serviceLifecycle.requestLevel2UserService().update(excanUser);

        return ResponseEntity.status(result.getCode())
                .body(result);
    }

    @DeleteMapping("")
    @PreAuthorize("hasAuthority('DELETE_USER')")
    public ResponseEntity<?> deleteUserById(@RequestParam String id){
        String result = serviceLifecycle.requestLevel2UserService().deleteUserById(id);
        return ResponseEntity.status(HttpStatus.OK.value())
                .body(result);
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
