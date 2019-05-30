package com.cafe24.jblog.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.jblog.repository.BlogDao;
import com.cafe24.jblog.repository.CategoryDao;
import com.cafe24.jblog.repository.PostDao;
import com.cafe24.jblog.vo.BlogVo;
import com.cafe24.jblog.vo.CategoryVo;
import com.cafe24.jblog.vo.PostVo;

@Service
public class BlogService {
	
	private static final String SAVE_PATH = "/jblog-uploads";
	@Autowired
	private BlogDao blogdao;
	
	@Autowired
	private PostDao postdao;
	
	@Autowired
	private CategoryDao categorydao;

	public PostVo showPost(String id,Long categoryOrder,Long postOrder) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("postOrder", postOrder);
		map.put("categoryOrder",categoryOrder);
		return blogdao.getPost(map);
	}

	public List<PostVo> showPostList(String id,Long categoryOrder) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("categoryOrder", categoryOrder);
		return blogdao.getPostList(map);
	}

	public List<CategoryVo> showCategoryList(String id) {
		return categorydao.getCategoryList(id);
	}

	public BlogVo getBlogInfo(String id) {
		BlogVo blogVo =  blogdao.getBlog(id);
		//blogVo.setTitle(blogVo.getTitle().replaceAll("&lt", "<"));
		return blogVo;
	}

	public int updateBlogBasicInfo(String blogId,BlogVo blogvo) {
		System.out.println(blogvo.getAttach());
		blogvo.setTitle(blogvo.getTitle().replaceAll("(?i)<script", "&lt;script"));
		try {
			if(!blogvo.getAttach().isEmpty()) {
				String logo = blogvo.getAttach().getOriginalFilename();
				byte[] fileData = blogvo.getAttach().getBytes();
				
				OutputStream os = new FileOutputStream(SAVE_PATH+"/"+logo);
				os.write(fileData);
				os.close();
				
				blogvo.setLogo(logo);
			}
			blogvo.setId(blogId);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(blogvo.getAttach().isEmpty()) {
			return blogdao.updateBlogInfoExceptImage(blogvo);
		}
		return blogdao.updateBlogInfo(blogvo);
	}

	@Transactional
	public int deleteCategory(String id, Long no) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("no", no);
		
		postdao.deletePostByCategoryNo(no);

		return categorydao.deleteCategory(map);
	}

	public int createCategory(CategoryVo categoryvo) {
		categoryvo.setName(categoryvo.getName().replaceAll("(?i)<script", "&lt;script"));
		categoryvo.setDescription(categoryvo.getDescription().replaceAll("(?i)<script", "&lt;script"));
		
		return categorydao.insertCategory(categoryvo);
	}

	public int createPost(PostVo postvo) {
		postvo.setContent(postvo.getContent().replaceAll("(?i)<script", "&lt;script"));
		postvo.setTitle(postvo.getTitle().replaceAll("(?i)<script", "&lt;script"));
	
		return postdao.insertPost(postvo);
	}

}
