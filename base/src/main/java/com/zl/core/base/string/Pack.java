// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.zl.core.base.string;


public abstract class Pack
{

    public Pack()
    {
    }

    public static int bigEndianToInt(byte abyte0[], int i)
    {
        int j = abyte0[i] << 24;
        j |= (abyte0[++i] & 0xff) << 16;
        j |= (abyte0[++i] & 0xff) << 8;
        j |= abyte0[++i] & 0xff;
        return j;
    }

    public static void bigEndianToInt(byte abyte0[], int i, int ai[])
    {
        for(int j = 0; j < ai.length; j++)
        {
            ai[j] = bigEndianToInt(abyte0, i);
            i += 4;
        }

    }

    public static byte[] intToBigEndian(int i)
    {
        byte abyte0[] = new byte[4];
        intToBigEndian(i, abyte0, 0);
        return abyte0;
    }

    public static void intToBigEndian(int i, byte abyte0[], int j)
    {
        abyte0[j] = (byte)(i >>> 24);
        abyte0[++j] = (byte)(i >>> 16);
        abyte0[++j] = (byte)(i >>> 8);
        abyte0[++j] = (byte)i;
    }

    public static byte[] intToBigEndian(int ai[])
    {
        byte abyte0[] = new byte[4 * ai.length];
        intToBigEndian(ai, abyte0, 0);
        return abyte0;
    }

    public static void intToBigEndian(int ai[], byte abyte0[], int i)
    {
        for(int j = 0; j < ai.length; j++)
        {
            intToBigEndian(ai[j], abyte0, i);
            i += 4;
        }

    }

    public static long bigEndianToLong(byte abyte0[], int i)
    {
        int j = bigEndianToInt(abyte0, i);
        int k = bigEndianToInt(abyte0, i + 4);
        return ((long)j & 0xffffffffL) << 32 | (long)k & 0xffffffffL;
    }

    public static void bigEndianToLong(byte abyte0[], int i, long al[])
    {
        for(int j = 0; j < al.length; j++)
        {
            al[j] = bigEndianToLong(abyte0, i);
            i += 8;
        }

    }

    public static byte[] longToBigEndian(long l)
    {
        byte abyte0[] = new byte[8];
        longToBigEndian(l, abyte0, 0);
        return abyte0;
    }

    public static void longToBigEndian(long l, byte abyte0[], int i)
    {
        intToBigEndian((int)(l >>> 32), abyte0, i);
        intToBigEndian((int)(l & 0xffffffffL), abyte0, i + 4);
    }

    public static byte[] longToBigEndian(long al[])
    {
        byte abyte0[] = new byte[8 * al.length];
        longToBigEndian(al, abyte0, 0);
        return abyte0;
    }

    public static void longToBigEndian(long al[], byte abyte0[], int i)
    {
        for(int j = 0; j < al.length; j++)
        {
            longToBigEndian(al[j], abyte0, i);
            i += 8;
        }

    }

    public static int littleEndianToInt(byte abyte0[], int i)
    {
        int j = abyte0[i] & 0xff;
        j |= (abyte0[++i] & 0xff) << 8;
        j |= (abyte0[++i] & 0xff) << 16;
        j |= abyte0[++i] << 24;
        return j;
    }

    public static void littleEndianToInt(byte abyte0[], int i, int ai[])
    {
        for(int j = 0; j < ai.length; j++)
        {
            ai[j] = littleEndianToInt(abyte0, i);
            i += 4;
        }

    }

    public static void littleEndianToInt(byte abyte0[], int i, int ai[], int j, int k)
    {
        for(int l = 0; l < k; l++)
        {
            ai[j + l] = littleEndianToInt(abyte0, i);
            i += 4;
        }

    }

    public static byte[] intToLittleEndian(int i)
    {
        byte abyte0[] = new byte[4];
        intToLittleEndian(i, abyte0, 0);
        return abyte0;
    }

    public static void intToLittleEndian(int i, byte abyte0[], int j)
    {
        abyte0[j] = (byte)i;
        abyte0[++j] = (byte)(i >>> 8);
        abyte0[++j] = (byte)(i >>> 16);
        abyte0[++j] = (byte)(i >>> 24);
    }

    public static byte[] intToLittleEndian(int ai[])
    {
        byte abyte0[] = new byte[4 * ai.length];
        intToLittleEndian(ai, abyte0, 0);
        return abyte0;
    }

    public static void intToLittleEndian(int ai[], byte abyte0[], int i)
    {
        for(int j = 0; j < ai.length; j++)
        {
            intToLittleEndian(ai[j], abyte0, i);
            i += 4;
        }

    }

    public static long littleEndianToLong(byte abyte0[], int i)
    {
        int j = littleEndianToInt(abyte0, i);
        int k = littleEndianToInt(abyte0, i + 4);
        return ((long)k & 0xffffffffL) << 32 | (long)j & 0xffffffffL;
    }

    public static void littleEndianToLong(byte abyte0[], int i, long al[])
    {
        for(int j = 0; j < al.length; j++)
        {
            al[j] = littleEndianToLong(abyte0, i);
            i += 8;
        }

    }

    public static byte[] longToLittleEndian(long l)
    {
        byte abyte0[] = new byte[8];
        longToLittleEndian(l, abyte0, 0);
        return abyte0;
    }

    public static void longToLittleEndian(long l, byte abyte0[], int i)
    {
        intToLittleEndian((int)(l & 0xffffffffL), abyte0, i);
        intToLittleEndian((int)(l >>> 32), abyte0, i + 4);
    }

    public static byte[] longToLittleEndian(long al[])
    {
        byte abyte0[] = new byte[8 * al.length];
        longToLittleEndian(al, abyte0, 0);
        return abyte0;
    }

    public static void longToLittleEndian(long al[], byte abyte0[], int i)
    {
        for(int j = 0; j < al.length; j++)
        {
            longToLittleEndian(al[j], abyte0, i);
            i += 8;
        }

    }
}
