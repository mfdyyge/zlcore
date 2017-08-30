// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.zl.base.io;

import com.zl.base.string.Arrays;

import java.io.IOException;
import java.io.OutputStream;

public class BufferingOutputStream extends OutputStream
{

    public BufferingOutputStream(OutputStream outputstream)
    {
        other = outputstream;
        buf = new byte[4096];
    }

    public BufferingOutputStream(OutputStream outputstream, int i)
    {
        other = outputstream;
        buf = new byte[i];
    }

    public void write(byte abyte0[], int i, int j)
        throws IOException
    {
        if(j < buf.length - bufOff)
        {
            System.arraycopy(abyte0, i, buf, bufOff, j);
            bufOff += j;
        } else
        {
            int k = buf.length - bufOff;
            System.arraycopy(abyte0, i, buf, bufOff, k);
            bufOff += k;
            flush();
            i += k;
            for(j -= k; j >= buf.length; j -= buf.length)
            {
                other.write(abyte0, i, buf.length);
                i += buf.length;
            }

            if(j > 0)
            {
                System.arraycopy(abyte0, i, buf, bufOff, j);
                bufOff += j;
            }
        }
    }

    public void write(int i)
        throws IOException
    {
        buf[bufOff++] = (byte)i;
        if(bufOff == buf.length)
            flush();
    }

    public void flush()
        throws IOException
    {
        other.write(buf, 0, bufOff);
        bufOff = 0;
        Arrays.fill(buf, (byte)0);
    }

    public void close()
        throws IOException
    {
        flush();
        other.close();
    }

    private final OutputStream other;
    private final byte buf[];
    private int bufOff;
}
