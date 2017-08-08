package com.zl.spring.springmvc;


import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = -3089926791011388191L;

	private Integer userId;

	private String userName;

	private String desc;



	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
