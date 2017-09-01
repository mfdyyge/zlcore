// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AttributeColumnFactory.java

package com.zl.core.jdbc.columnPropertyEditor;

import com.zl.core.jdbc.db.Column;
import com.zl.core.jdbc.db.DynamicColumn;

// Referenced classes of package com.zl.jdbc.columnPropertyEditor:
//            ColumnWrapperFactory, DynamicAttributeWrapper, AttributeColumnWrapper, ColumnWrapper

public class AttributeColumnFactory extends ColumnWrapperFactory
{

    public static AttributeColumnFactory getAttributeColumnFactory()
    {
        if(_sFactory == null)
            _sFactory = new AttributeColumnFactory();
        return _sFactory;
    }

    public ColumnWrapper createColumnWrapper(Column column)
    {
        if(column instanceof DynamicColumn)
            return new DynamicAttributeWrapper(column);
        else
            return new AttributeColumnWrapper(column);
    }

    private AttributeColumnFactory()
    {
    }

    private static AttributeColumnFactory _sFactory;
}
