// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Database.java

package com.zl.core.jdbc.sqldeveloper.properties;

import java.util.Locale;

// Referenced classes of package com.zl.orcl.db:
//            Schema

public abstract class Database
{
    //protected static Logger logger = Logger.getLogger();

    public Database()
    {
    }

    public abstract String getUrl();

    public abstract String getDisplayName(Locale locale);

    public abstract int getSchemaCount();

    public abstract Schema getSchema(int i);

    public String getSchemaName(int index)
    {
        return getSchema(index).getName();
    }
    public abstract String[] getSchemaNames();

    public String getSchemaDisplayName(int index, Locale locale)
    {
        return getSchema(index).getDisplayName(locale);
    }
}
