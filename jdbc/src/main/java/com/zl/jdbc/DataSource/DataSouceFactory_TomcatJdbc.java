package com.zl.jdbc.DataSource;

import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.apache.tomcat.jdbc.pool.DataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.ResourceBundle;


/**
 * @ClassName:   DataSouceFactory__HikariCp 光连接池
 * @Description: HikariCp-光连接池 \n 采用线程安全\n为了单例模式不出现并发错误的一种每个线程
 * @author: 钢背猪☣
 * @date: 2017-07-04 下午4:04:36
 */
public class DataSouceFactory_TomcatJdbc {

	public static final String DS_NAME = "TomcatJdbc";

	private final PoolProperties poolProps = new PoolProperties();
	private static org.apache.tomcat.jdbc.pool.DataSource dataSource;

    //private static final ResourceBundle rbundle = ResourceBundle.getBundle("conf/db/db");// 静态私有不可继承-只属于自己
	private static ResourceBundle rbundle=null; //读取配置文件
	public DataSouceFactory_TomcatJdbc(ResourceBundle rsb )
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
			dataSource=new org.apache.tomcat.jdbc.pool.DataSource();

			dataSource.setDriverClassName(DriverClassName);
			dataSource.setUrl(JdbcUrl);
			dataSource.setUsername(UserName);
			dataSource.setPassword(pwd);
			/****************************************************************/



		}
		catch (Exception e) {			throw new ExceptionInInitializerError(e);		}
	}



	/**
	 * @Method: getDataSource
	 * @Description: 获取数据源
	 * @author: 钢背猪☣
	 * @return DataSource:此处返回=>org.apache.tomcat.jdbc.pool.DataSource
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




	public static void test(){};

	public static void main(String[] args) throws SQLException
    {
		Connection conn = getConnection();
		System.out.println("\nconn="+conn);
	}
}