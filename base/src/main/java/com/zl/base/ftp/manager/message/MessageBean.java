package com.dc.ftp.manager.message;

import java.util.Map;

public class MessageBean {
	private String op;
	private Map<String,Object> content;
	private String auth; //name:password    md5(name:password) base64(name:password)
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	public Map<String,Object> getContent() {
		return content;
	}
	public void setContent(Map<String,Object> content) {
		this.content = content;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
}
