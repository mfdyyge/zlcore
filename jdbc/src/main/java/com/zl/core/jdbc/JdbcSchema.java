package com.zl.core.jdbc;


import com.zl.core.jdbc.sqldeveloper.orcl.Schema;
import com.zl.core.jdbc.sqldeveloper.orcl.Table;
import com.zl.core.jdbc.sqldeveloper.orcl.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Vector;

// Referenced classes of package com.zl.orcl.util.orcl:
//            JdbcTable

public class JdbcSchema extends Schema
{
    //protected static Logger logger = Logger.getLogger();

    private static final int _TABLE_NAME = 3;
    private Connection  _connection;
    private String      _schemaName;
    private Database    _database;
    private Table _tables[];
    private String      _tableNames[];

    /**
     *
     * @param connection
     * @param database
     * @param schemaName
     */
    public JdbcSchema(Connection connection, Database database, String schemaName)
    {
        _schemaName = schemaName;
        _connection = connection;
        _database = database;
    }

    public Database getDatabase()
    {
        return _database;
    }

    public String getName()
    {
        return _schemaName;
    }

    public String getDisplayName(Locale locale)
    {
        return getName();
    }

    public int getTableCount()
    {
        if(_tableNames == null)
            _tableNames = createTableNames();
        return _tableNames != null ? _tableNames.length : 0;
    }

    public Table getTable(int index)
    {
        if(_tables == null)
            _tables = new Table[getTableCount()];
        if(_tables[index] == null)
            _tables[index] = createTable(index);
        return _tables[index];
    }

    public String getTableName(int index)
    {
        if(_tableNames == null)
            _tableNames = createTableNames();
        return _tableNames != null ? _tableNames[index] : null;
    }

    public String getTableDisplayName(int index, Locale locale)
    {
        return getTableName(index);
    }

    public Connection getConnection()
    {
        return _connection;
    }

    public String toString()
    {
        return getName();
    }

    protected Table createTable(int index)
    {
        String name = getTableName(index);
        return new JdbcTable(_connection, this, name);
    }

    protected String[] createTableNames()
    {
        String tableNames[] = null;
        try
        {
            ResultSet data = _connection.getMetaData().getTables(null, getName(), null, null);
            Vector temp = new Vector();
            String table;
            for(; data.next(); temp.addElement(table))
                table = data.getString(3);

            tableNames = new String[temp.size()];
            if(temp.size() != 0)
                temp.copyInto(tableNames);
            data.close();
        }
        catch(SQLException e)
        {
            System.err.println((new StringBuilder()).append("A SQLException occured ").append(e).toString());
        }
        return tableNames;
    }


}
