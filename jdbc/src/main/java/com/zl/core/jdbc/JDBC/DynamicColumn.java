// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DynamicColumn.java

package com.zl.core.jdbc.jdbc;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

// Referenced classes of package com.zl.jdbc.db:
//            Column

public abstract class DynamicColumn extends Column
{

    public DynamicColumn()
    {
    }

    public abstract void setName(String s);

    public abstract void setDataType(Class class1);

    public abstract void setNullAllowed(boolean flag);

    public abstract void setDefaultValue(Object obj);

    public void addPropertyChangeListener(PropertyChangeListener listener)
    {
        if(_support == null)
            _support = new PropertyChangeSupport(this);
        _support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener)
    {
        if(_support != null)
            _support.removePropertyChangeListener(listener);
    }

    protected void firePropertyChange(String propertyName, Object oldValue, Object newValue)
    {
        if(_support != null)
            _support.firePropertyChange(propertyName, oldValue, newValue);
    }

    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DATA_TYPE = "dataType";
    public static final String PROPERTY_NULL_ALLOWED = "nullAllowed";
    public static final String PROPERTY_DEFAULT_VALUE = "defaultValue";
    private PropertyChangeSupport _support;
}
