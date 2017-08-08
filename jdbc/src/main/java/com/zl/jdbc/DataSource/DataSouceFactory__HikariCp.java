package com.zl.jdbc.DataSource;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.ResourceBundle;
import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * @ClassName:   DataSouceFactory__HikariCp 光连接池
 * @Description: HikariCp-光连接池 \n 采用线程安全\n为了单例模式不出现并发错误的一种每个线程
 * @author: 钢背猪☣
 * @date: 2017-07-04 下午4:04:36
 */
public class DataSouceFactory__HikariCp
{


	public  static final String DS_NAME = "HikariCp";

	private static HikariConfig 	config 		= new HikariConfig();
	private static HikariDataSource dataSource	= new HikariDataSource();


    //static ResourceBundle rbundle = ResourceBundle.getBundle("conf/db/db");
	private static ResourceBundle rbundle=null; //读取配置文件
	public DataSouceFactory__HikariCp(ResourceBundle rsb )
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

			dataSource.setDriverClassName(DriverClassName);
			dataSource.setJdbcUrl(JdbcUrl);
			dataSource.setUsername(UserName);
			dataSource.setPassword(pwd);
			/****************************************************************/

			/*
			* 连接只读数据库时配置为true， 保证安全
			* */
			dataSource.setReadOnly(false);

			/*
			* 等待连接池-分配连接的-最大时长（毫秒）
			* 超过这个时长还没可用的连接则发生SQLException
			* 缺省:30秒
			* */
			dataSource.setConnectionTimeout(3000);//3秒
			/*
			* 一个连接idle状态的最大时长（毫秒）
			* 超时则被释放（retired）
			* 缺省:10分钟
			* */
			dataSource.setIdleTimeout(6000);//6秒

			/*
			* 一个连接的生命时长（毫秒）
			* 超时而且没被使用则被释放（retired）
			* 缺省:30分钟，
			* 建议设置比数据库超时时长少30秒，
			* 参考MySQL wait_timeout参数（show variables like '%timeout%';）
			* 1000毫秒=1秒
			* 60000毫秒=1分
			* */
			dataSource.setMaxLifetime(600000);//6分钟-[链接池中->保持数据库链接->时间]
			/*
			* 连接池中允许的最大连接数
			* 缺省值：10；
			* 推荐的公式：((core_count * 2) + effective_spindle_count)
			* */
			dataSource.setMaximumPoolSize(40);


/*
*
* 其中，很多配置都使用缺省值就行了，除了MaxLifetime和MaximumPoolSize要注意自己计算一下。
其他的配置（sqlSessionFactory、MyBatis MapperScannerConfigurer、transactionManager等）统统不用变。

其他关于Datasource配置参数的建议：
Configure your HikariCP idleTimeout and maxLifeTime settings to be one minute less than the wait_timeout of MySQL.
对于有Java连接池的系统，
建议MySQL的wait_timeout使用缺省的8小时（http://www.rackspace.com/knowledge_center/article/how-to-change-the-mysql-timeout-on-a-server）。


另外：对于web项目，记得要配置：destroy-method="shutdown"
*/
		}
		catch (Exception e) {			throw new ExceptionInInitializerError(e);		}
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
	 * @Description: 开启事务=>提交事务commit()> 回滚事务rollback()
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


	public static void test(){};

	public static void main(String[] args) throws SQLException
    {
		Connection conn = getConnection();
		System.out.println("\nconn="+conn);
	}
}