package com.cafe24.jblog.vo;

import org.springframework.web.multipart.MultipartFile;

public class BlogVo {
	private String id;
	private String title;
	private String logo;
	
	private MultipartFile attach;
	
	public MultipartFile getAttach() {
		return attach;
	}
	public void setAttach(MultipartFile attach) {
		this.attach = attach;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	@Override
	public String toString() {
		return "BlogVo [id=" + id + ", title=" + title + ", logo=" + logo + ", attach=" + attach + "]";
	}
	
	

}
