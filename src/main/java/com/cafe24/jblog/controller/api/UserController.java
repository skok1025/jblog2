package com.cafe24.jblog.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.jblog.dto.JSONResult;
import com.cafe24.jblog.service.UserService;
import com.cafe24.jblog.vo.UsersVo;


@Controller("UserApiController")
@RequestMapping("/user/api")
public class UserController {
	
	@Autowired 
	private UserService userService;
	
	@ResponseBody
	@RequestMapping("/checkid")
	public JSONResult checkId(@RequestParam(value="id", required=true, defaultValue="") String id) {
		Boolean exist = userService.existId(id);
		return JSONResult.success(exist);
	}
	
//	@RequestMapping("/existids")
//	public @ResponseBody List<UsersVo> existIds(@RequestParam(value="key", required=true, defaultValue="") String key) {
//		List<UsersVo> list = userService.showUserListBykey(key); 
//		return list;
//	}

}
