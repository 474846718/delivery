package com.cni.mapper;

import com.cni.entity.UserInfo;
import com.github.pagehelper.Page;

public interface UserInfoMapper {

    //分页查找
    Page<UserInfo> findByPage();

    //插入用户信息
    boolean insertUserInfo(UserInfo userInfo);

}
