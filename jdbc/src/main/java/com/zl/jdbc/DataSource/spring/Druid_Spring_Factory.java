package com.zl.jdbc.DataSource.spring;


import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * @ClassName:   Druid_Factory
 * @Description: druid-数据库连接池 \n 采用线程安全\n为了单例模式不出现并发错误的一种每个线程
 * @author: 钢背猪☣
 * @date: 2017-06-01 下午2:04:36
 */
public class Druid_Spring_Factory {

	public  static final String DS_NAME = "druid";

	private static DruidDataSource dataSource;// druid数据库连接池
    public void setDataSource(DruidDataSource ds)
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


	public static void test(){};

	public static void main(String[] args) throws SQLException
    {
		Connection conn = getDataSource().getConnection();
		System.out.println("\nconn="+conn);
	}
}