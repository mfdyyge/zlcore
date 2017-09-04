package com.zl.core.jdbc.DataSource.spring;


import javax.sql.DataSource;

/**
 * @ClassName:   Druid_Factory
 * @Description: druid-数据库连接池 \n 采用线程安全\n为了单例模式不出现并发错误的一种每个线程
 * @author: 钢背猪☣
 * @date: 2017-06-01 下午2:04:36
 */
public class DsSpring_Factory
{

	private static DataSource dataSource;// druid数据库连接池
    public void setDataSource(DataSource ds)
	{
		this. dataSource=ds;
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

}