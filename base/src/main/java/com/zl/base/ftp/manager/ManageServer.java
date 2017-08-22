package com.zl.base.ftp.manager;

import com.zl.base.ftp.manager.message.MessageHandler;
import com.zl.base.ftp.server.utils.ConfigUtil;
import org.apache.log4j.Logger;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ManageServer {
	private static ManageServer instance;
	public static ManageServer getInstance(){
		synchronized (ManageServer.class) {
			if(instance==null){
				instance=new ManageServer();
			}
		}
		return instance;
	}
	private ManageServer(){
		init();
	}
	private static Logger log = Logger.getLogger(ManageServer.class);
	private int port;
	private ServerSocket serverSocket=null;
	private ThreadPoolExecutor pool = ( ThreadPoolExecutor ) Executors.newFixedThreadPool( 30 );
	private void init(){
		String portStr=ConfigUtil.getInstance().getValue("manager.port");
		if(portStr==null || "".equals(portStr)){
			log.error("missing manager server port ,manager server cannot ne started!");
		}
		port=Integer.valueOf(portStr);
	}
	public void startup()  {
		log.info("start manage server on [127.0.0.1:"+port+"]");
		InetSocketAddress address = new InetSocketAddress( "0.0.0.0", port);
		try{
			serverSocket = new ServerSocket();
			serverSocket.bind( address, pool.getCorePoolSize() );
		}catch(Exception e){
			log.error("start manager server error:"+e.getMessage());
		}
		while ( true ) {
			try {
				if(pool.isShutdown()){
					pool = ( ThreadPoolExecutor ) Executors.newFixedThreadPool( 
							30 );
				} 
				pool.execute( new SocketInvoker( serverSocket.accept() ) );
			} catch ( IOException e ) {
				log.error(serverSocket.getLocalPort()+":"+e.getMessage(),e);
			}
		}
	}
	public void shutdown(){
		try {
			if(serverSocket!=null)
			serverSocket.close();
		} catch ( IOException e ) {
			log.error( e.getMessage(), e );
		}
		pool.shutdown();
	}
	public static void main(String[] args) {
		ManageServer.getInstance().startup();
	}
}
class SocketInvoker implements Runnable{
	Socket socket=null;
	private static Logger log = Logger.getLogger(SocketInvoker.class);
	public SocketInvoker(Socket socket){
		this.socket=socket;
	}
	@Override
	public void run() {
	 
		try {
			DataInputStream input = new DataInputStream(socket.getInputStream());  
			String messageReceive=input.readUTF();
			log.debug("receive message:"+messageReceive);
			String retMsg=MessageHandler.getInstance().handle(messageReceive);
			messageSender(retMsg);
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				if(!socket.isClosed()){
					socket.close();
				}
			} catch (IOException e) {}
		}	
		
	}
	/**
	 * 返回消息写入
	 * @param socket
	 * @param close 写完后socket是否关闭
	 * @throws IOException 
	 */
	public void messageSender(String message) 
		throws IOException{
		if(socket.isClosed()){
			log.error("socket is already closed");
			return;
		}
		log.debug("return message:"+message);
		OutputStream outs=socket.getOutputStream();
		DataOutputStream out = new DataOutputStream(outs);
		out.writeUTF(message);
		out.close();
	}
}
