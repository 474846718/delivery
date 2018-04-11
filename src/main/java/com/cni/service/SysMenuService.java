package com.cni.service;

import com.cni.entity.SysMenu;

import java.util.List;
import java.util.Map;

public interface SysMenuService {
	
	Map<String, Object> delete(Integer id);

	Map<String, Object> save(SysMenu record);

	List<SysMenu> findByUserId(Integer id);
}
