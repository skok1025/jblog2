package com.cafe24.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cafe24.jblog.service.UserService;
import com.cafe24.jblog.vo.UsersVo;


public class AuthLoginInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("AuthLoginInterceptor-preHandle");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		ApplicationContext ac = 
					WebApplicationContextUtils.
					getWebApplicationContext(request.getServletContext());
		
		UserService userService = ac.getBean(UserService.class);
				
		UsersVo usersVo = new UsersVo();

		usersVo.setId(id);
		usersVo.setPassword(password);
		
		UsersVo authuser = userService.getUser(usersVo);
		
		if(authuser==null) {
			response.sendRedirect(request.getContextPath()+"/user/login?loginfail=yes");
			return false;
		}
		// 세션 처리
		HttpSession session = request.getSession(true);
		session.setAttribute("authuser", authuser);
		response.sendRedirect(request.getContextPath());
				
		return false;
	}
}

