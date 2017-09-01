// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ColumnWrapperFactory.java

package com.zl.core.jdbc.columnPropertyEditor;

import com.zl.core.jdbc.db.Column;

// Referenced classes of package com.zl.jdbc.columnPropertyEditor:
//            ColumnWrapper

public class ColumnWrapperFactory
{

    public static ColumnWrapperFactory getColumnWrapperFactory()
    {
        if(_sFactory == null)
            _sFactory = new ColumnWrapperFactory();
        return _sFactory;
    }

    public ColumnWrapper createColumnWrapper(Column column)
    {
        return new ColumnWrapper(column);
    }

    protected ColumnWrapperFactory()
    {
    }

    private static ColumnWrapperFactory _sFactory;
}
