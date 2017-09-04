// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   RelationshipImpl.java

package com.zl.core.jdbc.orcl.impl;

import java.util.Locale;
import com.zl.core.jdbc.orcl.Column;
import com.zl.core.jdbc.orcl.Relationship;

public final class RelationshipImpl extends Relationship
{
    //protected static Logger logger = Logger.getLogger();
    public RelationshipImpl(Column child, Column referenced, String name)
    {
        this(child, referenced, name, 0);
    }

    public RelationshipImpl(Column child, Column referenced, String name, int type)
    {
        if(type < 0 || type > 5)
        {
            throw new IllegalArgumentException("type is incorrect");
        } else
        {
            _children = new Column[1];
            _children[0] = child;
            _referenced = new Column[1];
            _referenced[0] = referenced;
            _name = name;
            _type = type;
            return;
        }
    }

    public RelationshipImpl(Column children[], Column referenced[], String name)
    {
        this(children, referenced, name, 0);
    }

    public RelationshipImpl(Column children[], Column referenced[], String name, int type)
    {
        if(children == null || children.length == 0)
            throw new IllegalArgumentException("children is empty");
        if(referenced == null || referenced.length == 0)
            throw new IllegalArgumentException("referenced is empty");
        if(type < 0 || type > 5)
        {
            throw new IllegalArgumentException("type is incorrect");
        } else
        {
            _children = new Column[children.length];
            System.arraycopy(children, 0, _children, 0, children.length);
            _referenced = new Column[referenced.length];
            System.arraycopy(referenced, 0, _referenced, 0, referenced.length);
            _name = name;
            _type = type;
            return;
        }
    }

    public int getColumnCount()
    {
        return _children.length;
    }

    public Column getColumn(int index)
    {
        return _children[index];
    }

    public Column getReferencedColumn(int index)
    {
        return _referenced[index];
    }

    public String getName()
    {
        return _name;
    }

    public int getRelationshipType()
    {
        return _type;
    }

    public String getDisplayName(Locale locale)
    {
        return getName();
    }

    public String toString()
    {
        return (new StringBuilder()).append("Relationship: ").append(getName()).toString();
    }

    private Column _children[];
    private Column _referenced[];
    private String _name;
    private int _type;
}
