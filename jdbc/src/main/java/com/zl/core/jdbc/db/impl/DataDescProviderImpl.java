// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DataDescProviderImpl.java

package com.zl.core.jdbc.db.impl;

import com.zl.core.jdbc.db.DataDescriptor;
import com.zl.core.jdbc.db.DataDescriptorProvider;

import java.beans.PropertyChangeListener;

public final class DataDescProviderImpl
    implements DataDescriptorProvider
{

    public DataDescProviderImpl(DataDescriptor descriptors[])
    {
        if(descriptors == null || descriptors.length == 0)
        {
            throw new IllegalArgumentException("illegal descriptors");
        } else
        {
            _descriptors = new DataDescriptor[descriptors.length];
            System.arraycopy(descriptors, 0, _descriptors, 0, descriptors.length);
            return;
        }
    }

    public int getDescriptorCount()
    {
        return _descriptors.length;
    }

    public DataDescriptor getDescriptor(int index)
    {
        return _descriptors[index];
    }

    public void addPropertyChangeListener(PropertyChangeListener propertychangelistener)
    {
    }

    public void removePropertyChangeListener(PropertyChangeListener propertychangelistener)
    {
    }

    private DataDescriptor _descriptors[];
}
