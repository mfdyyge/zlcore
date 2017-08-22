package com.zl.jdbc.DataSource;

/**
 * Created by 钢背猪☣ on 2017-8-10 0010.
 *
 * @ClassName: com.zl.jdbc.DataSource
 * @Description: 描述:db.properties
 * @author: 钢背猪☣474752515@qq.com
 * @date: 2017-8-10 0010
 */
public class DsProperties
{
    //
    public  static final String 			HikariCp_NAME 	= "HikariCp";
    public  static final String 			druid_NAME 		= "druid";
    public 	static final String 			TomcatJdbc_NAME = "TomcatJdbc";
    public  static final String 			c3p0_NAME 		= "c3p0";


    /**********************************************************************/
    /**
     *  db.properties=>链接池名字
     */
    public static 	String 					DataSourceName;

    public static 	String 					DriverClassName;
    public static 	String 					JdbcUrl;
    public static 	String 					UserName;
    public static 	String 					pwd;

}
