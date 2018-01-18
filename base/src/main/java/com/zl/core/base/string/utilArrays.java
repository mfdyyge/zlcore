// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.zl.core.base.string;

import java.math.BigInteger;
import java.util.NoSuchElementException;

public final class utilArrays
{
    public static class Iterator
        implements java.util.Iterator
    {

        public boolean hasNext()
        {
            return position < dataArray.length;
        }

        public Object next()
        {
            if(position == dataArray.length)
                throw new NoSuchElementException((new StringBuilder()).append("Out of elements: ").append(position).toString());
            else
                return dataArray[position++];
        }

        public void remove()
        {
            throw new UnsupportedOperationException("Cannot remove element from an Array.");
        }

        private final Object dataArray[];
        private int position;

        public Iterator(Object aobj[])
        {
            position = 0;
            dataArray = aobj;
        }
    }


    private utilArrays()
    {
    }

    public static boolean areEqual(boolean aflag[], boolean aflag1[])
    {
        if(aflag == aflag1)
            return true;
        if(aflag == null || aflag1 == null)
            return false;
        if(aflag.length != aflag1.length)
            return false;
        for(int i = 0; i != aflag.length; i++)
            if(aflag[i] != aflag1[i])
                return false;

        return true;
    }

    public static boolean areEqual(char ac[], char ac1[])
    {
        if(ac == ac1)
            return true;
        if(ac == null || ac1 == null)
            return false;
        if(ac.length != ac1.length)
            return false;
        for(int i = 0; i != ac.length; i++)
            if(ac[i] != ac1[i])
                return false;

        return true;
    }

    public static boolean areEqual(byte abyte0[], byte abyte1[])
    {
        if(abyte0 == abyte1)
            return true;
        if(abyte0 == null || abyte1 == null)
            return false;
        if(abyte0.length != abyte1.length)
            return false;
        for(int i = 0; i != abyte0.length; i++)
            if(abyte0[i] != abyte1[i])
                return false;

        return true;
    }

    public static boolean constantTimeAreEqual(byte abyte0[], byte abyte1[])
    {
        if(abyte0 == abyte1)
            return true;
        if(abyte0 == null || abyte1 == null)
            return false;
        if(abyte0.length != abyte1.length)
            return false;
        int i = 0;
        for(int j = 0; j != abyte0.length; j++)
            i |= abyte0[j] ^ abyte1[j];

        return i == 0;
    }

    public static boolean areEqual(int ai[], int ai1[])
    {
        if(ai == ai1)
            return true;
        if(ai == null || ai1 == null)
            return false;
        if(ai.length != ai1.length)
            return false;
        for(int i = 0; i != ai.length; i++)
            if(ai[i] != ai1[i])
                return false;

        return true;
    }

    public static boolean areEqual(long al[], long al1[])
    {
        if(al == al1)
            return true;
        if(al == null || al1 == null)
            return false;
        if(al.length != al1.length)
            return false;
        for(int i = 0; i != al.length; i++)
            if(al[i] != al1[i])
                return false;

        return true;
    }

    public static boolean areEqual(Object aobj[], Object aobj1[])
    {
        if(aobj == aobj1)
            return true;
        if(aobj == null || aobj1 == null)
            return false;
        if(aobj.length != aobj1.length)
            return false;
        for(int i = 0; i != aobj.length; i++)
        {
            Object obj = aobj[i];
            Object obj1 = aobj1[i];
            if(obj == null)
            {
                if(obj1 != null)
                    return false;
                continue;
            }
            if(!obj.equals(obj1))
                return false;
        }

        return true;
    }

    public static boolean contains(short aword0[], short word0)
    {
        for(int i = 0; i < aword0.length; i++)
            if(aword0[i] == word0)
                return true;

        return false;
    }

    public static boolean contains(int ai[], int i)
    {
        for(int j = 0; j < ai.length; j++)
            if(ai[j] == i)
                return true;

        return false;
    }

