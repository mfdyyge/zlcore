package com.zl.base.ftp.manager.message.op;

import com.alibaba.fastjson.JSON;
import com.zl.base.ftp.manager.message.MessageBean;
import com.zl.base.ftp.manager.message.OperationService;
import com.zl.base.ftp.server.auth.UserRegistry;

import java.util.HashMap;
import java.util.Map;

public class DeleteUser implements OperationService {

	@Override
	public String operate(MessageBean message) {
		Object delName=message.getContent().get("name");
		if(delName==null || "".equals(delName)){
			return errorMsg("no user info:"+delName);
		}
		boolean containsUser=UserRegistry.getInstance().containsUser(delName.toString());
		if(!containsUser){
			return errorMsg("no such user:"+delName);
		}
		UserRegistry.getInstance().deleteUser(delName.toString());
		return successMsg("delete user ["+delName+"] success");
	}
	private String successMsg(String message){
		 Map<String,Object> result= new HashMap<String,Object>();
		 result.put("result", true );
		 result.put("msg", message);
		return JSON.toJSONString(result);
	}
	private String errorMsg(String message){
		 Map<String,Object> result= new HashMap<String,Object>();
		 result.put("result", false );
		 result.put("msg", message);
		return JSON.toJSONString(result);
	}
}
