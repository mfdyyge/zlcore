package com.zl.core.jdbc.DataSource;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
/**
 * @ClassName:   DsFactory_HikariCp 光连接池
 * @Description: HikariCp-光连接池 \n 采用线程安全\n为了单例模式不出现并发错误的一种每个线程
 * @author: 钢背猪☣
 * @date: 2017-07-04 下午4:04:36
 */
public class DsFactory_HikariCp
{
	protected static Logger logger = Logger.getLogger(DsFactory_HikariCp.class);
	public  static final String DS_NAME = "HikariCp";

	private static HikariConfig 	config;
	private static HikariDataSource dataSource	;

	static
	{// 在静态代码块中创建数据库连接池


	}



	/**
	 * @Method: getDataSource
	 * @Description: 获取数据源
	 * @author: 钢背猪☣
	 * @return DataSource
	 * 修改：2017年8月29日18:12:22
	 */
	public static DataSource getDataSource(DsProperties dsProperties)
	{
		logger.info("**\tRead db.properties info ... ");

		//config 		= new HikariConfig();//暂时没用
		dataSource	= new HikariDataSource();

		dataSource.setDriverClassName(dsProperties.getDriverClassName());
		dataSource.setJdbcUrl(dsProperties.getJdbcUrl());
		dataSource.setUsername(dsProperties.getDbName());
		dataSource.setPassword(dsProperties.getPwd());
		/****************************************************************/

		dataSource.setAutoCommit(true);//设置事务[默认=>自动提交]

		/*
		* 连接只读数据库时配置为true， 保证安全
		* */
		dataSource.setReadOnly(false);

		/*
		* 等待连接池-分配连接的-最大时长（毫秒）
		* 超过这个时长还没可用的连接则发生SQLException
		* 缺省:30秒
		* */
		dataSource.setConnectionTimeout(3000);//3000毫秒
		/*
		* 一个连接idle状态的最大时长（毫秒）
		* 超时则被释放（retired）
		* 缺省:10分钟
		* */
		dataSource.setIdleTimeout(5000);//5000毫秒

		/*
		* 一个连接的生命时长（毫秒）
		* 超时而且没被使用则被释放（retired）
		* 缺省:30分钟，
		* 建议设置比数据库超时时长少30秒，
		* 参考MySQL wait_timeout参数（show variables like '%timeout%';）
		* 1000毫秒=1秒
		* 60000毫秒=1分
		* */
		dataSource.setMaxLifetime(600000);//10分钟-[链接池中->保持数据库链接->时间]
		/*
		* 连接池中允许的最大连接数
		* 缺省值：10；
		* 推荐的公式：((core_count * 2) + effective_spindle_count)
		* */
		dataSource.setMaximumPoolSize(40);



		/**
		 * 其中，很多配置都使用缺省值就行了，除了[MaxLifetime]和[MaximumPoolSize]要注意自己计算一下。
		 其他的配置
		 [sqlSessionFactory、
		 MyBatis MapperScannerConfigurer、
		 transactionManager等]统统不用变。

		 其他关于Datasource配置参数的建议：
		 Configure your HikariCP idleTimeout and maxLifeTime settings to be one minute less than the wait_timeout of MySQL.
		 对于有Java连接池的系统，
		 建议MySQL的wait_timeout使用缺省的8小时（http://www.rackspace.com/knowledge_center/article/how-to-change-the-mysql-timeout-on-a-server）。


		 另外：对于web项目，记得要配置：destroy-method="shutdown"
		 */
		return dataSource;
	}

}