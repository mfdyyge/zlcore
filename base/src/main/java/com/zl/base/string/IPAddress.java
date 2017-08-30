// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.zl.base.string;


public class IPAddress
{

    public IPAddress()
    {
    }

    public static boolean isValid(String s)
    {
        return isValidIPv4(s) || isValidIPv6(s);
    }

    public static boolean isValidWithNetMask(String s)
    {
        return isValidIPv4WithNetmask(s) || isValidIPv6WithNetmask(s);
    }

    public static boolean isValidIPv4(String s)
    {
        if(s.length() == 0)
            return false;
        int j = 0;
        String s1 = (new StringBuilder()).append(s).append(".").toString();
        int k;
        for(int l = 0; l < s1.length() && (k = s1.indexOf('.', l)) > l;)
        {
            if(j == 4)
                return false;
            int i;
            try
            {
                i = Integer.parseInt(s1.substring(l, k));
            }
            catch(NumberFormatException numberformatexception)
            {
                return false;
            }
            if(i < 0 || i > 255)
                return false;
            l = k + 1;
            j++;
        }

        return j == 4;
    }

    public static boolean isValidIPv4WithNetmask(String s)
    {
        int i = s.indexOf("/");
        String s1 = s.substring(i + 1);
        return i > 0 && isValidIPv4(s.substring(0, i)) && (isValidIPv4(s1) || isMaskValue(s1, 32));
    }

    public static boolean isValidIPv6WithNetmask(String s)
    {
        int i = s.indexOf("/");
        String s1 = s.substring(i + 1);
        return i > 0 && isValidIPv6(s.substring(0, i)) && (isValidIPv6(s1) || isMaskValue(s1, 128));
    }

    private static boolean isMaskValue(String s, int i)
    {
        try
        {
            int j = Integer.parseInt(s);
            return j >= 0 && j <= i;
        }
        catch(NumberFormatException numberformatexception)
        {
            return false;
        }
    }

    public static boolean isValidIPv6(String s)
    {
        if(s.length() == 0)
            return false;
        int j = 0;
        String s1 = (new StringBuilder()).append(s).append(":").toString();
        boolean flag = false;
        int k;
        for(int l = 0; l < s1.length() && (k = s1.indexOf(':', l)) >= l;)
        {
            if(j == 8)
                return false;
            if(l != k)
            {
                String s2 = s1.substring(l, k);
                if(k == s1.length() - 1 && s2.indexOf('.') > 0)
                {
                    if(!isValidIPv4(s2))
                        return false;
                    j++;
                } else
                {
                    int i;
                    try
                    {
                        i = Integer.parseInt(s1.substring(l, k), 16);
                    }
                    catch(NumberFormatException numberformatexception)
                    {
                        return false;
                    }
                    if(i < 0 || i > 65535)
                        return false;
                }
            } else
            {
                if(k != 1 && k != s1.length() - 1 && flag)
                    return false;
                flag = true;
            }
            l = k + 1;
            j++;
        }

        return j == 8 || flag;
    }
}
