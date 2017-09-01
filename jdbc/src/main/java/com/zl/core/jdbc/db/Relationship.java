// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Relationship.java

package com.zl.core.jdbc.db;

import java.util.Locale;

// Referenced classes of package com.zl.jdbc.db:
//            Column

public abstract class Relationship
{

    public Relationship()
    {
    }

    public abstract int getColumnCount();

    public abstract Column getColumn(int i);

    public abstract Column getReferencedColumn(int i);

    public abstract int getRelationshipType();

    public abstract String getName();

    public abstract String getDisplayName(Locale locale);

    public static final int TYPE_EQUAL_TO = 0;
    public static final int TYPE_NOT_EQUAL_TO = 1;
    public static final int TYPE_GREATER_THAN = 2;
    public static final int TYPE_LESS_THAN = 3;
    public static final int TYPE_LESS_THAN_OR_EQUAL_TO = 4;
    public static final int TYPE_GREATER_THAN_OR_EQUAL_TO = 5;
}
