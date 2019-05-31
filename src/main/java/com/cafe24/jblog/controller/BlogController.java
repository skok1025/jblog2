package com.cafe24.jblog.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.jblog.service.BlogService;
import com.cafe24.jblog.vo.BlogVo;
import com.cafe24.jblog.vo.CategoryVo;
import com.cafe24.jblog.vo.PostVo;


@Controller
@RequestMapping("/{id:(?!assets).*}")
public class BlogController {

	@Autowired
	private BlogService blogService;

	
	
	// 미처리
	@GetMapping({"","/{no1}","/{no1}/{no2}"})
	public String blogMain(
			@PathVariable(value = "id") String id,
			@PathVariable(value = "no1") Optional<Long> no1,
			@PathVariable(value = "no2") Optional<Long> no2,
			Model model) {
		Long categoryOrder = 0L;
		Long postOrder = 0L;
		
		if(no1.isPresent()) {
			categoryOrder = no1.get();
		}
		
		if(no2.isPresent()) {
			postOrder =  no2.get();
		}
		
		BlogVo blogvo = blogService.getBlogInfo(id);		
		PostVo postVo = blogService.showPost(id,categoryOrder,postOrder);
		
		List<PostVo> postList = blogService.showPostList(id,categoryOrder);
		List<CategoryVo> categoryList = blogService.showCategoryList(id);
		
		model.addAttribute("blogvo", blogvo);
		model.addAttribute("id",id);
		model.addAttribute("categoryOrder",categoryOrder);
		model.addAttribute("postVo", postVo);
		model.addAttribute("postList", postList);
		model.addAttribute("categoryList", categoryList);
		
		return "blog/blog-main";
	}
	
	//@Auth(role=Auth.Role.ADMIN)
	@GetMapping("/admin/basic")
	public String adminBasic(
		@PathVariable(value = "id") String id,
		Model model) {
		BlogVo blogvo = blogService.getBlogInfo(id);
		
		model.addAttribute("blogvo",blogvo);
		return "blog/blog-admin-basic";
	}
	
	//@Auth(role=Auth.Role.ADMIN)
	@PostMapping("/admin/basic")
	public String adminBasic(
		@PathVariable(value = "id") String id,
		@ModelAttribute BlogVo blogvo,
		Model model) {
		int result = blogService.updateBlogBasicInfo(id,blogvo);
	
		if(result != 1) {
			model.addAttribute("updatesuccess","false");
			return "blog/blog-admin-basic";
		}
		return "redirect:/"+id;
	}
	
	//@Auth(role=Auth.Role.ADMIN)
	@GetMapping("/admin/category")
	public String adminCategory(
			@PathVariable(value = "id") String id,
			@ModelAttribute CategoryVo categoryvo,
			Model model
			) {
		List<CategoryVo> categoryList = blogService.showCategoryList(id);
		model.addAttribute("categoryList",categoryList);
		return "blog/blog-admin-category";
	}
	
	//@Auth(role=Auth.Role.ADMIN)
	@GetMapping("/admin/category/del/{no}")
	public String deladminCategory(
			@PathVariable(value = "id")String id,
			@PathVariable(value = "no")Long no,
			Model model) {
		int result = blogService.deleteCategory(id,no);
		
		if(result != 1) { // 실패
			model.addAttribute("deletefail","yes");
			return "blog/blog-admin-category";
		}
		return "redirect:/"+id+"/admin/category";
	}
	
	//@Auth(role=Auth.Role.ADMIN)
	@PostMapping("/admin/category/add")
	public String addadminCategory(
		@PathVariable(value = "id")String id,
		@ModelAttribute @Valid CategoryVo categoryvo,
		BindingResult bindingResult,
		Model model
	) {
		if(bindingResult.hasErrors()) {
			List<CategoryVo> categoryList = blogService.showCategoryList(id);
			model.addAttribute("categoryList",categoryList);
			model.addAttribute(bindingResult.getModel());
			return "blog/blog-admin-category";
		}
		categoryvo.setBlogId(id);

		int result = blogService.createCategory(categoryvo);
		
		if(result != 1) {
			model.addAttribute("addfail","yes");
			return "blog/blog-admin-category";
		}
		return "redirect:/"+id+"/admin/category";
	}
	
	//@Auth(role=Auth.Role.ADMIN)
	@GetMapping("/admin/write")
	public String writePost(
			@ModelAttribute PostVo postvo,
			@PathVariable(value = "id")String id,
			Model model) {
		List<CategoryVo> categoryList = blogService.showCategoryList(id);
		
		model.addAttribute("categoryList",categoryList);
		return "blog/blog-admin-write";
	}
	
	//@Auth(role=Auth.Role.ADMIN)
	@PostMapping("/admin/write")
	public String writePost(
			@PathVariable(value = "id")String id,
			@ModelAttribute @Valid PostVo postvo,
			BindingResult bindingResult,
			Model model
			) {
		if(bindingResult.hasErrors()) {
			List<CategoryVo> categoryList = blogService.showCategoryList(id);
			model.addAttribute("categoryList",categoryList);
			model.addAttribute(bindingResult.getModel());
			return "blog/blog-admin-write";
		}
		int result = blogService.createPost(postvo);
		
		if(result != 1) {
			model.addAttribute("addfail","yes");
			return "blog/blog-admin-write";
		}
		return "redirect:/"+id;
	}
	
	
	
}