    public static void fill(byte abyte0[], byte byte0)
    {
        for(int i = 0; i < abyte0.length; i++)
            abyte0[i] = byte0;

    }

    public static void fill(char ac[], char c)
    {
        for(int i = 0; i < ac.length; i++)
            ac[i] = c;

    }

    public static void fill(long al[], long l)
    {
        for(int i = 0; i < al.length; i++)
            al[i] = l;

    }

    public static void fill(short aword0[], short word0)
    {
        for(int i = 0; i < aword0.length; i++)
            aword0[i] = word0;

    }

    public static void fill(int ai[], int i)
    {
        for(int j = 0; j < ai.length; j++)
            ai[j] = i;

    }

    public static int hashCode(byte abyte0[])
    {
        if(abyte0 == null)
            return 0;
        int i = abyte0.length;
        int j;
        for(j = i + 1; --i >= 0; j ^= abyte0[i])
            j *= 257;

        return j;
    }

    public static int hashCode(byte abyte0[], int i, int j)
    {
        if(abyte0 == null)
            return 0;
        int k = j;
        int l;
        for(l = k + 1; --k >= 0; l ^= abyte0[i + k])
            l *= 257;

        return l;
    }

    public static int hashCode(char ac[])
    {
        if(ac == null)
            return 0;
        int i = ac.length;
        int j;
        for(j = i + 1; --i >= 0; j ^= ac[i])
            j *= 257;

        return j;
    }

    public static int hashCode(int ai[][])
    {
        int i = 0;
        for(int j = 0; j != ai.length; j++)
            i = i * 257 + hashCode(ai[j]);

        return i;
    }

    public static int hashCode(int ai[])
    {
        if(ai == null)
            return 0;
        int i = ai.length;
        int j;
        for(j = i + 1; --i >= 0; j ^= ai[i])
            j *= 257;

        return j;
    }

    public static int hashCode(int ai[], int i, int j)
    {
        if(ai == null)
            return 0;
        int k = j;
        int l;
        for(l = k + 1; --k >= 0; l ^= ai[i + k])
            l *= 257;

        return l;
    }

    public static int hashCode(long al[])
    {
        if(al == null)
            return 0;
        int i = al.length;
        int j;
        long l;
        for(j = i + 1; --i >= 0; j ^= (int)(l >>> 32))
        {
            l = al[i];
            j *= 257;
            j ^= (int)l;
            j *= 257;
        }

        return j;
    }

    public static int hashCode(long al[], int i, int j)
    {
        if(al == null)
            return 0;
        int k = j;
        int l;
        long l1;
        for(l = k + 1; --k >= 0; l ^= (int)(l1 >>> 32))
        {
            l1 = al[i + k];
            l *= 257;
            l ^= (int)l1;
            l *= 257;
        }

        return l;
    }

    public static int hashCode(short aword0[][][])
    {
        int i = 0;
        for(int j = 0; j != aword0.length; j++)
            i = i * 257 + hashCode(aword0[j]);

        return i;
    }

    public static int hashCode(short aword0[][])
    {
        int i = 0;
        for(int j = 0; j != aword0.length; j++)
            i = i * 257 + hashCode(aword0[j]);

        return i;
    }

    public static int hashCode(short aword0[])
    {
        if(aword0 == null)
            return 0;
        int i = aword0.length;
        int j;
        for(j = i + 1; --i >= 0; j ^= aword0[i] & 0xff)
            j *= 257;

        return j;
    }

    public static int hashCode(Object aobj[])
    {
        if(aobj == null)
            return 0;
        int i = aobj.length;
        int j;
        for(j = i + 1; --i >= 0; j ^= aobj[i].hashCode())
            j *= 257;

        return j;
    }

    public static byte[] clone(byte abyte0[])
    {
        if(abyte0 == null)
        {
            return null;
        } else
        {
            byte abyte1[] = new byte[abyte0.length];
            System.arraycopy(abyte0, 0, abyte1, 0, abyte0.length);
            return abyte1;
        }
    }

