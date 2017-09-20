package com.zl.core.jdbc.generator;


import com.zl.core.jdbc.DataSource.DsFactory;
import org.apache.log4j.Logger;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 高度耦合封装
 * Oralce Metadata读取 2017-6-19
 */
public class Oracle
{
    //protected static Logger logger = Logger.getLogger();
    protected static Logger logger = Logger.getLogger(Oracle.class);

    private static DsFactory dsFactory;

    /**
     * 指定[配置文件]
     * @param db_properties_filename
     */
    public Oracle(String db_properties_filename)
    {
        dsFactory=new DsFactory(db_properties_filename);
    }

    /**
     * 默认[配置文件]：db_properties_filename="db" 〈br/〉
     * 路径："conf/db/db.properties"
     */
    public Oracle()
    {
        dsFactory=new DsFactory();
    }


    /**
     * 获取所有[表字段]对应的[字段属性]
     * 【COLUMN_NAME  <br/>
     * TYPE_NAME     <br/>
     * COLUMN_SIZE     <br/>
     * NULLABLE     <br/>
     * DECIMAL_DIGITS     <br/>
     * COLUMN_DEF     <br/>
     * REMARKS      <br/>
     * @param rs
     * @param t
     * @throws SQLException
     */
    private void getColumns(ResultSet rs, Table t)   throws SQLException
    {
        while (rs.next())
        {
            // 这里没有提供获取当前列是否主键/外键的信息提示
            Column col = new Column();

            col.setName(rs.getString("COLUMN_NAME"));
            col.setType(rs.getString("TYPE_NAME"));

            col.setSize(rs.getInt("COLUMN_SIZE"));
            col.setNullable(rs.getBoolean("NULLABLE"));
            col.setDigits(rs.getInt("DECIMAL_DIGITS"));
            col.setDefaultValue(rs.getString("COLUMN_DEF"));
            col.setComment(rs.getString("REMARKS"));



            ConvertHandler.columnHandler(col);




            logger.info(col.toString());
            t.getColumns().add(col);
        }
    }

    /**
     * @Description: 获取数据库相关信息
     * @author: chenzw
     * @CreateTime: 2014-1-27 下午5:09:12
     * @throws
     */
    public static void getDataBaseInfo()
    {
        ResultSet rs = null;
        try{

            DatabaseMetaData dbmd = dsFactory.getConnection().getMetaData();
           logger.info("数据库已知的用户: "+ dbmd.getUserName());
           logger.info("数据库的系统函数的逗号分隔列表: "+ dbmd.getSystemFunctions());
           logger.info("数据库的时间和日期函数的逗号分隔列表: "+ dbmd.getTimeDateFunctions());
           logger.info("数据库的字符串函数的逗号分隔列表: "+ dbmd.getStringFunctions());
           logger.info("数据库供应商用于 'schema' 的首选术语: "+ dbmd.getSchemaTerm());
           logger.info("数据库URL: " + dbmd.getURL());
           logger.info("是否允许只读:" + dbmd.isReadOnly());
           logger.info("数据库的产品名称:" + dbmd.getDatabaseProductName());
           logger.info("数据库的版本:" + dbmd.getDatabaseProductVersion());
           logger.info("驱动程序的名称:" + dbmd.getDriverName());
           logger.info("驱动程序的版本:" + dbmd.getDriverVersion());

           logger.info("数据库中使用的表类型");
            rs = dbmd.getTableTypes();
            while (rs.next())
            {
               logger.info(rs.getString("TABLE_TYPE"));
            }
        }catch (SQLException e){
            logger.info(e.getStackTrace());
        } finally{
            dsFactory.close();
        }
    }

    /**
     * 获取主键
     * 
     * @param rs
     * @return
     * @throws SQLException
     */
    private Column getPk(ResultSet rs)       throws SQLException
    {
        Column pk = new Column();
        // ResultSetMetaData rsmd = rs.getMetaData();
        // int columnsCount = rsmd.getColumnCount();
        while (rs.next())
        {
            pk.setName(rs.getString("COLUMN_NAME"));
           // logger.info(rs.getString("COLUMN_NAME"));
        }
        return pk;
    }

