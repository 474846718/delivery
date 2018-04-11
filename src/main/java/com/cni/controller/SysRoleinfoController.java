package com.cni.controller;

import com.cni.entity.SysRoleinfo;
import com.cni.service.SysRoleinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("role")
public class SysRoleinfoController {

	private final SysRoleinfoService sysRoleinfoService;

	@Autowired
	public SysRoleinfoController(SysRoleinfoService sysRoleinfoService) {
		this.sysRoleinfoService = sysRoleinfoService;
	}

	@RequestMapping("/findByAll")
	@ResponseBody
	public Map<String, Object> findByAll(){
		return sysRoleinfoService.findByAll();
	}
	
	@RequestMapping("/save")
	@ResponseBody
	Map<String, Object> save(SysRoleinfo roleinfo){
		return sysRoleinfoService.save(roleinfo);
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	Map<String, Object> delete(Integer id){
		return sysRoleinfoService.delete(id);
	}
}
