// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ColumnWrapper.java

package com.zl.core.jdbc.columnPropertyEditor;

import com.zl.core.jdbc.db.Column;

import java.util.Locale;

public class ColumnWrapper
{

    public static ColumnWrapper[] getColumnWrappers(Column columns[])
    {
        if(columns == null)
            return null;
        int count = columns.length;
        ColumnWrapper wrappers[] = new ColumnWrapper[count];
        for(int i = 0; i < count; i++)
            wrappers[i] = new ColumnWrapper(columns[i]);

        return wrappers;
    }

    public static Column[] getColumns(ColumnWrapper wrappers[])
    {
        if(wrappers == null)
            return null;
        int count = wrappers.length;
        Column columns[] = new Column[count];
        for(int i = 0; i < count; i++)
            columns[i] = wrappers[i].getColumn();

        return columns;
    }

    public ColumnWrapper(Column column)
    {
        _column = column;
    }

    public Column getColumn()
    {
        return _column;
    }

    public String getName()
    {
        return getColumn().getName();
    }

    public String getTableName()
    {
        return getColumn().getTable().getName();
    }

    public String getDisplayName(Locale locale)
    {
        return getColumn().getDisplayName(locale);
    }

    private Column _column;
}
