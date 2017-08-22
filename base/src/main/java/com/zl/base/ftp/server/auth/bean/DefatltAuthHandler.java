package com.zl.base.ftp.server.auth.bean;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.mina.util.Base64;

import com.zl.base.ftp.manager.message.MessageBean;
import com.zl.base.ftp.server.auth.UserRegistry;
import com.zl.base.ftp.server.utils.ConfigUtil;
/**
 * 只有admin认证成功才可以 但操作对象不可以是admin
 * @author Administrator
 *
 */
public class DefatltAuthHandler {
	public boolean hasPermission(MessageBean bean){
		if(bean.getContent() ==null || bean.getContent().size()==0){
			return true;
		}
		Object objN=bean.getContent().get("name");
		if(objN!=null && "admin".equals(objN)){
			return false;
		}
		return isAdmin(bean.getAuth());
	}
	private  boolean isAdmin(String authCode){
		String authmethod=ConfigUtil.getInstance().getValue("manager.authcheck");
		String authSource=UserRegistry.getInstance().getAuthCodeSource();
		// 系统未设置管理员账号  默认通过
		if(authSource==null || "".equals(authSource)){
			return true;
		}
		if(authCode==null || "".equals(authCode)){
			return false;
		}
		if("md5".equals(authmethod)){
			//将用户名密码MD5后与authCode比对
			try {
				MessageDigest md=MessageDigest.getInstance("MD5");
				md.update(authSource.getBytes());
				String ret=new BigInteger(1, md.digest()).toString(16);
				if(ret.equals(authCode))
					return true;
			} catch (NoSuchAlgorithmException e) {
				 System.out.println("MD5加密出现错误");
			}
		}else if("base64".equals(authmethod)){
			//base64 解码后比对
			try{
				byte[] de=Base64.decodeBase64(authCode.getBytes());
				String decode=new String(de);
				if(authSource.equals(decode))
					return true;
			}catch(Exception e){}
			
		}else{
			//直接比对用户名密码 authCode=name:password
			if(authCode.equals(authSource)){
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
 
		
		try {
			MessageDigest md=MessageDigest.getInstance("MD5");
			md.update("admin:admin".getBytes());
			String ret=new BigInteger(1, md.digest()).toString(16);
			System.out.println(ret);
		} catch (NoSuchAlgorithmException e) {
			 System.out.println("MD5加密出现错误");
		}
		
		
	}
}
