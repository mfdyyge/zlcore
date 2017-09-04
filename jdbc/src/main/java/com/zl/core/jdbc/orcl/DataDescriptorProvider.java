// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DataDescriptorProvider.java

package com.zl.core.jdbc.orcl;

import java.beans.PropertyChangeListener;

// Referenced classes of package com.zl.orcl.db:
//            DataDescriptor

public interface DataDescriptorProvider
{

    public abstract int getDescriptorCount();

    public abstract DataDescriptor getDescriptor(int i);

    public abstract void addPropertyChangeListener(PropertyChangeListener propertychangelistener);

    public abstract void removePropertyChangeListener(PropertyChangeListener propertychangelistener);

    public static final String PROPERTY_DESCRIPTOR_COUNT = "descriptorCount";
    public static final String PROPERTY_DESCRIPTOR_CHANGED = "descriptorChanged";
}
