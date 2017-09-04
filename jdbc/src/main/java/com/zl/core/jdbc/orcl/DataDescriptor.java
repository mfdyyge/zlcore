// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DataDescriptor.java

package com.zl.core.jdbc.orcl;

import java.util.Locale;

public abstract class DataDescriptor
{

    public DataDescriptor()
    {
    }

    public abstract String getName();

    public String getDisplayName(Locale locale)
    {
        return getName();
    }

    public abstract Class getDataType();

    public boolean isNullAllowed()
    {
        return false;
    }

    public Object getDefaultValue()
    {
        return null;
    }

    public Object getMetaData(Object key)
    {
        return null;
    }
}
