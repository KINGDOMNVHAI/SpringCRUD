package com.poscdx.odc.excan013.domain.logic;

import com.poscdx.odc.excan013.domain.entity.ExcanUser;
import com.poscdx.odc.excan013.domain.entity.payload.response.UserResponse;
import com.poscdx.odc.excan013.domain.spec.Level2UserService;
import com.poscdx.odc.excan013.domain.store.ExcanRoleStore;
import com.poscdx.odc.excan013.domain.store.ExcanUserStore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpStatus;
import org.apache.poi.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import com.poscdx.odc.excan013.domain.utils.Constants;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@AllArgsConstructor
@NoArgsConstructor
public class Level2UserLogic implements Level2UserService {

    @Autowired
    private ExcanUserStore excanUserStore;
    @Autowired
    private ExcanRoleStore excanRoleStore;

    @Override
    public Boolean existsByName(String name) {
        return excanUserStore.existsByName(name);
    }

    @Override
    public UserResponse addUser(ExcanUser excanUser) {
        UserResponse result = new UserResponse();
        if(excanUserStore.findById(excanUser.getId()) != null){
            result.setCode(HttpStatus.SC_BAD_REQUEST);
            result.setMessage("User Id " + excanUser.getId() + " already exist!");
        }else if(excanRoleStore.findById(excanUser.getRoleId()) == null){
            result.setCode(HttpStatus.SC_BAD_REQUEST);
            result.setMessage("Role Id " + excanUser.getRoleId() + " not exist!");
        } else if(excanUserStore.existsByEmail(excanUser.getEmail())){
            result.setCode(HttpStatus.SC_BAD_REQUEST);
            result.setMessage("Email " + excanUser.getEmail() + " already exist, chose different email pls!");
        } else if(excanUserStore.existsByName(excanUser.getName())){
            result.setCode(HttpStatus.SC_BAD_REQUEST);
            result.setMessage("User name " + excanUser.getName() + " already exist, chose different email pls!");
        } else {
            excanUser.setCreateAt(new Date());
            excanUser.setUpdateAt(new Date());
            excanUserStore.create(excanUser);
            result.setCode(HttpStatus.SC_CREATED);
            List<ExcanUser> data = new ArrayList<>();
            data.add(excanUser);
            result.setData(data);
            result.setMessage("Create user successfully!");
        }
        return result;
    }
    @Override
    public ExcanUser findById(String id) {
        return ProcessUpdateByInfo(excanUserStore.findById(id));
    }

    @Override
    public UserResponse getUserResponseById(String id) {
        UserResponse result = new UserResponse();
        //set response
        List<ExcanUser> data = new ArrayList<>();
        data.add(this.findById(id));
        result.setData(data);
        result.setCode(HttpStatus.SC_OK);
        result.setMessage("Get all user successfully!");
        return result;
    }

    @Override
    public UserResponse getUserByCondition(String userName, String roleId, String statusId) {
        UserResponse result = new UserResponse();
        List<ExcanUser> searchUsers = excanUserStore.findAll();

        searchUsers = searchUsers.stream().filter(i -> StringUtils.containsIgnoreCase(i.getName(), userName)).collect(Collectors.toList());
        if(!roleId.equalsIgnoreCase("all")){
            searchUsers = searchUsers.stream().filter(i -> i.getRoleId() == Integer.parseInt(roleId)).collect(Collectors.toList());
        }
        if(!statusId.equalsIgnoreCase("all")){
            searchUsers = searchUsers.stream().filter(i -> i.getStatus() == Integer.parseInt(statusId)).collect(Collectors.toList());
        }
        result.setData(ProcessUpdateByInfo(searchUsers));
        result.setCode(HttpStatus.SC_OK);
        result.setMessage("Get user by condition successfully!");

        return result;
    }