    public static char[] clone(char ac[])
    {
        if(ac == null)
        {
            return null;
        } else
        {
            char ac1[] = new char[ac.length];
            System.arraycopy(ac, 0, ac1, 0, ac.length);
            return ac1;
        }
    }

    public static byte[] clone(byte abyte0[], byte abyte1[])
    {
        if(abyte0 == null)
            return null;
        if(abyte1 == null || abyte1.length != abyte0.length)
        {
            return clone(abyte0);
        } else
        {
            System.arraycopy(abyte0, 0, abyte1, 0, abyte1.length);
            return abyte1;
        }
    }

    public static byte[][] clone(byte abyte0[][])
    {
        if(abyte0 == null)
            return (byte[][])null;
        byte abyte1[][] = new byte[abyte0.length][];
        for(int i = 0; i != abyte1.length; i++)
            abyte1[i] = clone(abyte0[i]);

        return abyte1;
    }

    public static byte[][][] clone(byte abyte0[][][])
    {
        if(abyte0 == null)
            return (byte[][][])null;
        byte abyte1[][][] = new byte[abyte0.length][][];
        for(int i = 0; i != abyte1.length; i++)
            abyte1[i] = clone(abyte0[i]);

        return abyte1;
    }

    public static int[] clone(int ai[])
    {
        if(ai == null)
        {
            return null;
        } else
        {
            int ai1[] = new int[ai.length];
            System.arraycopy(ai, 0, ai1, 0, ai.length);
            return ai1;
        }
    }

    public static long[] clone(long al[])
    {
        if(al == null)
        {
            return null;
        } else
        {
            long al1[] = new long[al.length];
            System.arraycopy(al, 0, al1, 0, al.length);
            return al1;
        }
    }

    public static long[] clone(long al[], long al1[])
    {
        if(al == null)
            return null;
        if(al1 == null || al1.length != al.length)
        {
            return clone(al);
        } else
        {
            System.arraycopy(al, 0, al1, 0, al1.length);
            return al1;
        }
    }

    public static short[] clone(short aword0[])
    {
        if(aword0 == null)
        {
            return null;
        } else
        {
            short aword1[] = new short[aword0.length];
            System.arraycopy(aword0, 0, aword1, 0, aword0.length);
            return aword1;
        }
    }

    public static BigInteger[] clone(BigInteger abiginteger[])
    {
        if(abiginteger == null)
        {
            return null;
        } else
        {
            BigInteger abiginteger1[] = new BigInteger[abiginteger.length];
            System.arraycopy(abiginteger, 0, abiginteger1, 0, abiginteger.length);
            return abiginteger1;
        }
    }

    public static byte[] copyOf(byte abyte0[], int i)
    {
        byte abyte1[] = new byte[i];
        if(i < abyte0.length)
            System.arraycopy(abyte0, 0, abyte1, 0, i);
        else
            System.arraycopy(abyte0, 0, abyte1, 0, abyte0.length);
        return abyte1;
    }

    public static char[] copyOf(char ac[], int i)
    {
        char ac1[] = new char[i];
        if(i < ac.length)
            System.arraycopy(ac, 0, ac1, 0, i);
        else
            System.arraycopy(ac, 0, ac1, 0, ac.length);
        return ac1;
    }

    public static int[] copyOf(int ai[], int i)
    {
        int ai1[] = new int[i];
        if(i < ai.length)
            System.arraycopy(ai, 0, ai1, 0, i);
        else
            System.arraycopy(ai, 0, ai1, 0, ai.length);
        return ai1;
    }

    public static long[] copyOf(long al[], int i)
    {
        long al1[] = new long[i];
        if(i < al.length)
            System.arraycopy(al, 0, al1, 0, i);
        else
            System.arraycopy(al, 0, al1, 0, al.length);
        return al1;
    }