    /**
     *  获取[DB-用户]下面的[所有表]
     * http://blog.sina.com.cn/s/blog_707a9f0601014y1a.html
     * @return
     * @throws SQLException
     */
    public List<Table> getTables()
    {
        List<Table> tables = new ArrayList<Table>();
        ResultSet rs = null;
        try
        {
            DatabaseMetaData dbmd = dsFactory.getConnection().getMetaData();
            String dbname=dsFactory.getConnection().getMetaData().getUserName().toUpperCase();

            rs = dbmd.getTables("", dbname, "%", null);
            while (rs.next())
            {
                Table t = new Table();
                logger.info(new StringBuffer("rs.getString(TABLE_NAME) = ").append(rs.getString("TABLE_NAME")));

                t.setTableName(rs.getString("TABLE_NAME"));
                tables.add(t);
            }
        }
        catch (SQLException e)
        {
            logger.error(e.getErrorCode());

            logger.error(e.getMessage());
            logger.error(e.getSQLState());
            logger.error(e.getLocalizedMessage());
            logger.error(e.getStackTrace());
        }
        finally
        {
            dsFactory.close();
        }
        return tables;
    }

    /**
     * 返回一个表对象【com.zl.core.orcl.vo.properties.Table】
     * @param tableName
     * @return 返回一个表对象【com.zl.core.orcl.vo.properties.Table】
     */
    public Table getTable(String tableName)
    {
        Table table = new Table(tableName);
        ResultSet rs = null;
        table.setColumns(new ArrayList<Column>());
        try
        {
            //DatabaseMetaData dbmd = getConnection().getMetaData();// 获取数据库的MataData信息

            DatabaseMetaData dbmd = dsFactory.getConnection().getMetaData();
            String dbname=dsFactory.getConnection().getMetaData().getUserName().toUpperCase();
            rs = dbmd.getColumns(null, dbname, tableName.toUpperCase(), null);

//设置Table 字段
            getColumns(rs, table);
            rs = dbmd.getPrimaryKeys(null, null, tableName);
            table.setPk(getPk(rs));

        } catch (SQLException e) {
            System.out.println("e = " + e);
           // logger.error(e.getStackTrace());
        }
        finally {   dsFactory.close();        }
        return table;
    }

    /**
     * 查询指定【用户，表名】 返回一个表对象【com.zl.core.orcl.vo.properties.Table】
     * @param DB_Name    【用户】
     * @param tableName 【表名】
     * @return 返回一个表对象【com.zl.core.orcl.vo.properties.Table】
     */
    public Table getTable(String DB_Name, String tableName)
    {
        Table t = new Table(tableName);
        ResultSet rs = null;
        t.setColumns(new ArrayList<Column>());
        try
        {
            //DatabaseMetaData dbmd = getConnection().getMetaData();// 获取数据库的MataData信息

            DatabaseMetaData dbmd = dsFactory.getConnection().getMetaData();
            //String dbname=dsFactory.getConnection().getMetaData().getUserName().toUpperCase();
            //Oracle 用户跟表名  需要用大写字母
            rs = dbmd.getColumns(null, DB_Name.toUpperCase(), tableName.toUpperCase(), null);


            getColumns(rs, t);
            rs = dbmd.getPrimaryKeys(null, null, tableName);
            t.setPk(getPk(rs));

        }
        catch (SQLException e)
        {
            logger.error(e.getErrorCode());

            logger.error(e.getMessage());
            logger.error(e.getSQLState());
            logger.error(e.getLocalizedMessage());
            logger.error(e.getStackTrace());
            //throw e;
        }
        finally
        {
            dsFactory.close();
        }
        return t;
    }

}
