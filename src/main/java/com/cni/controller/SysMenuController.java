package com.cni.controller;

import com.cni.entity.SysMenu;
import com.cni.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/menu")
public class SysMenuController {

	private final SysMenuService sysMenuService;

    @Autowired
    public SysMenuController(SysMenuService sysMenuService) {
        this.sysMenuService = sysMenuService;
    }

    @RequestMapping("/save")
	@ResponseBody
	public Map<String, Object> save(SysMenu sysMenu){
		return sysMenuService.save(sysMenu);
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public Map<String, Object> delete(Integer id){
		return sysMenuService.delete(id);
	}
	
	/**
	 * 根据用户Id查询拥有权限的菜单
	 * @param id id
	 * @param model model
	 * @return String
	 */
	@RequestMapping("/findByUserId")
	public String findByUserId(Integer id,Model model){
		List<SysMenu> menuList = sysMenuService.findByUserId(id);
		model.addAttribute("menuList", menuList);
		return "index"; 
	}
	

	
}
