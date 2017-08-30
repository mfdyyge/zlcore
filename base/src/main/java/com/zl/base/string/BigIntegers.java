// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.zl.base.string;

import java.math.BigInteger;
import java.security.SecureRandom;

public final class BigIntegers
{

    public BigIntegers()
    {
    }

    public static byte[] asUnsignedByteArray(BigInteger biginteger)
    {
        byte abyte0[] = biginteger.toByteArray();
        if(abyte0[0] == 0)
        {
            byte abyte1[] = new byte[abyte0.length - 1];
            System.arraycopy(abyte0, 1, abyte1, 0, abyte1.length);
            return abyte1;
        } else
        {
            return abyte0;
        }
    }

    public static byte[] asUnsignedByteArray(int i, BigInteger biginteger)
    {
        byte abyte0[] = biginteger.toByteArray();
        if(abyte0.length == i)
            return abyte0;
        int j = abyte0[0] != 0 ? 0 : 1;
        int k = abyte0.length - j;
        if(k > i)
        {
            throw new IllegalArgumentException("standard length exceeded for value");
        } else
        {
            byte abyte1[] = new byte[i];
            System.arraycopy(abyte0, j, abyte1, abyte1.length - k, k);
            return abyte1;
        }
    }

    public static BigInteger createRandomInRange(BigInteger biginteger, BigInteger biginteger1, SecureRandom securerandom)
    {
        int i = biginteger.compareTo(biginteger1);
        if(i >= 0)
            if(i > 0)
                throw new IllegalArgumentException("'min' may not be greater than 'max'");
            else
                return biginteger;
        if(biginteger.bitLength() > biginteger1.bitLength() / 2)
            return createRandomInRange(ZERO, biginteger1.subtract(biginteger), securerandom).add(biginteger);
        for(int j = 0; j < 1000; j++)
        {
            BigInteger biginteger2 = new BigInteger(biginteger1.bitLength(), securerandom);
            if(biginteger2.compareTo(biginteger) >= 0 && biginteger2.compareTo(biginteger1) <= 0)
                return biginteger2;
        }

        return (new BigInteger(biginteger1.subtract(biginteger).bitLength() - 1, securerandom)).add(biginteger);
    }

    public static BigInteger fromUnsignedByteArray(byte abyte0[])
    {
        return new BigInteger(1, abyte0);
    }

    public static BigInteger fromUnsignedByteArray(byte abyte0[], int i, int j)
    {
        byte abyte1[] = abyte0;
        if(i != 0 || j != abyte0.length)
        {
            abyte1 = new byte[j];
            System.arraycopy(abyte0, i, abyte1, 0, j);
        }
        return new BigInteger(1, abyte1);
    }

    private static final int MAX_ITERATIONS = 1000;
    private static final BigInteger ZERO = BigInteger.valueOf(0L);

}
