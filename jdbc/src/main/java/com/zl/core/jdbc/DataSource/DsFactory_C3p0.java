package com.zl.core.jdbc.DataSource;



import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;


/**
 * @ClassName: JdbcUtils
 * @Description: 数据库连接工具类
 * @author: 钢背猪☣
 * @date: 2017-07-01 下午1:04:36
 */
public class DsFactory_C3p0
{
	protected static Logger logger = Logger.getLogger(DsFactory_C3p0.class);

	public  static final String 	DS_NAME 		= "c3p0";
	private static ComboPooledDataSource dataSource ;


	static
	{// 在静态代码块中创建数据库连接池


	}





	/**
	 * @Method: getDataSource
	 * @Description: 获取数据源
	 * @author: 钢背猪☣
	 * @return DataSource 返回:javax.utils.DataSource
	 */
	public static DataSource getDataSource(DsProperties dsProperties)
	{
		logger.info("返回[ ComboPooledDataSource 链接池]");
		dataSource = new ComboPooledDataSource();// C3P0数据库连接池
		try
		{
			dataSource.setDriverClass(dsProperties.getDriverClassName());//这里会抛出异常
			dataSource.setJdbcUrl(dsProperties.getJdbcUrl());
			dataSource.setUser(dsProperties.getDbName());
			dataSource.setPassword(dsProperties.getPwd());
			dataSource.setAutoCommitOnClose(true);//设置事务[默认=>自动提交]
			/****************************************************************/

			dataSource.setInitialPoolSize(10);
			dataSource.setMinPoolSize(5);
			dataSource.setMaxPoolSize(50);

			dataSource.setMaxStatements(100);
			dataSource.setMaxIdleTime(60);
		}
		catch (PropertyVetoException e)
		{
			System.out.println("DsFactory_C3p0>设置时出错〉dataSource.setDriverClass(DriverClassName) ");
			//e.printStackTrace();
		}
		return dataSource;
	}

}