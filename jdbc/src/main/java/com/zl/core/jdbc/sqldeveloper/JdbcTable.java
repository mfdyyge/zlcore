//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.zl.core.jdbc.sqldeveloper;

import com.zl.core.jdbc.sqldeveloper.properties.*;
import com.zl.core.jdbc.sqldeveloper.properties.impl.RelationshipImpl;
import com.zl.core.jdbc.sqldeveloper.properties.impl.ColumnImpl;
import org.apache.log4j.Logger;

import java.beans.PropertyChangeListener;
import java.sql.*;
import java.util.Locale;
import java.util.Vector;

public class JdbcTable extends Table implements DataDescriptorProvider
{
    //protected static Logger logger = Logger.getLogger();
    protected static Logger logger = Logger.getLogger(JdbcTable.class);

    private static final int _COLUMN_NAME = 4;
    private static final int _DATA_TYPE = 5;
    private static final int _COLUMN_SIZE = 7;
    private static final int _DECIMAL_DIGITS = 9;
    private static final int _NULLABLE = 11;
    private static final int _ORDINAL = 17;
    private static final int _DEFAULT = 13;
    private static final int _PK_COLUMN_NAME = 4;
    private static final int _FK_COLUMN_NAME = 4;
    private static final int _FK_TABLE_NAME = 3;
    private static final int _FK_FK_COLUMN_NAME = 8;
    private static final int _FK_NAME = 12;
    private static final int _EK_COLUMN_NAME = 4;
    private static final int _EK_TABLE_NAME = 7;
    private static final int _EK_FK_COLUMN_NAME = 8;
    private static final int _EK_NAME = 12;

    private Connection          _connection;
    private String              _tableName;
    private Schema _schema;
    private Column[]            _columns;
    private Column[]            _primaryKey;
    private Relationship[]      _foreignKey;
    private Relationship[]      _exportedKey;
    private final Object        _RESULTS_OBJECT = new Object();

    public JdbcTable(Connection connection, Schema schema, String tableName) {
        this._tableName = tableName.toUpperCase();
        this._connection = connection;
        this._schema = schema;
    }

    public Schema getSchema() {
        return this._schema;
    }

    public String getName() {
        return this._tableName;
    }

    public String getDisplayName(Locale locale) {
        return this.getName();
    }

    public int getColumnCount() {
        Column[] columns = this._getColumns();
        return columns == null?0:columns.length;
    }

    public Column getColumn(int index) {
        Column[] columns = this._getColumns();
        return columns == null?null:columns[index];
    }

    public Column getColumn(String columnName) {
        Column[] columns = this._getColumns();

        for(int i = 0; i < this.getColumnCount(); ++i) {
            if(columns[i].getName().equals(columnName)) {
                return columns[i];
            }
        }

        return null;
    }

    public String getColumnDisplayName(int index, Locale locale) {
        return this.getColumnName(index);
    }

    public String getColumnName(int index) {
        Column[] columns = this._getColumns();
        return columns == null?null:columns[index].getName();
    }


    public String[] getColumnNames()
    {
        String[] ColumnNames=null;

        try {
            ResultSet rs = this._connection.getMetaData().getColumns((String)null, this._getSchemaName(), this.getName(), (String)null);
            Vector temp = new Vector();
            boolean dataType = false;
            Object var13 = this._RESULTS_OBJECT;
            synchronized(this._RESULTS_OBJECT)
            {
                while(rs.next())
                {
                    String name = rs.getString(4);
                    temp.addElement(name);
                }
            }
            int columnNames_size=temp.size();
            ColumnNames = new String[columnNames_size];
            System.out.println("columnNames_size = " + columnNames_size);

            if(temp.size() != 0)
            {
                temp.copyInto(ColumnNames);
                // System.out.println(">>>> (columns)= " + Arrays.asList(columns));
            }

            rs.close();
        } catch (SQLException var16) {
            System.err.println("A SQLException occured " + var16);
        }

        return ColumnNames;
    }




