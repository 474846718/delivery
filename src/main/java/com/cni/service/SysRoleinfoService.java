package com.cni.service;

import com.cni.entity.SysRoleinfo;

import java.util.Map;

public interface SysRoleinfoService {

	Map<String, Object> findByAll();
	
	Map<String, Object> save(SysRoleinfo roleinfo);
	
	Map<String, Object> delete(Integer id);
}
