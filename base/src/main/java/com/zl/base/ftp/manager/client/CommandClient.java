package com.zl.base.ftp.manager.client;

import com.zl.base.ftp.manager.client.util.AbstractJmxCommand;

import javax.management.*;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.*;
import java.util.Scanner;

public class CommandClient {
	/**
	 * 如果无参数进入交互模式  有参数直接执行命令
	 * @param args
	 * @throws IOException
	 * @throws MalformedObjectNameException
	 * @throws InstanceNotFoundException
	 * @throws MBeanException
	 * @throws ReflectionException
	 */
	public static void main(String[] args) throws  IOException,
			MalformedObjectNameException, InstanceNotFoundException, MBeanException, ReflectionException {
		//print(System.getProperty("java.vm.specification.vendor"));
		boolean interactiveModel=false;
		if(args.length==0){
			interactiveModel=true;
		}
		//print("params num(java):"+args.length);
		String defaultPath = "/var/ftp/pid";

		File pidFile = new File(defaultPath);
		if (!pidFile.exists()) {
			print("cannot get the pid of ftpserver in(/var/ftp/pid)");
			System.exit(0);
		}
		Scanner scann = new Scanner(new FileInputStream(pidFile));
		String pid = scann.nextLine();
		if (pid == null) {
			System.out.println("cannot get the pid of ftpserver in(/var/ftp/pid)");
			System.exit(0);
		}
		scann.close();
		print("work on pid:" + pid);
		
		MBeanServerConnection mbeanConn=null;
		try{
			String connectorAddress=new AbstractJmxCommand().findJMXUrlByProcessId(Integer.valueOf(pid));
			JMXServiceURL url = new JMXServiceURL(connectorAddress);
			JMXConnector connector = JMXConnectorFactory.connect(url);
			mbeanConn = connector.getMBeanServerConnection();
		}catch(Exception e){
			System.out.println("cannot find the ftp server on host");
			System.exit(0);
		}
		

		ObjectName name = new ObjectName("com.zl.base.ftp.manager.command:type=CommandHandler");
		if(interactiveModel){
			while(true){
				InputStream in=System.in;
				System.out.print("Please input your comand:");
				BufferedReader reader=new BufferedReader(new InputStreamReader(in));
				String command=reader.readLine();
				if(command==null){
					command="";
				}
				if("by".equals(command) || "bye".equals(command) || "exit".equals(command)){
					System.out.println();
					System.out.println("bye");
					break;
				}
				Object ret = mbeanConn.invoke(name, "exec", new String[] { command },
						new String[] { "java.lang.String" });
				System.out.println(ret);
			}
		}else{
			StringBuilder sb= new StringBuilder();
			for(int i=0;i<args.length;i++){
				if(i!=0){
					sb.append(" ");
				}
				sb.append(args[i]);
			}
			Object ret = mbeanConn.invoke(name, "exec", new String[] { sb.toString() },
					new String[] { "java.lang.String" });
			print("result:"+ret);
		}
		
	}

	public static void print(String msg ) {
		System.out.println(msg);
	}
}
