package com.cafe24.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.jblog.repository.BlogDao;
import com.cafe24.jblog.repository.CategoryDao;
import com.cafe24.jblog.repository.UserDao;
import com.cafe24.jblog.vo.UsersVo;

@Service
public class UserService {
	@Autowired
	private UserDao userdao;
	@Autowired
	private BlogDao blogdao;
	@Autowired
	private CategoryDao categorydao;
	
	@Transactional
	public int joinMember(UsersVo usersvo) {
		int result1 =  userdao.join(usersvo);
		int result2 = blogdao.createBlog(usersvo);
		int result3 = categorydao.createDefaultCategory(usersvo);
		return result1*result2*result3;
	}

	public Boolean existId(String id) {
		UsersVo usersVo = userdao.get(id);
		return usersVo != null;
	}

	
	public UsersVo getUser(UsersVo usersVo) {
		return userdao.getByIdAndPw(usersVo);
	}

	public List<UsersVo> showUserList(String key) {
		return userdao.getUserListBykey(key);
	}

	public List<UsersVo> showUserList() {
		return userdao.getUserListBykey();
	}

}
