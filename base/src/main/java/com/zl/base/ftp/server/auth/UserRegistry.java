package com.zl.base.ftp.server.auth;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.ftpserver.FtpServerFactory;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.usermanager.impl.BaseUser;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.zl.base.ftp.server.Main;
import com.zl.base.ftp.server.auth.bean.JUser;
import com.zl.base.ftp.server.utils.ConfigUtil;

public class UserRegistry {
	private Map<String,JUser> userMap=Collections.synchronizedMap(new HashMap<String,JUser>());
	private String serializeModel="xml";
	private Logger log= Logger.getLogger(UserRegistry.class);
	private static UserRegistry instance;
	private String authCodeSource;
	public static UserRegistry getInstance(){
		synchronized (UserRegistry.class) {
			if(instance==null){
				instance= new UserRegistry();
			}
			return instance;
		}
	}
	
	private UserRegistry()   {
		//从文件中加载
		serializeModel=ConfigUtil.getInstance().getValue("serialize.model");
		if(serializeModel==null || "".equals(serializeModel)){
			serializeModel="xml";
		}
		load();
	}
	public Set<JUser> getUsers(){
		Set<JUser> set=new HashSet<JUser>();
		if(userMap==null){
			return set;
		}
		for(String key:userMap.keySet()){
			set.add(userMap.get(key));
		}
		return set;
	}
	public boolean addUser(JUser u){
		return addUser(u,false);
	}
	public boolean addUser(JUser u,boolean save){
		String name=u.getName();
		if(userMap.containsKey(name)){
			return true;
		}else{
			userMap.put(name, u);
			if(save){
				save();
			}
			
		}
		return true;
	}
	public boolean containsUser(String name){
		return userMap.containsKey(name);
	}
	public boolean updateUser(JUser u){
		String name=u.getName();
		userMap.put(name, u);
		save();
		boolean ftpre=ftpOpSave(u);
		if(!ftpre){
			userMap.remove(name);
			save();
		}
		return ftpre;
	}
	public void deleteUser(String name){
		if(userMap.containsKey(name)){
			userMap.remove(name);
			save();
			ftpOpDelete(name);
		}
	}
	public void save() {
		if("json".equals(serializeModel)){
			saveJSON();
		}else{
			saveXML();
		}
	}
	public void load(){
		if("json".equals(serializeModel)){
			loadJSON();
		}else{
			loadXML();
		}
	}
	public void saveJSON(){
		String basePath=ConfigUtil.getInstance().getBasePath();
		File f= new File(basePath+"/config/user.json");
		if(!f.exists()){
			try {
				f.createNewFile();
			} catch (IOException e) {}
		}
		String json=JSON.toJSONString(userMap);
		BufferedWriter w=null;
		try{
			w= new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f)));
			w.write(json);
			w.flush();
		}catch(Exception e){
			 log.error("file not found");
		}finally {
			if(w!=null){
				try {
					w.close();
				} catch (IOException e) {}
			}
		}
	}
	public void loadJSON(){
		String basePath=ConfigUtil.getInstance().getBasePath();
		File f= new File(basePath+"/config/user.json");
		log.info("load user message from "+f.getAbsolutePath());
		Scanner scann=null;
		try{
			scann= new Scanner(new FileInputStream(f));
			StringBuilder jsonBuilder=new StringBuilder();
			while(scann.hasNext()){
				jsonBuilder.append(scann.nextLine());
			}
			String json=jsonBuilder.toString().trim();
			if(json==null || "".equals(json)){
				log.error("none user info");
			}
			Map<String,JUser> map=JSON.parseObject(json,new TypeReference<Map<String,JUser>>(){});
			System.out.println(map.toString());
			userMap.putAll(map);
			
		}catch(Exception e){
			e.printStackTrace();
			log.error("parse user file:"+f.getAbsolutePath()+" error");
			//去加载一些默认用户
		}finally{
			scann.close();
		}
		
	}
	public void saveXML(){
		String basePath=ConfigUtil.getInstance().getBasePath();
		File f= new File(basePath+"/config/user.xml");
		if(!f.exists()){
			try {
				f.createNewFile();
			} catch (IOException e) {}
		}
		try {
			JAXBContext context= JAXBContext.newInstance(Users.class);
			Marshaller marshaller=context.createMarshaller();
			 
			Users user= new Users();
			user.setUsers(getUsers());
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
			marshaller.marshal(user,f);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	public void loadXML(){
		String basePath=ConfigUtil.getInstance().getBasePath();
		File f= new File(basePath+"/config/user.xml");
		log.info("log user message from "+f.getAbsolutePath());
		if(!f.exists()){
			try {
				f.createNewFile();
			} catch (IOException e) {}
		}
		try {
			JAXBContext context= JAXBContext.newInstance(Users.class);
			Unmarshaller unmarshaller=context.createUnmarshaller();
			 
			Users user= new Users();
			Object obj=unmarshaller.unmarshal(f);
			if(obj!=null){
				user=(Users)obj;
				for(JUser juser:user.getUsers()){
					if("admin".equals(juser.getName())){
						String adminPassword=juser.getPassword();
						authCodeSource="admin:"+adminPassword;
					}
					addUser(juser);
				}
			}
		} catch (JAXBException e) {
			log.error(e.getMessage());
		}
	}

	public boolean ftpOpSave(JUser ju){
		BaseUser bu=ju.createFtpUser();
		FtpServerFactory serverFactory=Main.serverFactory;
		try {
			serverFactory.getUserManager().save(bu); //更新密码
			
		} catch (FtpException e) {
			 return false;
		}
		String ftpHome=ConfigUtil.getInstance().getValue("ftp.home");
		try{
			
			File f =new File(ftpHome+ju.getHomeDir());
			if(!f.exists() ){
				log.debug("create dir"+f.getAbsolutePath());
				f.mkdirs();
			}
		}catch(Exception e){
			//创建目录失败
			log.error("create user home:"+ftpHome+ju.getHomeDir()+" error!");
			try {
				serverFactory.getUserManager().delete(ju.getName());
			} catch (FtpException e1) {
				log.debug("roll back :delete user error!");
			}
			return false;
		}
		return true;
	}
	public boolean ftpOpDelete(String userName){
		FtpServerFactory serverFactory=Main.serverFactory;
		try {
			serverFactory.getUserManager().delete(userName);
			return true;
		} catch (FtpException e) {
			 
		}
		return false;
	}
	public String getAuthCodeSource() {
		return authCodeSource;
	}
}
@XmlType
@XmlRootElement(name="ftpinfo")
@XmlAccessorType(XmlAccessType.FIELD)
class Users{
	@XmlElementWrapper(name="users")
	@XmlElement(name="user")
	private Set<JUser> users;

	public Set<JUser> getUsers() {
		return users;
	}
	public void setUsers(Set<JUser> users) {
		this.users = users;
	}
}
