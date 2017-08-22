package com.zl.base.ftp.server.auth;

import com.zl.base.ftp.manager.message.MessageBean;
import com.zl.base.ftp.server.auth.bean.DefatltAuthHandler;
import com.zl.base.ftp.server.utils.ConfigUtil;
/**
 * 调度如何鉴权  默认只有DefatltAuthHandler
 * @author Administrator
 *
 */
public class AuthChecker {
	public boolean hasPermission(MessageBean message){
		String authmethod=ConfigUtil.getInstance().getValue("manager.authcheck");
		if("none".equals(authmethod)){
			//不校验 直接放行
			return true;
		}
		// 可以有多重实现
		DefatltAuthHandler checker= new DefatltAuthHandler();
		return checker.hasPermission(message );
	}
}