    public synchronized Column[] getColumns() {
        if(this._columns == null) {
            this._columns = this.createColumns();
        }
        //System.out.println(">>>> (columns)= " + Arrays.asList(_columns));
        return this._columns;
    }

    public int getDescriptorCount() {
        return this.getColumnCount();
    }

    public DataDescriptor getDescriptor(int index) {
        return this.getColumn(index);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
    }

    public int getPrimaryKeyCount() {
        if(this._primaryKey == null) {
            this._primaryKey = this._createPrimaryKey();
        }

        return this._primaryKey == null?0:this._primaryKey.length;
    }

    public Column getPrimaryKey(int index) {
        if(this._primaryKey == null) {
            this._primaryKey = this._createPrimaryKey();
        }

        return this._primaryKey == null?null:this._primaryKey[index];
    }

    public int getForeignKeyCount() {
        if(this._foreignKey == null) {
            this._foreignKey = this.createForeignKey();
        }

        return this._foreignKey == null?0:this._foreignKey.length;
    }

    public Relationship getForeignKey(int index) {
        if(this._foreignKey == null) {
            this._foreignKey = this.createForeignKey();
        }

        return this._foreignKey == null?null:this._foreignKey[index];
    }

    public int getUniqueKeyCount() {
        return 0;
    }

    public Column getUniqueKey(int index) {
        return null;
    }

    public int getExportedKeyCount() {
        if(this._exportedKey == null) {
            this._exportedKey = this.createExportedKey();
        }

        return this._exportedKey == null?0:this._exportedKey.length;
    }

    public Relationship getExportedKey(int index) {
        if(this._exportedKey == null) {
            this._exportedKey = this.createExportedKey();
        }

        return this._exportedKey == null?null:this._exportedKey[index];
    }

    public Connection getConnection() {
        return this._connection;
    }

    public String toString() {
        return this.getName();
    }

    protected Column[] createColumns()
    {
        Column[] columns = null;

        try {
            ResultSet rs = this._connection.getMetaData().getColumns((String)null, this._getSchemaName(), this.getName(), (String)null);
            Vector temp = new Vector();
            boolean dataType = false;
            Object var13 = this._RESULTS_OBJECT;
            synchronized(this._RESULTS_OBJECT)
            {
                while(rs.next())
                {
                    String name = rs.getString(4);
                    int dataType1 = rs.getInt(5);
                    int decimalDigits = rs.getInt(9);
                    Class type = this._getClass(dataType1, decimalDigits);

                    String DATA_TYPE  = rs.getString("DATA_TYPE");//字段数据类型(对应java.sql.Types中的常量)
                    String TYPE_NAME = rs.getString("TYPE_NAME");//字段类型名称(例如：VACHAR2)


                    System.out.println("name: "+name+" | DATA_TYPE="+DATA_TYPE+" |TYPE_NAME = "+TYPE_NAME+" | 字段类型 = " + type);
                    int nullable = rs.getInt(11);
                    boolean allowsNull = nullable == 1;
                    String defaultValue = rs.getString(13);

                    ColumnImpl column = new ColumnImpl(name, name, type, allowsNull, defaultValue, this);

                    temp.addElement(column);
                }
            }

            columns = new Column[temp.size()];
            System.out.println("column.size() = " + temp.size());

            if(temp.size() != 0)
            {
                temp.copyInto(columns);
               // System.out.println(">>>> (columns)= " + Arrays.asList(columns));
            }

            rs.close();
        } catch (SQLException var16) {
            System.err.println("A SQLException occured " + var16);
        }

        return columns;
    }

