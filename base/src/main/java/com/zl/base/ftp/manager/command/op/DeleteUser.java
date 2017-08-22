package com.zl.base.ftp.manager.command.op;

import com.zl.base.ftp.manager.command.CommandService ;
import com.zl.base.ftp.server.auth.UserRegistry;

public class DeleteUser implements CommandService  {

	@Override
	public String doExec(String command) {
		String[] params=command.split("\\s+");
		if(params.length<=1){
			return "cannot get the username you want to delete";
		}
		String delName=params[1];
		if(delName==null || "".equals(delName)){
			return "no user info:"+delName;
		}
		boolean containsUser=UserRegistry.getInstance().containsUser(delName.toString());
		if(!containsUser){
			return "no such user:"+delName;
		}
		UserRegistry.getInstance().deleteUser(delName.toString());
		return "delete user:"+delName+" ok";
	}

	@Override
	public String help() {
		return "op[deleteuser] function:delete a user  "+System.lineSeparator() 
		+"usage:\tdeleteuser <userName> "+System.lineSeparator() 
				+ "\teg:\tdeleteuser test1 123456  "+System.lineSeparator();
			 
	}
	 
}
