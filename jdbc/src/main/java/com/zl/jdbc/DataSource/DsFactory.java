package com.zl.jdbc.DataSource;




import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * @ClassName:   DsFactory
 * @Description: DsFactory-数据库连接池 创建类:
 * @author: 钢背猪☣
 * @date: 2017-06-01 下午2:04:36
 */
public class DsFactory
{
	// conf/db/db.properties  里面的DataSourceName=?
	public  static final String HikariCp_NAME 	= "HikariCp";
	public  static final String druid_NAME 		= "druid";
	public 	static final String TomcatJdbc_NAME = "TomcatJdbc";
	public  static final String c3p0_NAME 		= "c3p0";

	private static final DataSource dataSource;// druid数据库连接池
	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();	// 使用ThreadLocal存储当前线程中的Connection对象

	private static ResourceBundle rbundle = ResourceBundle.getBundle("conf/db/db");
	private static final String DataSourceName = rbundle.getString("DataSourceName");//  设置要使用的链接池关键字-目前支持四种[ HikariCp |druid |TomcatJdbc |c3p0 ]

	static
	{
		switch (DataSourceName)
		{
			case HikariCp_NAME:
				System.out.println("conf/db/db.properties>DataSourceName = " + DataSourceName);
				dataSource = new DsFactory_HikariCp(rbundle).getDataSource();
				break;
			case druid_NAME:
				System.out.println("conf/db/db.properties>DataSourceName = " + DataSourceName);
				dataSource = new DsFactory_Druid(rbundle).getDataSource();
				break;
			case TomcatJdbc_NAME:
				System.out.println("conf/db/db.properties>DataSourceName = " + DataSourceName);
				dataSource = new DsFactory_TomcatJdbc(rbundle).getDataSource();
				break;
			case c3p0_NAME:
				System.out.println("conf/db/db.properties>DataSourceName = " + DataSourceName);
				dataSource = new DsFactory_C3p0(rbundle).getDataSource();
				break;
			default:
				System.out.println("因为配置文件中链接池名字[conf/db/db.properties>DataSourceName=?]无法匹配");
				System.out.println("默认配置=>conf/db/db.properties>DataSourceName = " + DataSourceName);
				dataSource = new DsFactory_Druid(rbundle).getDataSource();
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