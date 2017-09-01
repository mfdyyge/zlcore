// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.zl.core.base.io;

import java.io.*;

public class TeeInputStream extends InputStream
{

    public TeeInputStream(InputStream inputstream, OutputStream outputstream)
    {
        input = inputstream;
        output = outputstream;
    }

    public int read(byte abyte0[])
        throws IOException
    {
        return read(abyte0, 0, abyte0.length);
    }

    public int read(byte abyte0[], int i, int j)
        throws IOException
    {
        int k = input.read(abyte0, i, j);
        if(k > 0)
            output.write(abyte0, i, k);
        return k;
    }

    public int read()
        throws IOException
    {
        int i = input.read();
        if(i >= 0)
            output.write(i);
        return i;
    }

    public void close()
        throws IOException
    {
        input.close();
        output.close();
    }

    public OutputStream getOutputStream()
    {
        return output;
    }

    private final InputStream input;
    private final OutputStream output;
}
