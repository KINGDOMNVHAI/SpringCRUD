package com.poscdx.odc.excan013.domain.spec;

import com.poscdx.odc.excan013.domain.entity.ExcanUser;
import com.poscdx.odc.excan013.domain.entity.payload.response.UserResponse;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public interface Level2UserService {
    Boolean existsByName(String name);
    UserResponse addUser(ExcanUser excanUser);
    ExcanUser findById(String id);
    UserResponse getUserResponseById(String id);
    UserResponse getUserByCondition(String userName, String roleId, String statusId);
    UserResponse update(ExcanUser excanUser);
    UserResponse findAll();
    String deleteUserById(String id);

}
