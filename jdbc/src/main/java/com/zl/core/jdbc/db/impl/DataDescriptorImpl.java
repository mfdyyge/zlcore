// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DataDescriptorImpl.java

package com.zl.core.jdbc.db.impl;

import java.io.Serializable;
import java.util.Locale;

import com.zl.core.jdbc.db.DataDescriptor;

public class DataDescriptorImpl extends DataDescriptor
    implements Serializable
{

    public DataDescriptorImpl(Class dataType)
    {
        _type = dataType;
        _name = dataType.getName();
        _displayName = _name.substring(_name.lastIndexOf(".") + 1);
        _allowsNull = true;
    }

    public DataDescriptorImpl(Class dataType, String name, String displayName, boolean allowsNull, Object defaultValue)
    {
        _name = name;
        _displayName = displayName;
        _type = dataType;
        _allowsNull = allowsNull;
        _defaultValue = defaultValue;
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

    private static final long serialVersionUID = 0x8f2d22ce0dbaecd9L;
    private String _name;
    private String _displayName;
    private Class _type;
    private boolean _allowsNull;
    private Object _defaultValue;
}
