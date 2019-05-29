package com.cafe24.jblog.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.jblog.vo.CategoryVo;
import com.cafe24.jblog.vo.UsersVo;

@Repository
public class CategoryDao {

	@Autowired
	private SqlSession sqlSession;
	
	public List<CategoryVo> getCategoryList(String id) {
		return sqlSession.selectList("category.getCategoryList",id);
	}

	public int createDefaultCategory(UsersVo usersvo) {
		return sqlSession.insert("category.insertDefaultCategory",usersvo);
	}

	public int deleteCategory(Map<String, Object> map) {
		return sqlSession.delete("category.deleteCategory", map);
	}

	public int insertCategory(CategoryVo categoryvo) {
		return sqlSession.insert("category.insertCategory", categoryvo);
	}


}
