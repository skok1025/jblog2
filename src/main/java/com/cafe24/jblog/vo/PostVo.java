package com.cafe24.jblog.vo;

import org.hibernate.validator.constraints.NotEmpty;

public class PostVo {
	private Long no;
	
	@NotEmpty
	private String title;
	
	@NotEmpty
	private String content;
	private String regDate;
	private Long categoryNo;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public Long getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(Long categoryNo) {
		this.categoryNo = categoryNo;
	}
	@Override
	public String toString() {
		return "PostVo [no=" + no + ", title=" + title + ", content=" + content + ", regDate=" + regDate
				+ ", categoryNo=" + categoryNo + "]";
	}
	
	

}
