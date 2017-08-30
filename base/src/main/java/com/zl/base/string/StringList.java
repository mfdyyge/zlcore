// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.zl.base.string;


// Referenced classes of package org.bouncycastle.util:
//            Iterable

import java.lang.*;

public interface StringList    extends java.lang.Iterable
{

    public abstract boolean add(String s);

    public abstract String get(int i);

    public abstract int size();

    public abstract String[] toStringArray();

    public abstract String[] toStringArray(int i, int j);
}