    Relationship[] createForeignKey() {
        Relationship[] key = null;

        try {
            int e = 0;
            DatabaseMetaData data = this._connection.getMetaData();
            Relationship[] temp = new Relationship[data.getMaxColumnsInTable()];
            ResultSet results = data.getImportedKeys((String)null, this._getSchemaName(), this.getName());
            Object var13 = this._RESULTS_OBJECT;
            synchronized(this._RESULTS_OBJECT) {
                while(results.next()) {
                    String refColumnName = results.getString(4);
                    String refTableName = results.getString(3);
                    String childColumnName = results.getString(8);
                    String keyName = results.getString(12);
                    JdbcTable refTable = new JdbcTable(this._connection, this.getSchema(), refTableName);
                    Column refColumn = refTable.getColumn(refColumnName);
                    Column childColumn = this.getColumn(childColumnName);
                    temp[e] = new RelationshipImpl(childColumn, refColumn, keyName);
                    ++e;
                }
            }

            key = new Relationship[e];
            System.arraycopy(temp, 0, key, 0, e);
            results.close();
        } catch (SQLException var16) {
            System.err.println("A SQLException has occured: " + var16);
        }

        return key;
    }

    Relationship[] createExportedKey() {
        Relationship[] key = null;

        try {
            int e = 0;
            DatabaseMetaData data = this._connection.getMetaData();
            Relationship[] temp = new Relationship[data.getMaxColumnsInTable()];
            ResultSet results = data.getExportedKeys((String)null, this._getSchemaName(), this.getName());
            Object var13 = this._RESULTS_OBJECT;
            synchronized(this._RESULTS_OBJECT) {
                while(results.next()) {
                    String refColumnName = results.getString(4);
                    String childColumnName = results.getString(8);
                    String childTableName = results.getString(7);
                    String keyName = results.getString(12);
                    JdbcTable childTable = new JdbcTable(this._connection, this.getSchema(), childTableName);
                    Column refColumn = this.getColumn(refColumnName);
                    Column childColumn = childTable.getColumn(childColumnName);
                    temp[e] = new RelationshipImpl(childColumn, refColumn, keyName);
                    ++e;
                }
            }

            key = new Relationship[e];
            System.arraycopy(temp, 0, key, 0, e);
            results.close();
        } catch (SQLException var16) {
            System.err.println("A SQLException has occured: " + var16);
        }

        return key;
    }

    private Column[] _getColumns() {
        if(this._columns == null) {
            this._columns = this.createColumns();
        }

        return this._columns;
    }

    private Column[] _createPrimaryKey() {
        Column[] key = null;

        try {
            int count = 0;
            DatabaseMetaData data = this._connection.getMetaData();
            Column[] temp = new Column[data.getMaxColumnsInTable()];
            ResultSet results = data.getPrimaryKeys((String)null, this._getSchemaName(), this.getName());
            Object var7 = this._RESULTS_OBJECT;
            synchronized(this._RESULTS_OBJECT) {
                while(results.next()) {
                    String e = results.getString(4);
                    temp[count] = this.getColumn(e);
                    ++count;
                }
            }

            key = new Column[count];
            System.arraycopy(temp, 0, key, 0, count);
            results.close();
        } catch (SQLException var10) {
            System.err.println("A SQLException has occured: " + var10);
        }

        return key;
    }

    private Class _getClass(int sqlType, int digits) {
        Class c;
        switch(sqlType) {
            case -7:
                c = Boolean.class;
                break;
            case -6:
            case -5:
            case 4:
            case 5:
                c = Long.class;
                break;
            case -4:
            case -3:
            case -2:
                c = Object.class;
                break;
            case -1:
            case 12:
            case 1111://NVARCHAR2
                c = String.class;
                break;
            case 0:
            default:
                c = null;
                break;
            case 1:
                c = Character.class;
                break;
            case 2:
            case 3:
            case 7:
            case 8:
                if(digits == 0) {
                    c = Integer.class;
                } else {
                    c = Double.class;
                }
                break;
            case 6:
                c = Float.class;
                break;
            case 91:
                c = Date.class;
                break;
            case 92:
                c = Time.class;
                break;
            case 93:
            case -102:
                c = Timestamp.class;
                break;
            case 2005://CLOB
                c= Clob.class;
        }

        return c;
    }

    private String _getSchemaName() {
        Schema s = this.getSchema();
        return s == null?null:s.getName();
    }
}
