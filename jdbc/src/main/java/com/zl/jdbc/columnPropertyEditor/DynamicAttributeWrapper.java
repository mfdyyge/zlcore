// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DynamicAttributeWrapper.java

package com.zl.jdbc.columnPropertyEditor;

import com.zl.jdbc.db.Column;
import com.zl.jdbc.db.DynamicColumn;

// Referenced classes of package com.zl.jdbc.columnPropertyEditor:
//            AttributeColumnWrapper

public class DynamicAttributeWrapper extends AttributeColumnWrapper
{

    public DynamicAttributeWrapper(Column column)
    {
        super(column);
        if(!(column instanceof DynamicColumn))
            throw new IllegalArgumentException("column must be a DynamicColumn");
        else
            return;
    }

    public void setDefaultValue(Object defaultValue)
    {
        _getColumn().setDefaultValue(defaultValue);
    }

    public void setDataType(Class dataType)
    {
        _getColumn().setDataType(dataType);
    }

    public void setNullAllowed(boolean allowNull)
    {
        _getColumn().setNullAllowed(allowNull);
    }

    public void setName(String name)
    {
        _getColumn().setName(name);
    }

    private DynamicColumn _getColumn()
    {
        return (DynamicColumn)getColumn();
    }
}
