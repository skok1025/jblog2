package com.cafe24.jblog.vo;

import org.hibernate.validator.constraints.NotEmpty;

public class CategoryVo {
	private Long no;
	
	@NotEmpty
	private String name;

	private String description;
	private String regDate;
	private String blogId;
	
	private Long postCount;
	
	
	public Long getPostCount() {
		return postCount;
	}
	public void setPostCount(Long postCount) {
		this.postCount = postCount;
	}
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getBlogId() {
		return blogId;
	}
	public void setBlogId(String blogId) {
		this.blogId = blogId;
	}
	@Override
	public String toString() {
		return "CategoryVo [no=" + no + ", name=" + name + ", description=" + description + ", regDate=" + regDate
				+ ", blogId=" + blogId + ", postCount=" + postCount + "]";
	}
	
	

}
