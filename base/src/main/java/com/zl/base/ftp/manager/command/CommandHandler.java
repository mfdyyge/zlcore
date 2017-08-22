package com.zl.base.ftp.manager.command;

import com.zl.base.ftp.server.utils.ConfigUtil;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 命令执行者分发器 默认加载config/dispatcher.xml <CommandHandlers> 中的分发信息
 * @author hannn
 *
 */
public class CommandHandler	 implements CommandHandlerMBean {
	private static CommandHandler instance;
	
	private static Logger log= Logger.getLogger(CommandHandler.class);
	private Map<String,CommandService> commandRegistry= new HashMap<String,CommandService>();
	public static CommandHandler getInstance(){
		synchronized (CommandHandler.class) {
			if(instance==null){
				instance= new CommandHandler();
			}
		}
		return instance;
	}
	private CommandHandler(){

		
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
					if(messagenode.getNodeName()!=null && "CommandHandlers".equals(messagenode.getNodeName())){
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
								if(obj instanceof CommandService){
									commandRegistry.put(op, (CommandService ) obj);
								}
							}
						}
					}
				}
			}
			
		} catch (Exception e) {
			log.error("load dispatcher service error:"+e.getMessage());
		}
	
	}
	public String exec(String  param){
		param= param.trim();
		String [] params=param.split("\\s+");
		if(params.length==0  || param.length()==0 || "?".equals(param)|| "".equals(param)){
			StringBuilder sb= new StringBuilder();
			for(String op:commandRegistry.keySet()){
				CommandService command=commandRegistry.get(op);
				if(command==null){
					return "command:help "+params[1]+" ... not found";
				}
				
				sb.append(command.help());
				sb.append(System.lineSeparator());
			}
			sb.append("input (by | bye | exit)  to exit");
			sb.append(System.lineSeparator());
			return sb.toString();
		}
		if( params[0].equals("help") ){
			if(params.length==2){
				String helpOp=params[1];
				CommandService command=commandRegistry.get(helpOp);
				if(command==null){
					return "command:help "+params[1]+" ... not found";
				}
				return command.help();
			}
			return "no help info";
		}
		String op=params[0];
		CommandService service=commandRegistry.get(op);
		if(service==null){
			return "cannot identify the command"+param;
		}
		return service.doExec(param);
	}
	
}
