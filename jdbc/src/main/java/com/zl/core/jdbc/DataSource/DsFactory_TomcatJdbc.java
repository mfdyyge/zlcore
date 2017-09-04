package com.zl.core.jdbc.DataSource;

import org.apache.log4j.Logger;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

/**
 * @ClassName:   DsFactory_HikariCp 光连接池
 * @Description: HikariCp-光连接池 \n 采用线程安全\n为了单例模式不出现并发错误的一种每个线程
 * @author: 钢背猪☣
 * @date: 2017-07-04 下午4:04:36
 */
public class DsFactory_TomcatJdbc
{
	protected static Logger logger = Logger.getLogger(DsFactory_TomcatJdbc.class);

	public static final String DS_NAME = "TomcatJdbc";

	private static PoolProperties poolProps ;//暂时没用
	private static org.apache.tomcat.jdbc.pool.DataSource dataSource;


	static
	{// 在静态代码块中创建数据库连接池

	}



	/**
	 * @Method: getDataSource
	 * @Description: 获取数据源
	 * @author: 钢背猪☣
	 * @return DataSource:此处返回=>org.apache.tomcat.orcl.pool.DataSource
	 */
	public static DataSource getDataSource(DsProperties dsProperties)
	{
		logger.info("**\tRead db.properties info ... ");
		poolProps = new PoolProperties();
		dataSource=new org.apache.tomcat.jdbc.pool.DataSource();

		dataSource.setDriverClassName(dsProperties.getDriverClassName());
		dataSource.setUrl(dsProperties.getJdbcUrl());
		dataSource.setUsername(dsProperties.getDbName());
		dataSource.setPassword(dsProperties.getPwd());
		dataSource.setDefaultAutoCommit(true);//设置事务[默认=>自动提交]
		/****************************************************************/


		return dataSource;
	}

}