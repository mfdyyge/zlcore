package com.zl.base.ftp.server;
import com.zl.base.ftp.manager.ManageServer;
import com.zl.base.ftp.manager.command.CommandHandler;
import com.zl.base.ftp.manager.message.MessageHandler;
import com.zl.base.ftp.server.auth.UserRegistry;
import com.zl.base.ftp.server.auth.bean.JUser;
import com.zl.base.ftp.server.utils.ConfigUtil;
import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.FtpServerFactory;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.listener.ListenerFactory;
import org.apache.ftpserver.usermanager.impl.BaseUser;
import org.apache.log4j.Logger;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.lang.management.ManagementFactory;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
public class Main {
	private static Logger log=Logger.getLogger(Main.class);
	public static AtomicBoolean startready= new AtomicBoolean(false);
	public static FtpServerFactory serverFactory=null;
	
	public static void main(String[] args) {
		//加载配置
		int ftpport=21;
		String pstr=ConfigUtil.getInstance().getValue("ftp.port");
		if(pstr!=null && !"".equals(pstr)){
			ftpport=Integer.valueOf(pstr);
		}
		//加载权限
		log.debug("Loading auth info....");
		serverFactory = new FtpServerFactory();
		Set<JUser> users=UserRegistry.getInstance().getUsers();
		for(JUser ju:users){
			BaseUser bu= ju.createFtpUser();
			try {
				log.debug("init user:"+ju.getName());
				serverFactory.getUserManager().save(bu);
			} catch (FtpException e) {
				log.error("init ftp users error");
			}
		}
		//设置端口
		ListenerFactory listenerFactory= new ListenerFactory();
		listenerFactory.setPort(ftpport);
		serverFactory.addListener("default",  listenerFactory.createListener());
		FtpServer server=serverFactory.createServer();
		
		//记录pid
		String pid=null;
		try{
			String pname = ManagementFactory.getRuntimeMXBean().getName();
			pid=pname.split("@")[0];
			if(pid==null){
				throw new RuntimeException("cannot get the pid");
			}
			//写入pid文件
			String pidFile=ConfigUtil.getInstance().getValue("pidfile");
			if(pidFile==null || "".equals(pidFile)){
				 
				pidFile= "/var/ftp/pid";
			}
			String pidDir=new File(pidFile).getParent();
			log.debug("update pidfile("+pid+"):"+pidFile);
			new File(pidDir).mkdirs();
			BufferedWriter writer= new BufferedWriter(new OutputStreamWriter(new FileOutputStream(pidFile)));
			writer.write(pid);
			writer.flush();
			writer.close();
			
		}catch(Exception e){
			e.printStackTrace();
			log.error("cannot get the pid");
			System.exit(-1);
		}
		
		//mbean server
		MBeanServer mbs=ManagementFactory.getPlatformMBeanServer();
		//创建mbean对象 等待被管理
		CommandHandler commandInstance=CommandHandler.getInstance();
		try {
			ObjectName name = new ObjectName("com.zl.base.ftp.manager.command:type=CommandHandler");
			log.info("command listener created success!");
			mbs.registerMBean(commandInstance, name);
		} catch (Exception e1) {
			log.error("command listener created error!");
			log.error(e1.getMessage());
		}
		
		try {
			new Thread(new StartManagerServer()).start();
			server.start();
			startready.set(true);
			log.info("==ftp server start ready, please visit:ftp://127.0.0.1:"+ftpport+"==");
		} catch ( FtpException e) {
			e.printStackTrace();
		}
		
	}
}
/**
 * 启动管理服务
 * @author Administrator
 *
 */
class StartManagerServer implements Runnable{
	private Logger log= Logger.getLogger(StartManagerServer.class);
	@Override
	public void run() {
		while(!Main.startready.get()){
			 
		}
		MessageHandler.getInstance();//首先加载分发器
		if(MessageHandler.ready.get()){
			ManageServer.getInstance().startup();
		}else{
			log.error("there are some error in dispatcher.xml while load service handler!");
			log.error("cannot start the manager server");
		}
		
	}
	
}
