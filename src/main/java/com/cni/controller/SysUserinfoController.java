package com.cni.controller;

import com.cni.entity.SysUserinfo;
import com.cni.service.SysUserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class SysUserinfoController {

	private final SysUserinfoService sysUserinfoService;

    @Autowired
    public SysUserinfoController(SysUserinfoService sysUserinfoService) {
        this.sysUserinfoService = sysUserinfoService;
    }

    /**
	 * 保存用户信息
	 * @param sysUserinfo
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public Map<String, Object> save(SysUserinfo sysUserinfo){
		return sysUserinfoService.save(sysUserinfo);
	}
	
	/**
	 * 根据用户id删除指定用户
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Map<String, Object> delete(Integer id){
		return sysUserinfoService.delete(id);
	}
	
	/**
	 * 根据条件查询用户信息
	 * @param sysUserinfo
	 * @return
	 */
	@RequestMapping("/findByAll")
	@ResponseBody
	public Map<String, Object> findByAll(SysUserinfo sysUserinfo){
		return sysUserinfoService.findByAll(sysUserinfo);
	}
	
	/**
	 * 登录
	 * @param userinfo
	 * @param session
	 * @return
	 */
	@RequestMapping("/login")
	public String login(SysUserinfo userinfo,HttpSession session,Model model){
		Map<String, Object> map = sysUserinfoService.login(userinfo, session);
		model.addAttribute("result", map);
		String status = (String) map.get("status");
		if(status.equals("success")){
			SysUserinfo sysUserinfo = (SysUserinfo)session.getAttribute("user");
			return "redirect:/menu/findByUserId?id="+sysUserinfo.getId();
		}else{
			return "login";
		}
	}
	
	@RequestMapping("/verifyUnique")
	@ResponseBody
	public Map<String, Object> verifyUnique(String account){
		return sysUserinfoService.verifyUnique(account);
	}
	
}