    public static BigInteger[] copyOf(BigInteger abiginteger[], int i)
    {
        BigInteger abiginteger1[] = new BigInteger[i];
        if(i < abiginteger.length)
            System.arraycopy(abiginteger, 0, abiginteger1, 0, i);
        else
            System.arraycopy(abiginteger, 0, abiginteger1, 0, abiginteger.length);
        return abiginteger1;
    }

    public static byte[] copyOfRange(byte abyte0[], int i, int j)
    {
        int k = getLength(i, j);
        byte abyte1[] = new byte[k];
        if(abyte0.length - i < k)
            System.arraycopy(abyte0, i, abyte1, 0, abyte0.length - i);
        else
            System.arraycopy(abyte0, i, abyte1, 0, k);
        return abyte1;
    }

    public static int[] copyOfRange(int ai[], int i, int j)
    {
        int k = getLength(i, j);
        int ai1[] = new int[k];
        if(ai.length - i < k)
            System.arraycopy(ai, i, ai1, 0, ai.length - i);
        else
            System.arraycopy(ai, i, ai1, 0, k);
        return ai1;
    }

    public static long[] copyOfRange(long al[], int i, int j)
    {
        int k = getLength(i, j);
        long al1[] = new long[k];
        if(al.length - i < k)
            System.arraycopy(al, i, al1, 0, al.length - i);
        else
            System.arraycopy(al, i, al1, 0, k);
        return al1;
    }

    public static BigInteger[] copyOfRange(BigInteger abiginteger[], int i, int j)
    {
        int k = getLength(i, j);
        BigInteger abiginteger1[] = new BigInteger[k];
        if(abiginteger.length - i < k)
            System.arraycopy(abiginteger, i, abiginteger1, 0, abiginteger.length - i);
        else
            System.arraycopy(abiginteger, i, abiginteger1, 0, k);
        return abiginteger1;
    }

    private static int getLength(int i, int j)
    {
        int k = j - i;
        if(k < 0)
        {
            StringBuffer stringbuffer = new StringBuffer(i);
            stringbuffer.append(" > ").append(j);
            throw new IllegalArgumentException(stringbuffer.toString());
        } else
        {
            return k;
        }
    }

    public static byte[] append(byte abyte0[], byte byte0)
    {
        if(abyte0 == null)
        {
            return (new byte[] {
                byte0
            });
        } else
        {
            int i = abyte0.length;
            byte abyte1[] = new byte[i + 1];
            System.arraycopy(abyte0, 0, abyte1, 0, i);
            abyte1[i] = byte0;
            return abyte1;
        }
    }

    public static short[] append(short aword0[], short word0)
    {
        if(aword0 == null)
        {
            return (new short[] {
                word0
            });
        } else
        {
            int i = aword0.length;
            short aword1[] = new short[i + 1];
            System.arraycopy(aword0, 0, aword1, 0, i);
            aword1[i] = word0;
            return aword1;
        }
    }

    public static int[] append(int ai[], int i)
    {
        if(ai == null)
        {
            return (new int[] {
                i
            });
        } else
        {
            int j = ai.length;
            int ai1[] = new int[j + 1];
            System.arraycopy(ai, 0, ai1, 0, j);
            ai1[j] = i;
            return ai1;
        }
    }

    public static byte[] concatenate(byte abyte0[], byte abyte1[])
    {
        if(abyte0 != null && abyte1 != null)
        {
            byte abyte2[] = new byte[abyte0.length + abyte1.length];
            System.arraycopy(abyte0, 0, abyte2, 0, abyte0.length);
            System.arraycopy(abyte1, 0, abyte2, abyte0.length, abyte1.length);
            return abyte2;
        }
        if(abyte1 != null)
            return clone(abyte1);
        else
            return clone(abyte0);
    }

