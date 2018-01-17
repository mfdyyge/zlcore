package com.zl.core.base.string;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Vector;

public class Strings
{
    private static class StringListImpl extends ArrayList
            implements StringList
    {


        public boolean add(String s)
        {
            return super.add(s);
        }

        public String set(int i, String s)
        {
            return (String)super.set(i, s);
        }

        public void add(int i, String s)
        {
            super.add(i, s);
        }

        public String[] toStringArray()
        {
            String as[] = new String[size()];
            for(int i = 0; i != as.length; i++)
                as[i] = (String)get(i);

            return as;
        }

        public String[] toStringArray(int i, int j)
        {
            String as[] = new String[j - i];
            for(int k = i; k != size() && k != j; k++)
                as[k - i] = (String)get(k);

            return as;
        }

        public  void add(int i, Object obj)
        {
            add(i, (String)obj);
        }

        public  boolean add(Object obj)
        {
            return add((String)obj);
        }

        public  Object set(int i, Object obj)
        {
            return set(i, (String)obj);
        }

        public  String get(int i)
        {
            return (String)super.get(i);
        }

        private StringListImpl()
        {
        }
    }


    public Strings()
    {
    }

    public static String fromUTF8ByteArray(byte abyte0[])
    {
        int i = 0;
        int j = 0;
        while(i < abyte0.length)
        {
            j++;
            if((abyte0[i] & 0xf0) == 240)
            {
                j++;
                i += 4;
            } else
            if((abyte0[i] & 0xe0) == 224)
                i += 3;
            else
            if((abyte0[i] & 0xc0) == 192)
                i += 2;
            else
                i++;
        }
        char ac[] = new char[j];
        i = 0;
        j = 0;
        char c;
        for(; i < abyte0.length; ac[j++] = c)
        {
            if((abyte0[i] & 0xf0) == 240)
            {
                int k = (abyte0[i] & 3) << 18 | (abyte0[i + 1] & 0x3f) << 12 | (abyte0[i + 2] & 0x3f) << 6 | abyte0[i + 3] & 0x3f;
                int l = k - 0x10000;
                char c1 = (char)(0xd800 | l >> 10);
                char c2 = (char)(0xdc00 | l & 0x3ff);
                ac[j++] = c1;
                c = c2;
                i += 4;
                continue;
            }
            if((abyte0[i] & 0xe0) == 224)
            {
                c = (char)((abyte0[i] & 0xf) << 12 | (abyte0[i + 1] & 0x3f) << 6 | abyte0[i + 2] & 0x3f);
                i += 3;
                continue;
            }
            if((abyte0[i] & 0xd0) == 208)
            {
                c = (char)((abyte0[i] & 0x1f) << 6 | abyte0[i + 1] & 0x3f);
                i += 2;
                continue;
            }
            if((abyte0[i] & 0xc0) == 192)
            {
                c = (char)((abyte0[i] & 0x1f) << 6 | abyte0[i + 1] & 0x3f);
                i += 2;
            } else
            {
                c = (char)(abyte0[i] & 0xff);
                i++;
            }
        }

        return new String(ac);
    }

    public static byte[] toUTF8ByteArray(String s)
    {
        return toUTF8ByteArray(s.toCharArray());
    }

