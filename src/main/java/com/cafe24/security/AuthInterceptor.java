package com.cafe24.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cafe24.jblog.vo.UsersVo;


public class AuthInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle
			(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
		
		if(handler instanceof HandlerMethod == false) {
			System.out.println(handler);
			return true;
		}
		
		HandlerMethod handlerMethod = (HandlerMethod)handler;
		
		Auth auth = handlerMethod.getMethodAnnotation(Auth.class);
		
		if(auth == null) {
			return true;
		}
		
		HttpSession session = request.getSession();
		
		if(session == null) { // 인증이 안됨
			response.sendRedirect(request.getContextPath()+"/user/login");
			return false;
		}
		
		UsersVo authuser =(UsersVo) session.getAttribute("authuser");
		
		if(authuser == null) {
			response.sendRedirect(request.getContextPath()+"/user/login");
			return false;
		}
		
		return true;
	}
}
