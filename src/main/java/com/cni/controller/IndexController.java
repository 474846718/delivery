package com.cni.controller;

import com.cni.entity.UserInfo;
import com.cni.service.UserInfoService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName:IndexController
 * @Description:springboot 控制器
 * @author richy
 * @RestController
 * @author richy
 */
@Controller
public class IndexController {
	
	private final UserInfoService userInfoService;

    @Autowired
    public IndexController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    //直接返回json数据格式
	@RequestMapping("/PageUserSelect")
	@ResponseBody
	public PageInfo<UserInfo> PageUserSelect(@RequestParam(value="pageNum",defaultValue="1")int pageNum,
                                             @RequestParam(value="Size",defaultValue="5")int Size  ){
		
		Page<UserInfo> persons = userInfoService.findByPage(pageNum, Size);

        return new PageInfo<>(persons);
		
	}
	
	//将返回的结果显示在页面上
	@RequestMapping("/page")
	public String display(Model model,@RequestParam(value="pageNum",defaultValue="1")int pageNum,  
            @RequestParam(value="Size",defaultValue="5")int Size) {
		
		Page<UserInfo> persons = userInfoService.findByPage(pageNum, Size);
		
		PageInfo<UserInfo> pageInfo = new PageInfo<>(persons);
		
		model.addAttribute("contents",pageInfo);
		return "page";
	}
	
	//测试springboot 赋值给thymeleaf模板
	@RequestMapping("/test_thymeleaf")
	@ResponseBody
	public String testThymeleaf(Model model) {
		String testValue = "这是一个赋值给thymeleaf模板的数据";
		model.addAttribute("content", testValue);
		return "test_thymeleaf";
	}
	
	//显示添加用户简单信息页面 
	@RequestMapping("/add_userinfo")
	public String addUserInfo() {
		
		return "add_userinfo";
		
	}
	
	//保存用户的简单信息
	@RequestMapping(value="/insert_userinfo",method=RequestMethod.POST)
	public String insertUserInfo(UserInfo userInfo) {
		userInfoService.insertUserInfo(userInfo);
		return "success";
	}
	

}
