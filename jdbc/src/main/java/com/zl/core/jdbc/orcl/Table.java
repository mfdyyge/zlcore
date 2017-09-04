// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Table.java

package com.zl.core.jdbc.orcl;

import java.util.Locale;

// Referenced classes of package com.zl.orcl.db:
//            Column, Schema, Database, Relationship

public abstract class Table
{
    //protected static Logger logger = Logger.getLogger();
    public Table()
    {
    }

    public abstract String getName();

    public abstract String getDisplayName(Locale locale);

    public abstract Schema getSchema();

    public abstract int getColumnCount();

    public abstract Column getColumn(int i);

    public String getColumnName(int index)
    {
        return getColumn(index).getName();
    }

    public String getColumnDisplayName(int index, Locale locale)
    {
        return getColumn(index).getDisplayName(locale);
    }

    public abstract int getPrimaryKeyCount();

    public abstract Column getPrimaryKey(int i);

    public abstract int getUniqueKeyCount();

    public abstract Column getUniqueKey(int i);

    public abstract int getForeignKeyCount();

    public abstract Relationship getForeignKey(int i);

    public int getExportedKeyCount()
    {
        return 0;
    }

    public Relationship getExportedKey(int exportedKeyIndex)
    {
        return null;
    }

    public boolean equals(Object o)
    {
        if(o instanceof Table)
        {
            if(o == this)
                return true;
            Table t = (Table)o;
            if(t.getName().equals(getName()) && t.getSchema().getName().equals(getSchema().getName()) && t.getSchema().getDatabase().getUrl().equals(getSchema().getDatabase().getUrl()))
                return true;
        }
        return false;
    }
}
