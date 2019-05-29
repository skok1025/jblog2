package com.cafe24.jblog.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.jblog.vo.UsersVo;

@Repository
public class UserDao {

	@Autowired
	private SqlSession sqlSession;
	
	public int join(UsersVo usersvo) {
		return sqlSession.insert("user.join", usersvo);
	}
	

	public UsersVo get(String id) {
		return sqlSession.selectOne("user.getById",id);
	}

	public UsersVo getByIdAndPw(UsersVo usersVo) {
		return sqlSession.selectOne("user.getByIdAndPw",usersVo);
	}


}
