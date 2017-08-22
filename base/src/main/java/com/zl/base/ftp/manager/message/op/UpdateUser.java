package com.zl.base.ftp.manager.message.op;

import com.alibaba.fastjson.JSON;
import com.zl.base.ftp.manager.message.MessageBean;
import com.zl.base.ftp.manager.message.OperationService;
import com.zl.base.ftp.server.auth.UserRegistry;
import com.zl.base.ftp.server.auth.bean.JUser;

import java.util.HashMap;
import java.util.Map;
public class UpdateUser implements OperationService {

	@Override
	public String operate(MessageBean message) {
		Map<String,Object> payload=message.getContent();
		try{
			String name=payload.get("name").toString();
			String password=payload.get("password").toString();
			Object homeobj=payload.get("homedir");
//			String homedir=ConfigUtil.getInstance().getValue("ftp.home")+"/"+name;
			String homedir="/"+name;
			if(homeobj!=null){
				String apath=homeobj.toString();
				if(apath.startsWith("/")){
					homedir=apath;
				}else{
					homedir="/"+apath;
				}
			}else{
				
			}
			boolean wirtePermission=false;
			if(payload.get("writeable")==null || "true".equals(payload.get("writeable").toString())){
				wirtePermission=true;
			}
			JUser ju= new JUser();
			ju.setName(name);
			ju.setPassword(password);
			ju.setWriteable(wirtePermission);
			ju.setHomeDir(homedir);
			UserRegistry.getInstance().updateUser(ju);
			
			
		}catch(Exception e){
			return errorMsg("missing some params");
		}
		return successMsg("update user success");
	}
	private String errorMsg(String message){
		 Map<String,Object> result= new HashMap<String,Object>();
		 result.put("result", false );
		 result.put("msg", message);
		return JSON.toJSONString(result);
	}
	private String successMsg(String message){
		 Map<String,Object> result= new HashMap<String,Object>();
		 result.put("result", true );
		 result.put("msg", message);
		return JSON.toJSONString(result);
	}
 

}
