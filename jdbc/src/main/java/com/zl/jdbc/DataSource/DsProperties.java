package com.zl.jdbc.DataSource;


import org.apache.log4j.Logger;

import java.util.ResourceBundle;

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
    protected static Logger logger = Logger.getLogger(DsProperties.class);

    public  static final String 			HikariCp_NAME 	= "HikariCp";
    public  static final String 			druid_NAME 		= "druid";
    public 	static final String 			TomcatJdbc_NAME = "TomcatJdbc";
    public  static final String 			c3p0_NAME 		= "c3p0";


    /**********************************************************************/
    /**
     *  db.properties=>链接池名字
     */
    private  	String 					dataSourceName;

    private  	String 					driverClassName;//数据库驱动类型
    private  	String 					jdbcUrl;        //数据库链接地址
    private  	String 					dbName;
    private  	String 					pwd;

    private static	ResourceBundle			rbundle;//配置文件读取类
    private static  StringBuffer            dbPropertiesPath=new StringBuffer("conf/db/");

    private String msg;




    /**
     *
     * @param db_properties_filename:数据库配置文件名字
     */
    public DsProperties(String db_properties_filename)
    {
        dbPropertiesPath.append(db_properties_filename);

        if(null==rbundle)
            {
                logger.info(new StringBuffer("行 >>>[配置文件读取] = ").append(dbPropertiesPath));
                //System.out.println(msg);
                rbundle = ResourceBundle.getBundle(dbPropertiesPath.toString());//配置文件读取类
            }

            if (null==dataSourceName)
            {
                dataSourceName  = rbundle.getString("DataSourceName");//读取配置文件中的链接池名字
            }

        driverClassName = rbundle.getString("DriverClassName");
        jdbcUrl 		= rbundle.getString("JdbcUrl");
        dbName 		    = rbundle.getString("DbName");
        pwd 			= rbundle.getString("pwd");
        logger.info(new StringBuffer("行 >>>[配置文件读取]  DataSourceName = ").append(dataSourceName));
    }

    /**
     * 加载默认配置文件：conf/db/db
     */
    public DsProperties()
    {
        if(null==rbundle)
        {
            //System.out.println(msg);
            logger.info(new StringBuffer("行 >>>[配置文件读取] = ").append(dbPropertiesPath));


            rbundle = ResourceBundle.getBundle("conf/db/db");//配置文件读取类

        }

        if (null==dataSourceName)
        {
            dataSourceName  = rbundle.getString("DataSourceName");//读取配置文件中的链接池名字
        }

        driverClassName = rbundle.getString("DriverClassName");
        jdbcUrl 		= rbundle.getString("JdbcUrl");
        dbName 		    = rbundle.getString("DbName");
        pwd 			= rbundle.getString("pwd");

        logger.info(new StringBuffer("行 >>>[配置文件读取]  DataSourceName = ").append(dataSourceName));
    }


    /**
     * Getter for property 'dataSourceName'.
     *
     * @return Value for property 'dataSourceName'.
     */
    public String getDataSourceName()
    {
        return dataSourceName;
    }

    /**
     * Setter for property 'dataSourceName'.
     *
     * @param dataSourceName Value to set for property 'dataSourceName'.
     */
    public void setDataSourceName(String dataSourceName)
    {
        this.dataSourceName = dataSourceName;
    }

    /**
     * Getter for property 'driverClassName'.
     *
     * @return Value for property 'driverClassName'.
     */
    public String getDriverClassName()
    {
        return driverClassName;
    }

    /**
     * Setter for property 'driverClassName'.
     *
     * @param driverClassName Value to set for property 'driverClassName'.
     */
    public void setDriverClassName(String driverClassName)
    {
        this.driverClassName = driverClassName;
    }

    /**
     * Getter for property 'jdbcUrl'.
     *
     * @return Value for property 'jdbcUrl'.
     */
    public String getJdbcUrl()
    {
        return jdbcUrl;
    }

    /**
     * Setter for property 'jdbcUrl'.
     *
     * @param jdbcUrl Value to set for property 'jdbcUrl'.
     */
    public void setJdbcUrl(String jdbcUrl)
    {
        this.jdbcUrl = jdbcUrl;
    }

    /**
     * Getter for property 'dbName'.
     *
     * @return Value for property 'dbName'.
     */
    public String getDbName()
    {
        return dbName;
    }

    /**
     * Setter for property 'dbName'.
     *
     * @param dbName Value to set for property 'dbName'.
     */
    public void setDbName(String dbName)
    {
        this.dbName = dbName;
    }

    /**
     * Getter for property 'pwd'.
     *
     * @return Value for property 'pwd'.
     */
    public String getPwd()
    {
        return pwd;
    }

    /**
     * Setter for property 'pwd'.
     *
     * @param pwd Value to set for property 'pwd'.
     */
    public void setPwd(String pwd)
    {
        this.pwd = pwd;
    }
}
