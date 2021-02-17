package com.otp.gettin.gettin.Controllers;


import com.otp.gettin.gettin.Entities.GroupGettin;
import com.otp.gettin.gettin.Entities.UserGettin;
import com.otp.gettin.gettin.Services.GroupGettinServices;
import com.otp.gettin.gettin.Services.UserGettinServices;
import com.otp.gettin.gettin.Utils.EncryptionClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerRest {

    @Autowired
    UserGettinServices userGettinServices;

    @Autowired
    GroupGettinServices groupGettinServices;


    @PostMapping("/saveUserGettin")
    public UserGettin saveUserGettinRest(UserGettin userGettin){
        return userGettinServices.saveUserGettin(userGettin);
    }

    @PostMapping("/saveGroupGettin")
    public GroupGettin saveGroupGettinRest(GroupGettin groupGettin){
        return groupGettinServices.saveGroupGettin(groupGettin);
    }


}
