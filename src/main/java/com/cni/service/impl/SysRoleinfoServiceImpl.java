package com.cni.service.impl;

import com.cni.entity.SysRoleinfo;
import com.cni.mapper.SysRoleinfoMapper;
import com.cni.service.SysRoleinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysRoleinfoServiceImpl implements SysRoleinfoService {

	private final SysRoleinfoMapper sysRoleinfoMapper;

	@Autowired
	public SysRoleinfoServiceImpl(SysRoleinfoMapper sysRoleinfoMapper) {
		this.sysRoleinfoMapper = sysRoleinfoMapper;
	}

	/**
	 * 查询所有角色
	 */
	@Override
	public Map<String, Object> findByAll() {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			List<SysRoleinfo> list = sysRoleinfoMapper.findByAll();
			map.put("list", list);
			map.put("status", "success");
		}catch(Exception e){
			map.put("status", "fail");
			e.printStackTrace();
		}
		
		return map;
	}

	/**
	 * 保存角色信息
	 */
	@Override
	public Map<String, Object> save(SysRoleinfo roleinfo) {
		Map<String, Object> map = new HashMap<String, Object>();
		int result = 0;
		if(roleinfo.getId() == null){
			result = sysRoleinfoMapper.insert(roleinfo);
		}else{
			result = sysRoleinfoMapper.updateByPrimaryKeySelective(roleinfo);
		}
		
		if(result > 0){
			map.put("status", "success");
			map.put("msg", "保存成功");
		}else{
			map.put("status", "fail");
			map.put("msg", "保存失败");
		}
		
		return map;
	}

	/**
	 * 根据角色Id删除一条角色信息
	 */
	@Override
	public Map<String, Object> delete(Integer id) {
		Map<String, Object> map = new HashMap<String,Object>();
		int result = sysRoleinfoMapper.deleteByPrimaryKey(id);
		if(result > 0){
			map.put("status", "success");
			map.put("msg", "删除成功");
		}else{
			map.put("status", "fail");
			map.put("msg", "删除失败");
		}
		return map;
	}

}