    @Override
    public UserResponse update(ExcanUser excanUser) {
        UserResponse result = new UserResponse();
        if(excanUserStore.findById(excanUser.getId()) != null){

            if(excanRoleStore.findById(excanUser.getRoleId()) == null){
                result.setCode(HttpStatus.SC_BAD_REQUEST);
                result.setMessage("Role Id " + excanUser.getRoleId() + " not exist!");
            } else if(existEmailWithOutCurrentEmail(excanUser.getId(), excanUser.getEmail())){
                result.setCode(HttpStatus.SC_BAD_REQUEST);
                result.setMessage("Email " + excanUser.getEmail() + " already exist, chose different email pls!");
            } else if(existNameWithOutCurrentName(excanUser.getId(), excanUser.getName())){
                result.setCode(HttpStatus.SC_BAD_REQUEST);
                result.setMessage("User name " + excanUser.getName() + " already exist, chose different email pls!");
            } else {
                excanUser.setUpdateAt(new Date());
                excanUser.setUpdateBy(excanUser.getActionBy());
                excanUserStore.update(excanUser);
                result.setCode(HttpStatus.SC_OK);
                List<ExcanUser> data = new ArrayList<>();
                data.add(excanUser);
                result.setData(data);
                result.setMessage("Update user successfully!");
            }
        } else {
            result.setCode(HttpStatus.SC_OK);
            result.setMessage("User Id " + excanUser.getId() + " not exits!");
        }
        return result;
    }

    private List<ExcanUser>  ProcessUpdateByInfo(List<ExcanUser>  excanUserList){
        //get update by info
        for (ExcanUser user: excanUserList) {
            String ActionId = user.getUpdateBy();
            if(ActionId ==null) ActionId = user.getCreateBy();
            if (ActionId ==null) continue;
            ExcanUser createByUser =  excanUserStore.findById(ActionId);
            if(createByUser!=null){
                user.setUpdateByName(createByUser.getName());
                user.setUpdateByAvatar(createByUser.getAvatar());
                if(user.getUpdateBy()==null){
                    user.setUpdateBy(createByUser.getId());
                }
            }
        }
        return excanUserList;
    }
    private ExcanUser  ProcessUpdateByInfo(ExcanUser  excanUser){
        //get update by info
            String ActionId = excanUser.getUpdateBy();
            if(ActionId ==null) ActionId = excanUser.getCreateBy();
            ExcanUser createByUser =  excanUserStore.findById(ActionId);
            if(createByUser!=null){
                excanUser.setUpdateByName(createByUser.getName());
                excanUser.setUpdateByAvatar(createByUser.getAvatar());
                if(excanUser.getUpdateBy()==null){
                    excanUser.setUpdateBy(createByUser.getId());
                }
            }
        return excanUser;
    }
    public boolean existEmailWithOutCurrentEmail(String id, String email){
        ExcanUser currentUser = excanUserStore.findById(id);
        if(currentUser.getEmail().equals(email)){
            return false;
        } else {
            List<ExcanUser> allUser = excanUserStore.findAll();
            List<String> allEmail = allUser.stream().map(ExcanUser::getEmail).collect(Collectors.toList());
            return allEmail.contains(email);
        }
    }

    public boolean existNameWithOutCurrentName(String id, String name){
        ExcanUser currentUser = excanUserStore.findById(id);
        if(currentUser.getName().equals(name)){
            return false;
        } else {
            List<ExcanUser> allUser = excanUserStore.findAll();
            List<String> allName = allUser.stream().map(ExcanUser::getName).collect(Collectors.toList());
            return allName.contains(name);
        }
    }

    @Override
    public UserResponse findAll() {
        UserResponse result = new UserResponse();
        result.setCode(HttpStatus.SC_OK);
        List<ExcanUser> data = excanUserStore.findAll();
        result.setData(ProcessUpdateByInfo(data));
        result.setMessage("Get all user successfully!");
        return result;
    }

    @Override
    public String deleteUserById(String id) {
        String result = "";
        ExcanUser existUser = this.findById(id);
        if(existUser != null){
            excanUserStore.delete(id);
            result = "User with Id " + id + " deleted successfully!";
        } else {
            result = "User with Id " + id + " not exist!";
        }
        return result;
    }
}
