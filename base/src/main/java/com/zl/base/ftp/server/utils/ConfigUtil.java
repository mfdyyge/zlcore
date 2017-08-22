package com.dc.ftp.server.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class ConfigUtil {
	private static ConfigUtil instance;
	private String configPath="config/config.properties";
	private Logger log=Logger.getLogger(ConfigUtil.class);
	private Properties prop= new Properties();
	public static ConfigUtil getInstance(){
		synchronized (ConfigUtil.class) {
			if(instance==null){
				instance=new ConfigUtil();
			}
		}
		return instance;
	}
	private ConfigUtil(){
		String basePath=System.getProperty("base.path");
		if(basePath!=null){
			File f= new File(basePath);
			if(!f.exists()){
				f.mkdirs();
			}
			configPath=f.getAbsolutePath()+"/"+"config/config.properties";
		}else{
			System.setProperty("base.path", new File("").getAbsolutePath());
		}
		load();
		//指定日志配置文件位置
		PropertyConfigurator.configure(getBasePath()+"/config/log4j.properties");
	}
	private void load(){
		
		File f= new File(configPath);
		File p=f.getParentFile();
		if(!p.exists()){
			p.mkdirs();
			log.error("config file not found");
			return ;
		}
		if(f.exists()){
			try {
				prop.load(new FileInputStream(f));
			} catch (Exception e) {
				log.error("load config file error");
			}
		}else{
			log.error("config file not found");
		}
		
	}
	public String getValue(String key){
		return prop.getProperty(key);
	}
	public void setValue(String key,String value){
		prop.setProperty(key, value);
		try {
			prop.store(new FileOutputStream(configPath), "update once");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String getBasePath(){
		return System.getProperty("base.path");
	}
}
