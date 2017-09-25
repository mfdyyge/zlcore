package com.zl.core.jdbc.sqldeveloper;

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)
// Source File Name:   JdbcDatabase.java


import com.zl.core.jdbc.sqldeveloper.properties.Database;
import com.zl.core.jdbc.sqldeveloper.properties.Schema;


import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Vector;


/**
 * 实现Oracle 单库多用户操作
 * @author  刚背猪 474752515@qq.com
 *
 */
public class JdbcDatabase extends Database
{
    protected static Logger logger = Logger.getLogger(JdbcDatabase.class);

    private static final int _SCHEMA_NAME = 1;
    private Connection _connection;
    private String _dbUrl;
    private Schema _schemas[];
    private String _schemaNames[];



    public JdbcDatabase(Connection connection)
    {
        _connection = connection;
        try
        {
            _dbUrl = _connection.getMetaData().getURL();
            logger.info("_connection.getMetaData().getURL = " + _dbUrl);
        }
        catch(SQLException e)
        {
            logger.error((new StringBuilder()).append("出错： ").append(e).toString());
        }
    }

    public String getUrl()
    {
        return _dbUrl;
    }

    public String getDisplayName(Locale locale)
    {
        return getUrl();
    }

    public int getSchemaCount()
    {
        if(_schemaNames == null)
            _schemaNames = createSchemaNames();
        return _schemaNames != null ? _schemaNames.length : 0;
    }

    public Schema getSchema(int index)
    {
        if(_schemas == null)
            _schemas = new Schema[getSchemaCount()];
        if(_schemas[index] == null)
            _schemas[index] = createSchema(index);
        return _schemas[index];
    }

    /**
     * 返回数据库用户名
     * @param index
     * @return schemaName
     */
    public String getSchemaName(int index)
    {
        if(_schemaNames == null)
            _schemaNames = createSchemaNames();

        String schemaName=_schemaNames != null ? _schemaNames[index] : null;
        System.out.println("数据库用户> schemaName = " + schemaName);
        return schemaName;
    }


    /**
     * 返回 数据库用户名 数组
     * @return schemaName
     */
    public String[] getSchemaNames()
    {
        if(_schemaNames == null)
            _schemaNames = createSchemaNames();

        return _schemaNames;
    }

    public String getSchemaDisplayName(int index, Locale locale)
    {
        return getSchemaName(index);
    }

    public Connection getConnection()
    {
        return _connection;
    }

    public String toString()
    {
        return getUrl();
    }

    protected Schema createSchema(int index)
    {
        return new JdbcSchema(_connection, this, getSchemaName(index));
    }

    protected String[] createSchemaNames()
    {
        String schemaNames[] = null;
        try
        {
            ResultSet data = _connection.getMetaData().getSchemas();
            Vector temp = new Vector();
            String schema;
            for(; data.next(); temp.addElement(schema))
                schema = data.getString(1);

            schemaNames = new String[temp.size()];
            if(temp.size() != 0)
                temp.copyInto(schemaNames);
            data.close();
        }
        catch(SQLException e)
        {
            System.err.println((new StringBuilder()).append("A SQLException occured ").append(e).toString());
        }
        return schemaNames;
    }


}
