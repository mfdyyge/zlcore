package com.zl.jdbc.DataSource;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

import static com.zl.jdbc.DataSource.DsProperties.*;

/**
 * @ClassName:   DsFactory_HikariCp 光连接池
 * @Description: HikariCp-光连接池 \n 采用线程安全\n为了单例模式不出现并发错误的一种每个线程
 * @author: 钢背猪☣
 * @date: 2017-07-04 下午4:04:36
 */
public class DsFactory_TomcatJdbc
{

	public static final String DS_NAME = "TomcatJdbc";

	private static PoolProperties poolProps ;//暂时没用
	private static org.apache.tomcat.jdbc.pool.DataSource dataSource;


	static
	{// 在静态代码块中创建数据库连接池
		try
		{

			System.out.println("**\tRead db.properties info ... ");
			System.out.println("**\tDatabase connect start ...DS_NAME=["+DS_NAME+"]");

			poolProps = new PoolProperties();
			dataSource=new org.apache.tomcat.jdbc.pool.DataSource();

			dataSource.setDriverClassName(DriverClassName);
			dataSource.setUrl(JdbcUrl);
			dataSource.setUsername(UserName);
			dataSource.setPassword(pwd);
			dataSource.setDefaultAutoCommit(true);//设置事务[默认=>自动提交]
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

}