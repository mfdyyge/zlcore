package com.zl.jdbc.DataSource;



import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.ResourceBundle;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;


/**
 * @ClassName: JdbcUtils
 * @Description: 数据库连接工具类
 * @author: 钢背猪☣
 * @date: 2017-07-01 下午1:04:36
 */
public class DataSouceFactory_C3p0
{

	public  static final String DS_NAME = "c3p0";

	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();// C3P0数据库连接池
	public void setDataSource(ComboPooledDataSource ds)
	{
		this. dataSource=ds;
	}


	//static ResourceBundle rbundle = ResourceBundle.getBundle("conf/db/db");
	private static ResourceBundle rbundle=null; //读取配置文件
	public DataSouceFactory_C3p0(ResourceBundle rsb )
	{
		rbundle=rsb;
	}

	private static  String DriverClassName 	;
	private static  String JdbcUrl 			;
	private static  String UserName 		;
	private static  String pwd 				;

	// 使用ThreadLocal存储当前线程中的Connection对象
	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

	// 在静态代码块中创建数据库连接池
	static {
		try
		{
			if(null==rbundle)
			{
				rbundle = ResourceBundle.getBundle("conf/db/db");// 为空时读取配置文件
			}

			DriverClassName = rbundle.getString("DriverClassName");//  静态私有不可继承-只属于自己 | 不可改变
			JdbcUrl 		= rbundle.getString("JdbcUrl");
			UserName 		= rbundle.getString("UserName");
			pwd 			= rbundle.getString("pwd");

			System.out.println("**\tRead db.properties info ... ");
			System.out.println("**\tdriverClassName : " +DriverClassName);
			System.out.println("**\turl : " +JdbcUrl);
			System.out.println("**\tusername : " +UserName);
			System.out.println("**\tpassword : " +pwd);
			System.out.println("**\tDatabase connect start ...");


			dataSource.setDriverClass(DriverClassName);
			dataSource.setJdbcUrl(JdbcUrl);
			dataSource.setUser(UserName);
			dataSource.setPassword(pwd);

			dataSource.setInitialPoolSize(10);
			dataSource.setMinPoolSize(5);
			dataSource.setMaxPoolSize(50);

			dataSource.setMaxStatements(100);
			dataSource.setMaxIdleTime(60);

		}
		catch (Exception e) {			throw new ExceptionInInitializerError(e);		}
	}





	/**
	 * @Method: getDataSource
	 * @Description: 获取数据源
	 * @author: 钢背猪☣
	 * @return DataSource 返回:javax.sql.DataSource
	 */
	public static DataSource getDataSource()
	{
		return dataSource;
	}


	/**
	 * @Method: getConnection
	 * @Description: 从数据源中获取数据库连接
	 * @author: 钢背猪☣
	 * @return Connection
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException
	{
		// 从当前线程中获取Connection
		Connection conn = threadLocal.get();
		if (conn == null)
		{
			conn = getDataSource().getConnection();
			threadLocal.set(conn);
		}
		return conn;
	}

	/**
	 * @Method: startTransaction
	 * @Description: 开启事务
	 * @author: 钢背猪☣
	 *
	 */
	public static void startTransaction()
	{
		try
		{
			Connection conn = threadLocal.get();
			if (conn == null)
			{
				conn = getConnection();
				threadLocal.set(conn);
			}
			// 开启事务
			conn.setAutoCommit(false);
		}
		catch (Exception e) {			throw new RuntimeException(e);		}
	}

	/**
	 * @Method: rollback
	 * @Description:回滚事务
	 * @author: 钢背猪☣
	 *
	 */
	public static void rollback() {
		try {
			// 从当前线程中获取Connection
			Connection conn = threadLocal.get();
			if (conn != null) {
				conn.rollback();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @Method: commit
	 * @Description:提交事务
	 * @author: 钢背猪☣
	 *
	 */
	public static void commit() {
		try {
			// 从当前线程中获取Connection
			Connection conn = threadLocal.get();
			if (conn != null) {
				conn.commit();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @Method: close
	 * @Description:关闭数据库连接(注意，并不是真的关闭，而是把连接还给数据库连接池)
	 * @author: 钢背猪☣
	 *
	 */
	public static void close() {
		try {
			// 从当前线程中获取Connection
			Connection conn = threadLocal.get();
			if (conn != null) {
				conn.close();
				threadLocal.remove();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


	
	public static void main(String[] args) throws SQLException {
		Connection conn = getDataSource().getConnection();
		System.out.println(conn);
	}
}