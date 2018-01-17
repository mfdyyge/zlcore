package com.zl.core.base.string;

/**
 * 
 * 常用 String 工具类
 * 
 * @author kailin.chen
 * @version [版本号, 2017-7-27]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class StringUtil extends Strings
{
    /**
     * 驼峰命名
     * 
     * @param input
     * @param firstCharacterUppercase
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static String camelCase(String input, boolean firstCharacterUppercase)
    {
        StringBuilder sb = new StringBuilder();
        boolean nextUpperCase = false;
        for (int i = 0; i < input.length(); i++)
        {
            char c = input.charAt(i);
            switch (c)
            {
                case '_':
                case '-':
                case '@':
                case '$':
                case '#':
                case ' ':
                    if (sb.length() > 0)
                    {
                        nextUpperCase = true;
                    }
                    break;
                default:
                    if (nextUpperCase)
                    {
                        sb.append(Character.toUpperCase(c));
                        nextUpperCase = false;
                    }
                    else
                    {
                        sb.append(Character.toLowerCase(c));
                    }
                    break;
            }
        }
        if (firstCharacterUppercase)
        {
            sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        }
        return sb.toString();
    }

    /**
     * 参数为Null时返回:true
     * @param str
     * @return
     */
    public static boolean isNull(String str)
    {

        if("".equals(str) || null==str )
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * 参数不为Null时返回:true
     * @param str
     * @return
     */
    public static boolean isNotNull(String str)
    {
        if("".equals(str) || null==str )
        {
            return false;
        }
        else
            {
            return true;
        }


    }


    public static String toString(Object[] arr)
    {
        //1,定义字符串变量。
        String temp = "";
        //2,遍历数组。将每一个数组的元素和字符串相连接。
        for(int x = 0; x < arr.length; x++)
        {
            //判断，不是最后一个元素，后面连接逗号，是最后一个元素，后面不连接逗号。
            if(x!=arr.length-1)
                temp = temp + arr[x] + ",";
            else
                temp = temp + arr[x];
        }


        //3，将连接后的字符串返回。哦耶！
        return temp;

    }
    public static String toString_insert_values(Object[] arr)
    {
        //1,定义字符串变量。
        String temp = "";
        //2,遍历数组。将每一个数组的元素和字符串相连接。
        for(int x = 0; x < arr.length; x++)
        {
            //判断，不是最后一个元素，后面连接逗号，是最后一个元素，后面不连接逗号。
            if(x!=arr.length-1)
                temp = temp + "?" + ",";
            else
                temp = temp + "?";
        }


        //3，将连接后的字符串返回。哦耶！
        return temp;

    }
}


class ArrayTest3
{
    public static void main(String[] args)
    {

        Object[] arr = {34,12,56,90};
        String str = toString2(arr);
        System.out.println(str);
    }

	/*
	需求1：定义功能，将{34,12,67}数组中的元素转成字符串  "[34,12,67]"
	明确1：结果？字符串。
	明确2：参数？数组。

	思路：
	简单的方式就是利用了字符串和任何数据相加都是相连接。
	*/

    public static String toString(Object[] arr)
    {
        //1,定义字符串变量。
        String temp = "[";
        //2,遍历数组。将每一个数组的元素和字符串相连接。
        for(int x = 0; x < arr.length; x++)
        {
            //判断，不是最后一个元素，后面连接逗号，是最后一个元素，后面不连接逗号。
            if(x!=arr.length-1)
                temp = temp + arr[x] + ",";
            else
                temp = temp + arr[x] + "]";
        }


        //3，将连接后的字符串返回。哦耶！
        return temp;

    }

    public static String toString2(Object[] arr)
    {
        //1,定义字符串变量。
        String temp = "";
        //2,遍历数组。将每一个数组的元素和字符串相连接。
        for(int x = 0; x < arr.length; x++)
        {
            //判断，不是最后一个元素，后面连接逗号，是最后一个元素，后面不连接逗号。
            if(x!=arr.length-1)
                temp = temp + arr[x] + ",";
            else
                temp = temp + arr[x];
        }


        //3，将连接后的字符串返回。哦耶！
        return temp;

    }
}