    public static byte[] concatenate(byte abyte0[], byte abyte1[], byte abyte2[])
    {
        if(abyte0 != null && abyte1 != null && abyte2 != null)
        {
            byte abyte3[] = new byte[abyte0.length + abyte1.length + abyte2.length];
            System.arraycopy(abyte0, 0, abyte3, 0, abyte0.length);
            System.arraycopy(abyte1, 0, abyte3, abyte0.length, abyte1.length);
            System.arraycopy(abyte2, 0, abyte3, abyte0.length + abyte1.length, abyte2.length);
            return abyte3;
        }
        if(abyte0 == null)
            return concatenate(abyte1, abyte2);
        if(abyte1 == null)
            return concatenate(abyte0, abyte2);
        else
            return concatenate(abyte0, abyte1);
    }

    public static byte[] concatenate(byte abyte0[], byte abyte1[], byte abyte2[], byte abyte3[])
    {
        if(abyte0 != null && abyte1 != null && abyte2 != null && abyte3 != null)
        {
            byte abyte4[] = new byte[abyte0.length + abyte1.length + abyte2.length + abyte3.length];
            System.arraycopy(abyte0, 0, abyte4, 0, abyte0.length);
            System.arraycopy(abyte1, 0, abyte4, abyte0.length, abyte1.length);
            System.arraycopy(abyte2, 0, abyte4, abyte0.length + abyte1.length, abyte2.length);
            System.arraycopy(abyte3, 0, abyte4, abyte0.length + abyte1.length + abyte2.length, abyte3.length);
            return abyte4;
        }
        if(abyte3 == null)
            return concatenate(abyte0, abyte1, abyte2);
        if(abyte2 == null)
            return concatenate(abyte0, abyte1, abyte3);
        if(abyte1 == null)
            return concatenate(abyte0, abyte2, abyte3);
        else
            return concatenate(abyte1, abyte2, abyte3);
    }

    public static int[] concatenate(int ai[], int ai1[])
    {
        if(ai == null)
            return clone(ai1);
        if(ai1 == null)
        {
            return clone(ai);
        } else
        {
            int ai2[] = new int[ai.length + ai1.length];
            System.arraycopy(ai, 0, ai2, 0, ai.length);
            System.arraycopy(ai1, 0, ai2, ai.length, ai1.length);
            return ai2;
        }
    }

    public static byte[] prepend(byte abyte0[], byte byte0)
    {
        if(abyte0 == null)
        {
            return (new byte[] {
                byte0
            });
        } else
        {
            int i = abyte0.length;
            byte abyte1[] = new byte[i + 1];
            System.arraycopy(abyte0, 0, abyte1, 1, i);
            abyte1[0] = byte0;
            return abyte1;
        }
    }

    public static short[] prepend(short aword0[], short word0)
    {
        if(aword0 == null)
        {
            return (new short[] {
                word0
            });
        } else
        {
            int i = aword0.length;
            short aword1[] = new short[i + 1];
            System.arraycopy(aword0, 0, aword1, 1, i);
            aword1[0] = word0;
            return aword1;
        }
    }

    public static int[] prepend(int ai[], int i)
    {
        if(ai == null)
        {
            return (new int[] {
                i
            });
        } else
        {
            int j = ai.length;
            int ai1[] = new int[j + 1];
            System.arraycopy(ai, 0, ai1, 1, j);
            ai1[0] = i;
            return ai1;
        }
    }

    public static byte[] reverse(byte abyte0[])
    {
        if(abyte0 == null)
            return null;
        int i = 0;
        int j = abyte0.length;
        byte abyte1[] = new byte[j];
        while(--j >= 0) 
            abyte1[j] = abyte0[i++];
        return abyte1;
    }

    public static int[] reverse(int ai[])
    {
        if(ai == null)
            return null;
        int i = 0;
        int j = ai.length;
        int ai1[] = new int[j];
        while(--j >= 0) 
            ai1[j] = ai[i++];
        return ai1;
    }
}
