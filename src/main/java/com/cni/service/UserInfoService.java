package com.cni.service;

import com.cni.entity.UserInfo;
import com.github.pagehelper.Page;

public interface UserInfoService {
	public Page<UserInfo> findByPage(int pageNum,int size);
	
	//插入用户信息
	public boolean insertUserInfo(UserInfo userInfo);
}
