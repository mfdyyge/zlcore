package com.zl.core.base.string;

public class utilStringSql {

    /**********************************************************************************************************/

    public static String toString_insert_key(Object[] arr)
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

    /**
     * insert [SQL 参数拼接--用于Apche.dbutil]
     * */
    public static String toString_insert_keyValues(Object[] arr)
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

    /**
     * update [SQL 参数拼接--用于Apche.dbutil]
     * */
    public static String toString_update_values(Object[] arr)
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
