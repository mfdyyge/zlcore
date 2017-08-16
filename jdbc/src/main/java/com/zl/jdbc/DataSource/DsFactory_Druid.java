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
		dataSource.setDefaultAutoCommit(true);//设置事务[默认=>自动提交]
		/****************************************************************/

		dataSource.setLogAbandoned(true);   //关闭连接是否记录日志, 默认为false,改为true.
		dataSource.setRemoveAbandoned(true);//是否关闭未关闭的连接, 默认为false, 改为true ,即超过removeAbandonedTimeout的连接,进行强制关闭.
		dataSource.setRemoveAbandonedTimeout(30);//通过datasource.getConnontion() 取得的连接必须在removeAbandonedTimeout这么多秒内调用close(),要不我就弄死你.(就是conn不能超过指定的租期)

		dataSource.setInitialSize(50);//初始化时建立物理连接的个数。初始化发生在显示调用init方法，或者第一次getConnection时
		dataSource.setMaxActive(100);//最大连接池数量
		dataSource.setMinIdle(0);	//最小连接池数量
		dataSource.setMaxWait(60000);//获取连接时最大等待时间，单位毫秒。配置了maxWait之后，缺省启用公平锁，并发效率会有所下降，如果需要可以通过配置useUnfairLock属性为true使用非公平锁。

		dataSource.setValidationQuery("SELECT 1");
		dataSource.setTestOnBorrow(false);//申请连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能
		dataSource.setTestWhileIdle(true);//建议配置为true，不影响性能，并且保证安全性。申请连接的时候检测，如果空闲时间大于timeBetweenEvictionRunsMillis，执行validationQuery检测连接是否有效。

		dataSource.setPoolPreparedStatements(false);//是否缓存preparedStatement，也就是PSCache。PSCache对支持游标的数据库性能提升巨大，比如说oracle。在mysql下建议关闭。
		//maxOpenPreparedStatements 	-1 	要启用PSCache，必须配置大于0，当大于0时，poolPreparedStatements自动触发修改为true。在Druid中，不会存在Oracle下PSCache占用内存过多的问题，可以把这个数值配置大一些，比如说100
		dataSource.setMaxOpenPreparedStatements(1000);
		dataSource.setMaxPoolPreparedStatementPerConnectionSize(10);
	}


	/**
	 * @Method: getDataSource
	 * @Description: 获取数据源
	 * @author: 钢背猪☣
	 * @return DataSource 返回:javax.utils.DataSource
	 */
	public static DataSource getDataSource()
	{
		return dataSource;
	}

}