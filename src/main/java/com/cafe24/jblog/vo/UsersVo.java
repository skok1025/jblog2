package com.cafe24.jblog.vo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class UsersVo {
	@NotEmpty
	@Length(min=5, max=30)
	private String id;
	
	@NotEmpty
	@Length(min=3, max=10)
	private String name;
	
	@NotEmpty
	@Length(min=4, max=30)
	private String password;
	private String regDate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "UsersVo [id=" + id + ", name=" + name + ", password=" + password + ", regDate=" + regDate + "]";
	}
	
	

}
