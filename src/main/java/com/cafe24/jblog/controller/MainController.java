package com.cafe24.jblog.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.jblog.service.UserService;
import com.cafe24.jblog.vo.BlogVo;
import com.cafe24.jblog.vo.UsersVo;

@Controller
public class MainController {

	@Autowired
	private UserService userService; 
	
	@GetMapping({"/","/main"})
	public String main(Model model) {
		List<UsersVo> userlist = userService.showUserList();
		model.addAttribute("userlist",userlist);
		return "main/index";
	}
	
	@GetMapping("/sh")
	public String searchBlog(
		@RequestParam(value = "keyword",required = true,defaultValue = "") String keyword,
		@RequestParam(value = "which",required = true,defaultValue = "") String which		
	) {
		if("userid".equals(which)) {
			return "redirect:/"+keyword;
		}
		
		return "main/index";
	}
	
}
