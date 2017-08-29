package com.zl.jdbc.db;


import com.zl.jdbc.DataSource.DsFactory;
import com.zl.jdbc.DataSource.DsProperties;
import com.zl.jdbc.vo.Column;
import com.zl.jdbc.vo.Table;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Oralce Metadata读取 2013-6-19
 */
public class Oracle
{

    
    /**
     * 获取所有列
     * 
     * @param rs
     * @param t
     * @throws SQLException
     */
    private void getColumns(ResultSet rs, Table t)   throws SQLException
    {
        System.out.println("com.keta.generate.db.Oracle.getColumns()-62 " );
        while (rs.next())
        {
            // 这里没有提供获取当前列是否主键/外键的信息提示
            Column col = new Column();

            //
            System.out.println("打印表的列信息rs.getString(\"COLUMN_NAME\") = " + rs.getString("COLUMN_NAME"));

            col.setName(rs.getString("COLUMN_NAME"));
            col.setType(rs.getString("TYPE_NAME"));
            col.setSize(rs.getInt("COLUMN_SIZE"));
            col.setNullable(rs.getBoolean("NULLABLE"));
            col.setDigits(rs.getInt("DECIMAL_DIGITS"));
            col.setDefaultValue(rs.getString("COLUMN_DEF"));
            col.setComment(rs.getString("REMARKS"));
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
        //Connection conn =getConnection();
        ResultSet rs = null;
        try{
            DatabaseMetaData dbmd = DsFactory.getConnection().getMetaData();
            System.out.println("数据库已知的用户: "+ dbmd.getUserName());
            System.out.println("数据库的系统函数的逗号分隔列表: "+ dbmd.getSystemFunctions());
            System.out.println("数据库的时间和日期函数的逗号分隔列表: "+ dbmd.getTimeDateFunctions());
            System.out.println("数据库的字符串函数的逗号分隔列表: "+ dbmd.getStringFunctions());
            System.out.println("数据库供应商用于 'schema' 的首选术语: "+ dbmd.getSchemaTerm());
            System.out.println("数据库URL: " + dbmd.getURL());
            System.out.println("是否允许只读:" + dbmd.isReadOnly());
            System.out.println("数据库的产品名称:" + dbmd.getDatabaseProductName());
            System.out.println("数据库的版本:" + dbmd.getDatabaseProductVersion());
            System.out.println("驱动程序的名称:" + dbmd.getDriverName());
            System.out.println("驱动程序的版本:" + dbmd.getDriverVersion());

            System.out.println("数据库中使用的表类型");
            rs = dbmd.getTableTypes();
            while (rs.next()) {
                System.out.println(rs.getString("TABLE_TYPE"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        } finally{
            DsFactory.close();
        }
    }

    /**
     * 获取主键
     * 
     * @param rs
     * @return
     * @throws SQLException
     */
    private Column getPk(ResultSet rs)
        throws SQLException
    {
        Column pk = new Column();
        // ResultSetMetaData rsmd = rs.getMetaData();
        // int columnsCount = rsmd.getColumnCount();
        while (rs.next())
        {
            pk.setName(rs.getString("COLUMN_NAME"));
            // System.out.println(rs.getString("COLUMN_NAME"));
        }
        return pk;
    }

    /**
     *  获取Oracle 用户下面的所有表
     * http://blog.sina.com.cn/s/blog_707a9f0601014y1a.html
     * @return
     * @throws SQLException
     */
    public List<Table> getTables()    throws SQLException
    {
        List<Table> tables = new ArrayList<Table>();
        ResultSet rs = null;
        try
        {
            DatabaseMetaData dmd = DsFactory.getConnection().getMetaData();
            String dbname=DsProperties.DbName.toUpperCase();
            rs = dmd.getTables("", dbname, "%", null);
            while (rs.next())
            {
                Table t = new Table();
                System.out.println("rs.getString(\"TABLE_NAME\") = " + rs.getString("TABLE_NAME"));


                t.setTableName(rs.getString("TABLE_NAME"));
                tables.add(t);
            }
        }
        catch (SQLException e)
        {
            throw e;
        }
        finally
        {
            DsFactory.close();
        }
        return tables;
    }

    /**
     *
     * @param tableName
     * @return
     * @throws SQLException
     */
    public Table getTable(String tableName)     throws SQLException
    {
        Table t = new Table(tableName);
        ResultSet rs = null;
        t.setColumns(new ArrayList<Column>());
        try
        {
            //DatabaseMetaData dmd = getConnection().getMetaData();// 获取数据库的MataData信息

            DatabaseMetaData dbmd= DsFactory.getConnection().getMetaData();

            rs = dbmd.getColumns(null, DsProperties.DbName.toUpperCase(), tableName.toUpperCase(), null);

            // 打印信息自己加的
            System.out.println("\n\n\n com.keta.generate.db.Oracle.getTable()-35-tableName = " + tableName.toUpperCase());
            //getDataBaseInfo();

            getColumns(rs, t);

            System.out.println("完成- getColumns(rs, t); " );

            rs = dbmd.getPrimaryKeys(null, null, tableName);

            System.out.println("完成- rs = dbmd.getPrimaryKeys(null, null, tableName);" );

            t.setPk(getPk(rs));
            System.out.println("完成- t.setPk(getPk(rs));" );
        }
        catch (SQLException e)
        {
            throw e;
        }
        finally
        {
            DsFactory.close();
        }
        return t;
    }
    
}
