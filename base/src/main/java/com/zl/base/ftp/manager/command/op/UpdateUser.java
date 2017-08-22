package com.zl.base.ftp.manager.command.op;

import com.zl.base.ftp.manager.command.CommandService;
import com.zl.base.ftp.server.auth.UserRegistry;
import com.zl.base.ftp.server.auth.bean.JUser;

public class UpdateUser implements CommandService{
	
	@Override
	public String doExec(String command) {
		String[] params=command.split("\\s+");
		if(params.length!=3 && params.length !=5){
			return "error update info";
		}
		boolean wirtePermission=true;
		try{
			String name=params[1];
			if("admin".equals(name)){
				return "error:cannot update user:admin";
			}
			String password=params[2];
			String homedir="/"+name;
			if(params.length==5){
				String apath=params[3];
				String writeAble=params[4];
				if(apath.startsWith("/")){
					homedir=apath;
				}else{
					homedir="/"+apath;
				}
				if("false".equals(writeAble) || "ro".equals(writeAble)){
					wirtePermission=false;
				}
			}
			
			JUser ju= new JUser();
			ju.setName(name);
			ju.setPassword(password);
			ju.setWriteable(wirtePermission);
			ju.setHomeDir(homedir);
			UserRegistry.getInstance().updateUser(ju);
			
			
		}catch(Exception e){
			return  "missing some params" ;
		}
		return  "update user success" ;
	}

	@Override
	public String help() {
		
		return "op[updateuser] function:add or update a user info"+System.lineSeparator() 
		+"usage:\tupdateuser <userName> <password> [<homedir> <writeable>] "+System.lineSeparator() 
				+ "\teg: "+System.lineSeparator()
				+ "\tupdateuser test1 123456  "+System.lineSeparator()
				+ "\tupdateuser test1 123456 /testnewhome true"+System.lineSeparator();
	}

}
