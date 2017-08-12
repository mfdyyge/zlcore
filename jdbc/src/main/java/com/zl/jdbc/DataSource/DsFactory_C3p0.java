package com.zl.jdbc.DataSource;



import com.mchange.v2.c3p0.ComboPooledDataSource;

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

	public  static final String 	DS_NAME 		= "c3p0";
	private static ComboPooledDataSource dataSource ;


	static
	{// 在静态代码块中创建数据库连接池

		System.out.println("**\tRead db.properties info ... ");
		System.out.println("**\tDatabase connect start ...DS_NAME=["+DS_NAME+"]");

		dataSource = new ComboPooledDataSource();// C3P0数据库连接池
		try
		{
			dataSource.setDriverClass(DsFactory.DriverClassName);//这里会抛出异常
			dataSource.setJdbcUrl(DsFactory.JdbcUrl);
			dataSource.setUser(DsFactory.UserName);
			dataSource.setPassword(DsFactory.pwd);

			dataSource.setInitialPoolSize(10);
			dataSource.setMinPoolSize(5);
			dataSource.setMaxPoolSize(50);

			dataSource.setMaxStatements(100);
			dataSource.setMaxIdleTime(60);
		}
		catch (PropertyVetoException e)
		{
			System.out.println("com.zl.jdbc.DataSource.DsFactory_C3p0>设置时出错〉dataSource.setDriverClass(DriverClassName) ");
			//e.printStackTrace();
		}
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