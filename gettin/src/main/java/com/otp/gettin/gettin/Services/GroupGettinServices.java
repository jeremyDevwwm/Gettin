package com.otp.gettin.gettin.Services;

import com.otp.gettin.gettin.Entities.GroupGettin;
import com.otp.gettin.gettin.Repositories.GroupGettinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupGettinServices {

    @Autowired
    GroupGettinRepository groupGettinRepository;

    public GroupGettin saveGroupGettin(GroupGettin groupGettin){
        GroupGettin groupGettinTemplate = new GroupGettin();

        groupGettinTemplate.setGroupName(groupGettin.getGroupName());
        groupGettinTemplate.setGroupTag(groupGettin.getGroupTag());

        return groupGettinRepository.save(groupGettinTemplate);
    }

    public GroupGettin findSingleGroupGettin(long id){
        return groupGettinRepository.findById(id).orElse(null);
    }


}
