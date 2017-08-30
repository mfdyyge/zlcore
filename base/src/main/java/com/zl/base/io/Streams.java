// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.zl.base.io;

import java.io.*;

// Referenced classes of package org.bouncycastle.util.io:
//            StreamOverflowException

public final class Streams
{

    public Streams()
    {
    }

    public static void drain(InputStream inputstream)
        throws IOException
    {
        for(byte abyte0[] = new byte[BUFFER_SIZE]; inputstream.read(abyte0, 0, abyte0.length) >= 0;);
    }

    public static byte[] readAll(InputStream inputstream)
        throws IOException
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        pipeAll(inputstream, bytearrayoutputstream);
        return bytearrayoutputstream.toByteArray();
    }

    public static byte[] readAllLimited(InputStream inputstream, int i)
        throws IOException
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        pipeAllLimited(inputstream, i, bytearrayoutputstream);
        return bytearrayoutputstream.toByteArray();
    }

    public static int readFully(InputStream inputstream, byte abyte0[])
        throws IOException
    {
        return readFully(inputstream, abyte0, 0, abyte0.length);
    }

    public static int readFully(InputStream inputstream, byte abyte0[], int i, int j)
        throws IOException
    {
        int k = 0;
        do
        {
            if(k >= j)
                break;
            int l = inputstream.read(abyte0, i + k, j - k);
            if(l < 0)
                break;
            k += l;
        } while(true);
        return k;
    }

    public static void pipeAll(InputStream inputstream, OutputStream outputstream)
        throws IOException
    {
        byte abyte0[] = new byte[BUFFER_SIZE];
        int i;
        while((i = inputstream.read(abyte0, 0, abyte0.length)) >= 0) 
            outputstream.write(abyte0, 0, i);
    }

    public static long pipeAllLimited(InputStream inputstream, long l, OutputStream outputstream)
        throws IOException
    {
        long l1 = 0L;
        byte abyte0[] = new byte[BUFFER_SIZE];
        int i;
        while((i = inputstream.read(abyte0, 0, abyte0.length)) >= 0) 
        {
            if(l - l1 < (long)i)
                throw new StreamOverflowException("Data Overflow");
            l1 += i;
            outputstream.write(abyte0, 0, i);
        }
        return l1;
    }

    private static int BUFFER_SIZE = 4096;

}
