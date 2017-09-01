// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ArrayEnumeration.java

package com.zl.core.jdbc.utils;

import java.util.Enumeration;

class ArrayEnumeration
    implements Enumeration
{

    public ArrayEnumeration(Object array[])
    {
        _index = 0;
        if(array == null)
        {
            throw new IllegalArgumentException("array can't be null");
        } else
        {
            _array = new Object[array.length];
            System.arraycopy(((Object) (array)), 0, ((Object) (_array)), 0, array.length);
            _index = 0;
            return;
        }
    }

    public boolean hasMoreElements()
    {
        return _index < _array.length;
    }

    public Object nextElement()
    {
        if(_index >= _array.length)
        {
            return null;
        } else
        {
            _index++;
            return _array[_index - 1];
        }
    }

    public String toString()
    {
        int old = _index;
        _index = 0;
        String s;
        for(s = ""; hasMoreElements(); s = (new StringBuilder()).append(s).append(" ").append(nextElement()).toString());
        _index = old;
        return s;
    }

    private int _index;
    private Object _array[];
}
