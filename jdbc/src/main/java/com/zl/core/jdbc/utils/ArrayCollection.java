package com.zl.core.jdbc.utils;

import java.io.Serializable;
import java.util.Enumeration;

// Referenced classes of package oracle.bali.dbUI.util:
//            ArrayEnumeration, Collection

public class ArrayCollection   implements Collection, Serializable
{

    public ArrayCollection(Object array[])
    {
        if(array == null)
        {
            throw new IllegalArgumentException("array can't be null");
        } else
        {
            _array = new Object[array.length];
            System.arraycopy(((Object) (array)), 0, ((Object) (_array)), 0, array.length);
            return;
        }
    }

    public Enumeration getEnumeration()
    {
        return new ArrayEnumeration(_array);
    }

    public String toString()
    {
        Enumeration e = getEnumeration();
        String s;
        for(s = ""; e.hasMoreElements(); s = (new StringBuilder()).append(s).append(e.nextElement().toString()).append(" ").toString());
        return s;
    }

    private static final long serialVersionUID = 0xb3b3c57085503d69L;
    private Object _array[];
}
