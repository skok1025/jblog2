package com.cafe24.jblog.repository;

import static org.junit.Assert.assertNotNull;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class DaoTest {
	
	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	
	@Autowired
	private BlogDao blogDao;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private PostDao postDao;
	@Autowired
	private UserDao userDao;
	
	
	@Test
	public void testBlogDaoNull() {
		assertNotNull(blogDao);
	}
	
	@Test
	public void testCategoryDaoNull() {
		assertNotNull(categoryDao);
	}
	
	@Test
	public void testPostDaoNull() {
		assertNotNull(postDao);
	}
	
	@Test
	public void testUserDaoNull() {
		assertNotNull(userDao);
	}
	
	@Test
	public void testBlog() {
		blogDao.getBlog("skok1025");
	}
	
}
