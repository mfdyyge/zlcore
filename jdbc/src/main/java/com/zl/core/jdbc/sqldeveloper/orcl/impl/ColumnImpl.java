// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ColumnImpl.java

package com.zl.core.jdbc.sqldeveloper.orcl.impl;

import com.zl.core.jdbc.sqldeveloper.orcl.Column;
import com.zl.core.jdbc.sqldeveloper.orcl.Table;

import java.io.Serializable;
import java.util.Locale;

public class ColumnImpl extends Column implements Serializable
{
    //protected static Logger logger = Logger.getLogger();

    private static final long serialVersionUID = 0x3d47f736d135e560L;
    private transient Table _table;
    private String _name;
    private String _displayName;
    private Class _type;
    private boolean _allowsNull;
    private Object _defaultValue;

    public ColumnImpl(String name, String displayName, Class dataType, Table table)
    {
        this(name, displayName, dataType, false, null, table);
    }

    public ColumnImpl(String name, String displayName, Class dataType, boolean allowsNull, Object defaultValue, Table table)
    {
        _type = dataType;
        _name = name;
        _displayName = displayName;
        _allowsNull = allowsNull;
        _defaultValue = defaultValue;
        _table = table;
    }

    public String getDisplayName()
    {
        return getDisplayName(Locale.getDefault());
    }

    public Table getTable()
    {
        return _table;
    }

    public String getName()
    {
        return _name;
    }

    public String getDisplayName(Locale locale)
    {
        return _displayName;
    }

    public Class getDataType()
    {
        return _type;
    }

    public boolean isNullAllowed()
    {
        return _allowsNull;
    }

    public Object getDefaultValue()
    {
        return _defaultValue;
    }

    public Object getMetaData(Object key)
    {
        return null;
    }

    @Override
    public String toString()
    {
        return "ColumnImpl{" +
                "_table=" + _table +
                ", _name='" + _name + '\'' +
                ", _displayName='" + _displayName + '\'' +
                ", _type=" + _type +
                ", _allowsNull=" + _allowsNull +
                ", _defaultValue=" + _defaultValue +
                '}';
    }
}
