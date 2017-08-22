package com.dc.ftp.manager.message.op;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.dc.ftp.manager.message.MessageBean;
import com.dc.ftp.manager.message.OperationService;
import com.dc.ftp.server.auth.UserRegistry;
import com.dc.ftp.server.auth.bean.JUser;

public class ListUsers implements OperationService {
	@Override
	public String operate(MessageBean message) {
		Set<JUser> set=UserRegistry.getInstance().getUsers();
		List<Map<String,String>> list= new ArrayList<Map<String,String>>();
		for(JUser ju:set){
			String name=ju.getName();
			String home=ju.getHomeDir();
			Map<String,String> unit= new HashMap<String,String>();
			unit.put("name",name);
			unit.put("home", home);
			unit.put("writeable", ju.isWriteable()+"");
			list.add(unit);
		}
		 Map<String,Object> result= new HashMap<String,Object>();
		 result.put("result",  true );
		 result.put("msg", list);
		return JSON.toJSONString(result);
	}
 

}
