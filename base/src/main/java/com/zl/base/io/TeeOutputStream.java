// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.zl.base.io;

import java.io.IOException;
import java.io.OutputStream;

public class TeeOutputStream extends OutputStream
{

    public TeeOutputStream(OutputStream outputstream, OutputStream outputstream1)
    {
        output1 = outputstream;
        output2 = outputstream1;
    }

    public void write(byte abyte0[])
        throws IOException
    {
        output1.write(abyte0);
        output2.write(abyte0);
    }

    public void write(byte abyte0[], int i, int j)
        throws IOException
    {
        output1.write(abyte0, i, j);
        output2.write(abyte0, i, j);
    }

    public void write(int i)
        throws IOException
    {
        output1.write(i);
        output2.write(i);
    }

    public void flush()
        throws IOException
    {
        output1.flush();
        output2.flush();
    }

    public void close()
        throws IOException
    {
        output1.close();
        output2.close();
    }

    private OutputStream output1;
    private OutputStream output2;
}
