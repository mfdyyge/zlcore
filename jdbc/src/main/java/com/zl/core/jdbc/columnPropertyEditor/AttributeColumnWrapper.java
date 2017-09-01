// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AttributeColumnWrapper.java

package com.zl.core.jdbc.columnPropertyEditor;

import com.zl.core.jdbc.db.Column;

// Referenced classes of package com.zl.jdbc.columnPropertyEditor:
//            ColumnWrapper

public class AttributeColumnWrapper extends ColumnWrapper
{

    public AttributeColumnWrapper(Column column)
    {
        super(column);
    }

    public Object getDefaultValue()
    {
        return getColumn().getDefaultValue();
    }

    public Class getDataType()
    {
        return getColumn().getDataType();
    }

    public boolean isNullAllowed()
    {
        return getColumn().isNullAllowed();
    }
}
