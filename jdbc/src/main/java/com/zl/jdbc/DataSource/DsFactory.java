package com.zl.jdbc.DataSource;



import com.zl.jdbc.DataSource.spring.DsSpring_Factory;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static com.zl.jdbc.DataSource.DsProperties.*;



/**
 * @ClassName:   DsFactory
 * @Description: DsFactory-数据库连接池>获取>默认Druid连接池<br>//目前支持四种[ HikariCp |druid |TomcatJdbc |c3p0 ]
 * @author: 钢背猪☣
 * @date: 2017-06-01 下午2:04:36
 */
public class DsFactory
{
	protected static Logger logger = Logger.getLogger(DsFactory.class);

	private StringBuffer msg;
	private static DataSource 		dataSource;// 数据库连接池

	/**********************************************************************/
/*	private static 	String 					DataSourceName;	//链接池名字

	public static 	String 					DriverClassName;
	public static 	String 					JdbcUrl;
	public static 	String 					DbName;
	public static 	String 					pwd;*/

	/**********************************************************************///公共对象直接引用-[直接通过类来调用>而不需要新建对象]
	private static	ResourceBundle			rbundle;//配置文件读取类
	private static	ThreadLocal<Connection>	threadLocal = new ThreadLocal<Connection>();	// 使用ThreadLocal存储当前线程中的Connection对象



	/**
	 * 没有指定配置文件名字->默认加载：db.properties 文件
	 * @param db_properties_filename:数据库配置文件名字
	 */
	public DsFactory()
	{
		String db_properties_filename="db";

		DsProperties 	dsProperties	=new DsProperties(db_properties_filename);

		String 			DataSourceName	=dsProperties.getDataSourceName();
		switch (DataSourceName)
		{
			case HikariCp_NAME:
				dataSource =  DsFactory_HikariCp.getDataSource(dsProperties);
				break;
			case druid_NAME:
				dataSource =  DsFactory_Druid.getDataSource(dsProperties);
				break;
			case TomcatJdbc_NAME:
				dataSource =  DsFactory_TomcatJdbc.getDataSource(dsProperties);
				break;
			case c3p0_NAME:
				dataSource =  DsFactory_C3p0.getDataSource(dsProperties);
				break;
			default:
				System.out.println("因为[配置文件]中链接池名字[conf/db/db.properties>DataSourceName=?]无法匹配");
				System.out.println("默认配置=>conf/db/db.properties >>> DataSourceName = " + DataSourceName);
				dataSource =  DsFactory_Druid.getDataSource(dsProperties);
		}
	}

	/**
	 * 配置文件名字==null->默认加载：db.properties 文件
	 * @param db_properties_filename:数据库配置文件名字
	 */
	public DsFactory(String db_properties_filename)
	{
		//配置文件名字==null->默认加载：db.properties 文件
		if(null==db_properties_filename || !("".equals(db_properties_filename))) {db_properties_filename="db";	}

		DsProperties 	dsProperties	=new DsProperties(db_properties_filename);
		String 			DataSourceName	=dsProperties.getDataSourceName();
		System.out.println("com.zl.jdbc.DataSource.DsFactory.DsFactory(java.lang.String) DataSourceName = " + DataSourceName);
		switch (DataSourceName)
		{
			case HikariCp_NAME:
				dataSource =  DsFactory_HikariCp.getDataSource(dsProperties);
				break;
			case druid_NAME:
				dataSource =  DsFactory_Druid.getDataSource(dsProperties);
				break;
			case TomcatJdbc_NAME:
				dataSource =  DsFactory_TomcatJdbc.getDataSource(dsProperties);
				break;
			case c3p0_NAME:
				dataSource =  DsFactory_C3p0.getDataSource(dsProperties);
				break;
			default:
				System.out.println("因为配置文件中链接池名字[conf/db/db.properties>DataSourceName=?]无法匹配");
				System.out.println("默认配置=>conf/db/db.properties>DataSourceName = " + DataSourceName);
				dataSource =  DsFactory_Druid.getDataSource(dsProperties);
		}
	}


	/**
	 * @Method: getDataSource
	 * @Description: 获取数据源
	 * @author: 钢背猪☣
	 * @return DataSource
	 */
	public  DataSource getDataSource()
	{
		DataSource dataSource_DsSpring=DsSpring_Factory.getDataSource();
		if( null != dataSource_DsSpring)
		{
			logger.info(new StringBuffer("当前使用Spring配置的dataSource_dataSource_DsSpring.getClass() = ").append(dataSource_DsSpring.getClass()));
			return dataSource_DsSpring;
		}
		return DsFactory.dataSource;

	}



	/**
	 * @Method: getConnection
	 * @Description: 从数据源中获取数据库连接
	 * @author: 钢背猪☣
	 * @return Connection
	 * @throws SQLException
	 */
	public  Connection getConnection()
	{
		// 从当前线程中获取Connection
		Connection conn = threadLocal.get();
		if ( null==conn)
		{
			try
			{
				conn = getDataSource().getConnection();
			}
			catch (SQLException e)
			{
				logger.error(new StringBuffer("获取链接出错! ").append(e));
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
	public  void startTransaction()
	{
		try
		{
			Connection conn = threadLocal.get();//有获取当前线程的Conn | 没有就从链接池中取
			if ( null==conn)
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
	public  void rollback()
	{
		try {
			// 从当前线程中获取Connection
			Connection conn = threadLocal.get();
			if ( null!=conn)
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
	public  void commit()
	{
		try
		{
			// 从当前线程中获取Connection
			Connection conn = threadLocal.get();
			if ( null!=conn)
			{
				conn.commit();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * * 判断是否可用<br/>
	 * @return
	 */
	public  boolean isValid(Connection conn)
	{
		try
		{
			if (null==conn || conn.isClosed())
			{
				return false;
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * Connection conn = threadLocal.get();〈br/〉
	 * 判断当前线程[conn]是否可用<br/>
	 * @return
	 */
	public  boolean isValid()
	{
		Connection conn = threadLocal.get();
		try
		{
			if (null==conn || conn.isClosed())
			{
				return false;
			}
		}
		catch (SQLException e)
		{
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
	public  void close()
	{
		try
		{
			// 从当前线程中获取Connection
			Connection conn = threadLocal.get();
			if ( null!=conn)
			{
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