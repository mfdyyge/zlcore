package com.dc.ftp.manager.command.op;

import java.util.Set;

import com.dc.ftp.manager.command.CommandService;
import com.dc.ftp.server.auth.UserRegistry;
import com.dc.ftp.server.auth.bean.JUser;

public class ListUsers implements CommandService {

	@Override
	public String doExec(String command) {
		String[] params=command.split("\\s+");
		String keyword=null;
		if(params.length>1){
			keyword=params[1];
		}
		StringBuilder sb= new StringBuilder("==================all users====================");
		sb.append(System.lineSeparator());
		Set<JUser> set=UserRegistry.getInstance().getUsers();
		for(JUser ju:set){
			String name=ju.getName();
			if(keyword!=null){
				if(!name.contains(keyword)){
					continue;
				}
			}
			String home=ju.getHomeDir();
			sb.append(name);
			sb.append("\t");
			sb.append(home);
			sb.append("\t");
			sb.append(ju.isWriteable()?"rw":"ro");
			sb.append(System.lineSeparator());
		}
		sb.append("===============================================");
		return sb.toString();
	}

	@Override
	public String help() {
		return "op[listuser] function:show all userslist "+System.lineSeparator();
	}
}