    public static byte[] toUTF8ByteArray(char ac[])
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        try
        {
            toUTF8ByteArray(ac, ((OutputStream) (bytearrayoutputstream)));
        }
        catch(IOException ioexception)
        {
            throw new IllegalStateException("cannot encode string to byte array!");
        }
        return bytearrayoutputstream.toByteArray();
    }

    public static void toUTF8ByteArray(char ac[], OutputStream outputstream)
            throws IOException
    {
        char ac1[] = ac;
        for(int i = 0; i < ac1.length; i++)
        {
            char c = ac1[i];
            if(c < '\200')
            {
                outputstream.write(c);
                continue;
            }
            if(c < '\u0800')
            {
                outputstream.write(0xc0 | c >> 6);
                outputstream.write(0x80 | c & 0x3f);
                continue;
            }
            if(c >= '\uD800' && c <= '\uDFFF')
            {
                if(i + 1 >= ac1.length)
                    throw new IllegalStateException("invalid UTF-16 codepoint");
                char c1 = c;
                c = ac1[++i];
                char c2 = c;
                if(c1 > '\uDBFF')
                    throw new IllegalStateException("invalid UTF-16 codepoint");
                int j = ((c1 & 0x3ff) << 10 | c2 & 0x3ff) + 0x10000;
                outputstream.write(0xf0 | j >> 18);
                outputstream.write(0x80 | j >> 12 & 0x3f);
                outputstream.write(0x80 | j >> 6 & 0x3f);
                outputstream.write(0x80 | j & 0x3f);
            } else
            {
                outputstream.write(0xe0 | c >> 12);
                outputstream.write(0x80 | c >> 6 & 0x3f);
                outputstream.write(0x80 | c & 0x3f);
            }
        }

    }

    public static String toUpperCase(String s)
    {
        boolean flag = false;
        char ac[] = s.toCharArray();
        for(int i = 0; i != ac.length; i++)
        {
            char c = ac[i];
            if('a' <= c && 'z' >= c)
            {
                flag = true;
                ac[i] = (char)((c - 97) + 65);
            }
        }

        if(flag)
            return new String(ac);
        else
            return s;
    }

    public static String toLowerCase(String s)
    {
        boolean flag = false;
        char ac[] = s.toCharArray();
        for(int i = 0; i != ac.length; i++)
        {
            char c = ac[i];
            if('A' <= c && 'Z' >= c)
            {
                flag = true;
                ac[i] = (char)((c - 65) + 97);
            }
        }

        if(flag)
            return new String(ac);
        else
            return s;
    }

    public static byte[] toByteArray(char ac[])
    {
        byte abyte0[] = new byte[ac.length];
        for(int i = 0; i != abyte0.length; i++)
            abyte0[i] = (byte)ac[i];

        return abyte0;
    }

    public static byte[] toByteArray(String s)
    {
        byte abyte0[] = new byte[s.length()];
        for(int i = 0; i != abyte0.length; i++)
        {
            char c = s.charAt(i);
            abyte0[i] = (byte)c;
        }

        return abyte0;
    }

    public static int toByteArray(String s, byte abyte0[], int i)
    {
        int j = s.length();
        for(int k = 0; k < j; k++)
        {
            char c = s.charAt(k);
            abyte0[i + k] = (byte)c;
        }

        return j;
    }

    public static String fromByteArray(byte abyte0[])
    {
        return new String(asCharArray(abyte0));
    }

    public static char[] asCharArray(byte abyte0[])
    {
        char ac[] = new char[abyte0.length];
        for(int i = 0; i != ac.length; i++)
            ac[i] = (char)(abyte0[i] & 0xff);

        return ac;
    }

    public static String[] split(String s, char c)
    {
        Vector vector = new Vector();
        for(boolean flag = true; flag;)
        {
            int i = s.indexOf(c);
            if(i > 0)
            {
                String s1 = s.substring(0, i);
                vector.addElement(s1);
                s = s.substring(i + 1);
            } else
            {
                flag = false;
                vector.addElement(s);
            }
        }

        String as[] = new String[vector.size()];
        for(int j = 0; j != as.length; j++)
            as[j] = (String)vector.elementAt(j);

        return as;
    }

    public static StringList newList()
    {
        return new StringListImpl();
    }

    public static String lineSeparator()
    {
        return LINE_SEPARATOR;
    }

    private static String LINE_SEPARATOR;


    static {
        try {
            LINE_SEPARATOR = (String)AccessController.doPrivileged(new PrivilegedAction() {
                public String run() {
                    return System.getProperty("line.separator");
                }
            });
        } catch (Exception var3) {
            try {
                LINE_SEPARATOR = String.format("%n", new Object[0]);
            } catch (Exception var2) {
                LINE_SEPARATOR = "\n";
            }
        }

    }
}
