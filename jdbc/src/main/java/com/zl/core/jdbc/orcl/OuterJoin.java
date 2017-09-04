// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   OuterJoin.java

package com.zl.core.jdbc.orcl;


// Referenced classes of package com.zl.orcl.db:
//            Table

public class OuterJoin
{
    //protected static Logger logger = Logger.getLogger();

    private final Table _source;        //源表
    private final Table _destination;   //目标表

    public OuterJoin(Table sourceTable, Table destinationTable)
    {
        if(sourceTable == null || destinationTable == null || sourceTable == destinationTable)
        {
            throw new IllegalArgumentException();
        } else
        {
            _source = sourceTable;
            _destination = destinationTable;
            return;
        }
    }

    public Table getSource()
    {
        return _source;
    }

    public Table getDestination()
    {
        return _destination;
    }


}
