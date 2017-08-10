package com.zl.jdbc.DataSource;



import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;

/**
 * @ClassName:   DataSouceFactory_InterFace
 * @Description: druid-数据库连接池 \n 采用线程安全\n为了单例模式不出现并发错误的一种每个线程
 * @author: 钢背猪☣
 * @date: 2017-06-01 下午2:04:36
 */
public class DsFactory_Druid
{

	public  static final String DS_NAME = "druid";

	private static DruidDataSource dataSource;// druid数据库连接池



	static
	{// 在静态代码块中创建数据库连接池


		System.out.println("**\tRead db.properties info ... ");
		System.out.println("**\tDatabase connect start ...DS_NAME=["+DS_NAME+"]");

		dataSource= new DruidDataSource();// druid数据库连接池

		dataSource.setDriverClassName(DsFactory.DriverClassName);
		dataSource.setUrl(DsFactory.JdbcUrl);
		dataSource.setUsername(DsFactory.UserName);
		dataSource.setPassword(DsFactory.pwd);
		/****************************************************************/

		dataSource.setLogAbandoned(true);   //关闭连接是否记录日志, 默认为false,改为true.
		dataSource.setRemoveAbandoned(true);//是否关闭未关闭的连接, 默认为false, 改为true ,即超过removeAbandonedTimeout的连接,进行强制关闭.
		dataSource.setRemoveAbandonedTimeout(30);//通过datasource.getConnontion() 取得的连接必须在removeAbandonedTimeout这么多秒内调用close(),要不我就弄死你.(就是conn不能超过指定的租期)

		dataSource.setInitialSize(2);
		dataSource.setMaxActive(20);
		dataSource.setMinIdle(0);
		dataSource.setMaxWait(60000);
		dataSource.setValidationQuery("SELECT 1");
		dataSource.setTestOnBorrow(false);
		dataSource.setTestWhileIdle(true);
		dataSource.setPoolPreparedStatements(false);
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

}