package com.cni.service.impl;

import com.cni.entity.UserInfo;
import com.cni.mapper.UserInfoMapper;
import com.cni.service.UserInfoService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserInfoServiceImpl implements UserInfoService {

    private final UserInfoMapper userInfoMapper;

    @Autowired
    public UserInfoServiceImpl(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }

    @Override
    public Page<UserInfo> findByPage(int pageNum, int size) {
        PageHelper.startPage(pageNum, size);
        return userInfoMapper.findByPage();
    }

    @Override
    public boolean insertUserInfo(UserInfo userInfo) {
        return userInfoMapper.insertUserInfo(userInfo);
    }

}
