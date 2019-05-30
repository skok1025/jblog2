package com.cafe24.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cafe24.jblog.repository.BlogDao;
import com.cafe24.jblog.repository.UserDao;
import com.cafe24.jblog.vo.BlogVo;
import com.cafe24.jblog.vo.UsersVo;

public class AuthAdminInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	private BlogDao blogdao;
	@Autowired
	private UserDao userdao;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("AuthAdminInterceptor-preHandle");
		System.out.println(request.getRequestURI());
		System.out.println(request.getRequestURI().split("/").length);
		
		
		if(request.getRequestURI().split("/").length<=2) {
			return true;
		}
		if("logos".equals(request.getRequestURI().split("/")[2])) {
			return true;
		}
		if (handler instanceof HandlerMethod == false) {
			System.out.println(handler);
			return true;
		}
		
//		if("user".equals(request.getRequestURI().split("/")[2]) && request.getRequestURI().split("/").length==3) {
//			response.sendRedirect(request.getContextPath());
//			return false;
//		}
		
		String requestId = request.getRequestURI().split("/")[2];
		System.out.println(requestId);
		
		if("user".equals(requestId)) {
			response.sendRedirect(request.getContextPath());
			return false;
		}
		
		Boolean isIdExist = userdao.isIdExist(requestId);
		
		if(!isIdExist) {
			
			//response.sendRedirect(request.getContextPath());
			response.sendError(response.SC_NOT_FOUND);
			return false;
		}
		
		BlogVo blogvo = blogdao.getBlog(requestId);

		
		HttpSession session = request.getSession();
		if(request.getRequestURI().split("/").length>3) {
			boolean isAdmin = "admin".equals(request.getRequestURI().split("/")[3]);
		
			if (isAdmin && session == null) { // 인증이 안됨
				response.sendRedirect(request.getContextPath() + "/user/login");
				return false;
			}
	
			UsersVo authuser = (UsersVo) session.getAttribute("authuser");
	
			
			if (isAdmin && authuser == null) {
				response.sendRedirect(request.getContextPath() + "/user/login");
				return false;
			}
			if (isAdmin && !authuser.getId().equals(requestId)) {
				response.sendRedirect(request.getContextPath());
				return false;
			}
		}
		request.setAttribute("blogvo", blogvo);
		return true;
	}
}
