// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Column.java

package com.zl.core.jdbc.jdbc;


// Referenced classes of package com.zl.jdbc.db:
//            DataDescriptor, Table

public abstract class Column extends DataDescriptor
{
    //protected static Logger logger = Logger.getLogger();
    public Column()
    {
    }

    public abstract Table getTable();
}
