package com.zl.jdbc.utils;

import com.zl.jdbc.pojo.table;

import java.util.*;
/**
 * Created by Administrator on 2017/8/12. 通过map取得sql语句
 * @author   刚背猪
 *
 */
public class GetSql
{

    public  static String getPageSql(String querySql,String pageNumber,String pageSize)
    {


        return "";
    }

    /**
     * 通过map取得sql语句
     * @param map
     * @return
     */
    public static String getSqlFromMap(Map<String, String> map) {

        String sql = "select * from emp where 1=1 ";

        Set<String> set = map.keySet();

        for (String keyName : set) {

            String value = map.get(keyName);

            if (value != null) {

                //utils = utils + " and " + keyName + " = " + value;
                sql = sql + " and " + keyName + " = ? ";

            }

        }

        return sql;

    }

    /**
     * 通过map取得sql语句对应的参数:Object params[] = { "钢背猪☣", "123", "gacl@sina.com", new Date() };
     * @param map
     * @return
     */
    public static Object[] getArryFromMap(Map<String, String> map)
    {

        String sql = "select * from emp where 1=1 ";
        Set<String> set = map.keySet();//Keys
        Collection<String> params=map.values();//values
        Object[] params_array=params.toArray();
        return params_array;

    }

    /**
     *
     * @param map {tablename:"user",params1="valxx",params2="val2xx",params3="val3xx",}
     */
    public static void getTableFromMap(Map<String, String> map)
    {
        table tb=new table();
        Set<String> set = map.keySet();

        int size=map.size();

        List params_key=new ArrayList();//
        List params_val=new ArrayList();

        for (String keyName : set)
        {
            String value = map.get(keyName);
            if (value != null)
            {
                params_key.add(keyName);
                params_val.add(value);
            }

        }
        System.out.println("params_key = " + params_key);
        System.out.println("params_val = " + params_val);


    }


}



