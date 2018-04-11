package com.cni.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cni.entity.SysUserinfo;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;



public class ControllerInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		
		HttpSession session = request.getSession();
		// 获得用户请求的URI
        String path = request.getRequestURI();
        // 从session里取员工工号信息
        SysUserinfo user = (SysUserinfo)session.getAttribute("user");
//        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/";
        
        // 登陆页面无需过滤	
        // 已登录页面无需过滤
        if(user != null) {
            //chain.doFilter(servletRequest, servletResponse);
        	return true;
        }else{	
        	return false;
            // 跳转到登陆页面
//            response.setContentType("text/html;charset=utf-8");
//            response.getWriter().print("<script type='text/javascript'>window.parent.location='"+basePath+"login.jsp'</script>");
        }
	}
	
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}


	
}
