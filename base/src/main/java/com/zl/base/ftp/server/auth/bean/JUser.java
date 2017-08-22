package com.dc.ftp.server.auth.bean;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import org.apache.ftpserver.ftplet.Authority;
import org.apache.ftpserver.usermanager.impl.BaseUser;
import org.apache.ftpserver.usermanager.impl.WritePermission;

import com.dc.ftp.server.utils.ConfigUtil;
@XmlType(propOrder={"name","password","homeDir","writeable","isEnabled","maxIdleTimeSec"})
@XmlAccessorType(XmlAccessType.FIELD)
public class JUser {
	private String name = null;

	private String password = null;
	 
	private int maxIdleTimeSec = 0; // no limit

	private String homeDir = null;

	private boolean isEnabled = true;

	private boolean writeable=false;
	
	public String getName() {
		return name;
	}
	public boolean isWriteable() {
		return writeable;
	}
	public void setWriteable(boolean writeable) {
		this.writeable = writeable;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getMaxIdleTimeSec() {
		return maxIdleTimeSec;
	}

	public void setMaxIdleTimeSec(int maxIdleTimeSec) {
		this.maxIdleTimeSec = maxIdleTimeSec;
	}

	public String getHomeDir() {
		return homeDir;
	}

	public void setHomeDir(String homeDir) {
		this.homeDir = homeDir;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	
	public BaseUser createFtpUser(){
		String basePath=ConfigUtil.getInstance().getValue("ftp.home");
		BaseUser user = new BaseUser();
		user.setName(name);
		user.setPassword(password);
		//檢查目錄是否存在 不存在則創建
		File homeDirFile=new File(basePath+homeDir);
		if(!homeDirFile.exists()){
			homeDirFile.mkdirs();
		}
		user.setHomeDirectory(homeDirFile.getAbsolutePath());
		List<Authority> authorities = new ArrayList<Authority>();  
		if(writeable){
			authorities.add(new WritePermission());
		}
		user.setAuthorities(authorities);
		return user;
	}
}
