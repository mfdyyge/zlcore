// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DynamicColumnImpl.java

package com.zl.core.jdbc.db.impl;

import com.zl.core.jdbc.db.DynamicColumn;
import com.zl.core.jdbc.db.Table;

import java.io.Serializable;
import java.util.Locale;

public class DynamicColumnImpl extends DynamicColumn
    implements Serializable
{

    public DynamicColumnImpl(String name, String displayName, Class dataType, Table table)
    {
        this(name, displayName, dataType, false, null, table);
    }

    public DynamicColumnImpl(String name, String displayName, Class dataType, boolean allowsNull, Object defaultValue, Table table)
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

    public void setName(String name)
    {
        Object old = _name;
        _name = name;
        firePropertyChange("name", old, name);
    }

    public String getDisplayName(Locale locale)
    {
        return _displayName;
    }

    public Class getDataType()
    {
        return _type;
    }

    public void setDataType(Class type)
    {
        if(_type != type)
        {
            Object old = _type;
            _type = type;
            firePropertyChange("dataType", old, type);
            Object defaultValue = getDefaultValue();
            if(defaultValue != null)
                setDefaultValue(null);
        }
    }

    public boolean isNullAllowed()
    {
        return _allowsNull;
    }

    public void setNullAllowed(boolean allowsNull)
    {
        Object old = new Boolean(_allowsNull);
        _allowsNull = allowsNull;
        firePropertyChange("nullAllowed", old, new Boolean(_allowsNull));
    }

    public Object getDefaultValue()
    {
        return _defaultValue;
    }

    public void setDefaultValue(Object value)
    {
        Object old = _defaultValue;
        _defaultValue = value;
        firePropertyChange("defaultValue", old, value);
    }

    public Object getMetaData(Object key)
    {
        return null;
    }

    private static final long serialVersionUID = 0x3f4b51cf2d63d5ebL;
    private transient Table _table;
    private String _name;
    private String _displayName;
    private Class _type;
    private boolean _allowsNull;
    private Object _defaultValue;
}
