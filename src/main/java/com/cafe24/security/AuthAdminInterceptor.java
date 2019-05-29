package com.cafe24.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cafe24.jblog.repository.BlogDao;
import com.cafe24.jblog.vo.BlogVo;
import com.cafe24.jblog.vo.UsersVo;

public class AuthAdminInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	private BlogDao blogdao;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("AuthAdminInterceptor-preHandle");
		System.out.println(request.getRequestURI());
		String requestId = request.getRequestURI().split("/")[2];
		
		BlogVo blogvo = blogdao.getBlog(requestId);

		if (handler instanceof HandlerMethod == false) {
			System.out.println(handler);
			return true;
		}

		HttpSession session = request.getSession();

		if (session == null) { // 인증이 안됨
			response.sendRedirect(request.getContextPath() + "/user/login");
			return false;
		}

		UsersVo authuser = (UsersVo) session.getAttribute("authuser");

		if (authuser == null) {
			response.sendRedirect(request.getContextPath() + "/user/login");
			return false;
		}

		if (!authuser.getId().equals(requestId)) {
			response.sendRedirect(request.getContextPath());
			return false;
		}
		request.setAttribute("blogvo", blogvo);
		return true;
	}
}
