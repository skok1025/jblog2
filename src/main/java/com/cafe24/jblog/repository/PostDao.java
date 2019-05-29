package com.cafe24.jblog.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.jblog.vo.PostVo;

@Repository
public class PostDao {

	@Autowired
	private SqlSession sqlSession;
	
	public int deletePostByCategoryNo(Long no) {
		return sqlSession.delete("post.deletPostByCategoryNo", no);
	}

	public int insertPost(PostVo postvo) {
		return sqlSession.insert("post.insertPost", postvo);
	}

}
