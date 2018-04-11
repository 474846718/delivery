package com.cni.service;

import com.cni.entity.SysUserinfo;

import javax.servlet.http.HttpSession;
import java.util.Map;

public interface SysUserinfoService {

	Map<String, Object> delete(Integer id);

    Map<String, Object> save(SysUserinfo record);

    Map<String, Object> findByAll(SysUserinfo record);
    
    Map<String, Object> login(SysUserinfo userinfo,HttpSession session);
    
    Map<String, Object> verifyUnique(String account);
}
