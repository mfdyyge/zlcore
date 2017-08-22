package com.zl.base.ftp.manager.message;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.zl.base.ftp.server.auth.AuthChecker;
import com.zl.base.ftp.server.utils.ConfigUtil;
/**
 *  命令执行者分发器   默认加载config/dispatcher.xml <MessageHandlers> 中的分发信息
 *  单例
 */
public class MessageHandler {
	private static MessageHandler instance;
	public static AtomicBoolean ready= new AtomicBoolean(false);
	private Logger log= Logger.getLogger(MessageHandler.class);
	private Map<String,OperationService> serviceRegistry= new HashMap<String,OperationService>();
	public static MessageHandler getInstance(){
		synchronized (MessageHandler.class) {
			if(instance==null){
				instance= new MessageHandler();
			}
		}
		return instance;
	}
	//加载消息分发器
	private MessageHandler(){
		
		String file= ConfigUtil.getInstance().getBasePath()+"/config/dispatcher.xml";
		File f= new File(file);
		if(!f.exists()){
			log.error("cannot get the dispatcher file!");
		}
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder db = dbf.newDocumentBuilder(); 
			Document document = db.parse(file);
			Node rootlist=document.getFirstChild();
			if(rootlist.hasChildNodes()){
				NodeList rootnodelist=rootlist.getChildNodes();
				for(int i=0;i<rootnodelist.getLength();i++){
					Node messagenode=rootnodelist.item(i);
					if(messagenode.getNodeName()!=null && "MessageHandlers".equals(messagenode.getNodeName())){
						NodeList nodelist=messagenode.getChildNodes();
						for(int j=0;j<nodelist.getLength();j++){
							Node node=nodelist.item(j);
							if(node.getNodeName()!=null && "handler".equals(node.getNodeName())){
								NamedNodeMap  map=node.getAttributes();
								String op=map.getNamedItem("op").getNodeValue();
								String clazzName=map.getNamedItem("clazz").getNodeValue();
								//MessageHandler.class.getClassLoader().loadClass(clazzName);
								Class<?> clazz=Class.forName(clazzName);
								Object obj=clazz.newInstance();
								if(obj instanceof OperationService){
									serviceRegistry.put(op, (OperationService) obj);
								}
							}
						}
					}
				}
			}
			ready.set(true);
		} catch (Exception e) {
			log.error("load dispatcher service error:"+e.getMessage());
		} 
	}
	
	public String handle(String  message){
		MessageBean bean= parse(message);
		if(bean ==null){
			return "{\"result\":false,\"msg\":\"cannot analysis the message\"}";
		}
		//验证权限
		AuthChecker auth= new AuthChecker();
		if(!auth.hasPermission(bean)){
			return "{\"result\":false,\"msg\":\"have no permission to do this!\"}";
		}
		return dispatch(bean);
	}
	// 消息处理 将json数据转化为 MessageBean 对象
	private MessageBean parse(String message){
		try{
			MessageBean bean= JSON.parseObject(message, new TypeReference<MessageBean>(){});
			return bean;
		}catch(Exception e){
			log.error("cannot analysis the message");
		}
		return null;
		
	}
	//寻找消息处理服务 并交给该服务进行处理
	private String dispatch(MessageBean message){
		String errorMsg="{\"result\":false,\"msg\":\"cannot find the operation handler\"}";
		if(serviceRegistry==null || serviceRegistry.size()==0){
			return errorMsg;
		} 
		OperationService service=serviceRegistry.get(message.getOp());
		if(service==null){
			return errorMsg;
		}
		return service.operate(message);
	}

}
