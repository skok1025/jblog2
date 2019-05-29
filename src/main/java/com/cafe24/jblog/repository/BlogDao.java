package com.cafe24.jblog.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.jblog.vo.BlogVo;
import com.cafe24.jblog.vo.CategoryVo;
import com.cafe24.jblog.vo.PostVo;
import com.cafe24.jblog.vo.UsersVo;

@Repository
public class BlogDao {

	@Autowired
	private SqlSession sqlSession;
	
	public int createBlog(UsersVo usersvo) {
		return sqlSession.insert("blog.insertBlog",usersvo);
	}

	public PostVo getPost(Map<String, Object> map) {
		return sqlSession.selectOne("blog.getPost",map);
	}

	public List<PostVo> getPostList(Map<String, Object> map) {
		return sqlSession.selectList("blog.getPostList", map);
	}

	public BlogVo getBlog(String id) {
		return sqlSession.selectOne("blog.getBlog", id);
	}

	public int updateBlogInfo(BlogVo blogvo) {
		return sqlSession.update("blog.updateBlogInfo", blogvo);
	}

	public int updateBlogInfoExceptImage(BlogVo blogvo) {
		return sqlSession.update("blog.updateBlogInfoExceptImage", blogvo);
	}

	

	
}
