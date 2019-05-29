package com.cafe24.jblog.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.jblog.service.UserService;
import com.cafe24.jblog.vo.UsersVo;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/join")
	public String join(@ModelAttribute UsersVo userVo) {
		return "user/join";
	}
	
	@PostMapping("/join")
	public String join(
			@ModelAttribute @Valid UsersVo userVo,
			BindingResult bindingResult,
			Model model) {

		if(bindingResult.hasErrors()) {
			model.addAttribute(bindingResult.getModel());
			return "user/join";
		}
		
		int result = userService.joinMember(userVo);
		
		if(result == 1) { // 성공한 경우			
			return "redirect:/user/joinsuccess";
		}
		// 실패한 경우
		model.addAttribute("joinfail", "yes");
		return "user/join";
	}
	
	@GetMapping("/joinsuccess")
	public String joinsuccess() {
		return "/user/joinsuccess";
	}
	
	@GetMapping("/login")
	public String login() {
		return "/user/login";
	}
	
	
	
}
