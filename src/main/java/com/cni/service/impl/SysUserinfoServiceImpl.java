package com.cni.service.impl;

import com.cni.entity.SysUserinfo;
import com.cni.mapper.SysUserinfoMapper;
import com.cni.service.SysUserinfoService;
import com.cni.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysUserinfoServiceImpl implements SysUserinfoService {

	private final SysUserinfoMapper sysUserinfoMapper;

	@Autowired
	public SysUserinfoServiceImpl(SysUserinfoMapper sysUserinfoMapper) {
		this.sysUserinfoMapper = sysUserinfoMapper;
	}

	/**
	 * 根据主键id删除用户信息
	 */
	@Override
	public Map<String, Object> delete(Integer id) {
		Map<String, Object> map = new HashMap<String, Object>();
		int result = sysUserinfoMapper.deleteByPrimaryKey(id);
		
		if(result < 0){
			map.put("status", "success");
			map.put("msg", "删除成功");
		}else{
			map.put("status", "fail");
			map.put("msg", "删除失败");
		}
		return map;
	}

	/**
	 * 保存或修改用户信息
	 * @author liujianpeng
	 */
	@Override
	public Map<String, Object> save(SysUserinfo record) {
		Map<String, Object> map = new HashMap<String, Object>();
		int result = 0;
		if(record.getId() == null){
			record.setPassword(MD5Util.MD5("admin000"));
			record.setLive(0);
			result = sysUserinfoMapper.insert(record);
		}else{
			result = sysUserinfoMapper.updateByPrimaryKeySelective(record);
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
	 * 根据条件查询所有的用户
	 */
	@Override
	public Map<String, Object> findByAll(SysUserinfo record) {
		Map<String, Object> map = new HashMap<String,Object>();
		try{
			List<SysUserinfo> list = sysUserinfoMapper.findByAll(record);
			map.put("list", list);
			map.put("status", "success");
		}catch(Exception e){
			map.put("status", "fail");
			e.printStackTrace();
		}
		
		return map;
	}

	/**
	 * 用户登录验证
	 */
	@Override
	public Map<String, Object> login(SysUserinfo userinfo,HttpSession session) {
		System.out.println(userinfo.getAccount()+","+userinfo.getPassword());
		Map<String, Object> map = new HashMap<String,Object>();
		List<SysUserinfo> list = sysUserinfoMapper.findByAll(userinfo);
		if(list.size() > 0){
			String password = MD5Util.MD5(userinfo.getPassword());	//登录密码
			SysUserinfo sysuserinfo = list.get(0); 
			if(password.equals(sysuserinfo.getPassword())){
				map.put("status","success");
				map.put("msg", "登陆成功");
				map.put("user", sysuserinfo);
				session.setAttribute("user", sysuserinfo);
				
			}else{
				map.put("status","fail");
				map.put("msg", "密码错误");
			}
		}else{
			map.put("status","fail");
			map.put("msg", "账号错误");
		}
		return map;
	}

	/**
	 * 注册账号验证唯一
	 */
	@Override
	public Map<String, Object> verifyUnique(String account) {
		Map<String, Object> map = new HashMap<String,Object>();
		SysUserinfo record = new SysUserinfo();
		record.setAccount(account);
		List list = sysUserinfoMapper.findByAll(record);
		if(list.size() > 0){
			map.put("status", "fail");
			map.put("msg", "账号已存在");
		}else{
			map.put("status", "success");
			map.put("msg", "该账号可以注册");
		}
		
		return map;
	}

}
