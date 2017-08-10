package com.zl.jdbc.DataSource;




import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static com.zl.jdbc.DataSource.DsProperties.*;

/**
 * @ClassName:   DsFactory
 * @Description: DsFactory-数据库连接池 创建类:
 * @author: 钢背猪☣
 * @date: 2017-06-01 下午2:04:36
 */
public class DsFactory
{


	public	static final DataSource 		dataSource;// 数据库连接池

	/**********************************************************************///目前支持四种[ HikariCp |druid |TomcatJdbc |c3p0 ]
	private static 	String 					DataSourceName;	//链接池名字

	public static 	String 					DriverClassName;
	public static 	String 					JdbcUrl;
	public static 	String 					UserName;
	public static 	String 					pwd;

	/**********************************************************************///公共对象直接引用-[直接通过类来调用>而不需要新建对象]
	private static	ResourceBundle			rbundle;//配置文件读取类
	private static	ThreadLocal<Connection>	threadLocal = new ThreadLocal<Connection>();	// 使用ThreadLocal存储当前线程中的Connection对象



	static
	{
		if(null==rbundle)
		{
			rbundle = ResourceBundle.getBundle("conf/db/db");//配置文件读取类
		}

		if (null==DataSourceName)
		{
			DataSourceName  = rbundle.getString("DataSourceName");//读取配置文件中的链接池名字
		}

		DriverClassName = rbundle.getString("DriverClassName");//数据库驱动类型
		JdbcUrl 		= rbundle.getString("JdbcUrl");		//数据库链接地址
		UserName 		= rbundle.getString("UserName");
		pwd 			= rbundle.getString("pwd");

		switch (DataSourceName)
		{
			case HikariCp_NAME:
				System.out.println("conf/db/db.properties>DataSourceName = " + DataSourceName);
				dataSource =  DsFactory_HikariCp.getDataSource();
				break;
			case druid_NAME:
				System.out.println("conf/db/db.properties>DataSourceName = " + DataSourceName);
				dataSource =  DsFactory_Druid.getDataSource();
				break;
			case TomcatJdbc_NAME:
				System.out.println("conf/db/db.properties>DataSourceName = " + DataSourceName);
				dataSource =  DsFactory_TomcatJdbc.getDataSource();
				break;
			case c3p0_NAME:
				System.out.println("conf/db/db.properties>DataSourceName = " + DataSourceName);
				dataSource =  DsFactory_C3p0.getDataSource();
				break;
			default:
				System.out.println("因为配置文件中链接池名字[conf/db/db.properties>DataSourceName=?]无法匹配");
				System.out.println("默认配置=>conf/db/db.properties>DataSourceName = " + DataSourceName);
				dataSource =  DsFactory_Druid.getDataSource();
		}
	}




	/**
	 * @Method: getDataSource
	 * @Description: 获取数据源
	 * @author: 钢背猪☣
	 * @return DataSource
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
	public static Connection getConnection()
	{
		// 从当前线程中获取Connection
		Connection conn = threadLocal.get();
		if (conn == null)
		{
			try
			{
				conn = getDataSource().getConnection();
			}
			catch (SQLException e)
			{
				System.out.println(" com.zl.jdbc.DataSource.DataSouceFactory_InterFace.getConnection() 获取链接出错! " );
				e.printStackTrace();
			}
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
			Connection conn = threadLocal.get();//有获取当前线程的Conn | 没有就从链接池中取
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
			if (conn != null)
			{
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

	// 判断连接是否可用
	private boolean isValid(Connection conn) {
		try {
			if (conn == null || conn.isClosed()) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	/**
	 * @Method: close
	 * @Description:关闭数据库连接(注意，并不是真的关闭，而是把连接还给数据库连接池)
	 * @author: 钢背猪☣
	 *
	 */
	public static void close()
	{
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


	public static void main(String[] args) throws SQLException
    {
		//Connection conn = getConnection();
		//System.out.println("\nconn="+conn);
	}
}