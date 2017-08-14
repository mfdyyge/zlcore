package com.zl.jdbc.utils;

import com.zl.jdbc.page.Page;
import com.zl.jdbc.pojo.FormParams;

import java.util.*;
/**
 * Created by Administrator on 2017/8/12. 通过map取得sql语句
 * @author   刚背猪
 *
 */
public class GetSql
{

    private  static FormParams tb=new FormParams();;

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
     * 获取表单参数对象map=>FormParams  \n
     * 把分页参数[pageNumber_filed,pageSize__filed]从表单参数Map中分离出来 \n
     * @param map   例子:{tablename:"user",params1:"valxx",params2:"val2xx",params3:"val3xx",pageNumber:1,pageSize:20}
     * @param pageNumber //当前页码
     * @param pageSize   //每页显示记录数
     */
    public static void getFormParams_FromMap(Map<String, String> map,String pageNumber_filed,String pageSize__filed)
    {
        //"SELECT * FROM (SELECT A.*,ROWNUM RN " + "FROM (" + sql + ") A WHERE ROWNUM <=? )  WHERE RN >=?";

        //分页参数-map 中分离出来
        /*************************************************************************************************************/
        Object[] array_page_val=new Object[2];    //表单 分页值
        Page page = new Page();

/*        page.setPageNum(1);
        page.setPageSize(4);*/
        if(null != pageNumber_filed && null != pageSize__filed )//分页参数
        {
            int page_num    =Integer.parseInt(map.get(pageNumber_filed));map.remove(pageNumber_filed);//提取后删除分页参数
            int page_size   =Integer.parseInt(map.get(pageSize__filed));map.remove(pageSize__filed);//提取后删除分页参数
            /************************************************************/
            page.setPageEnd((page_num - 1) * page_size + 1);// 每页结束条数
            array_page_val[0]=(page_num - 1) * page_size + 1;

            /************************************************************/
            page.setPageBegin((page_num) * page_size);      // 每页开始条数
            array_page_val[1]=(page_num) * page_size;

            /************************************************************/


            System.out.println("array_page_val[0] = " + array_page_val[0]);
            System.out.println("array_page_val[1] = " + array_page_val[1]);
        }


        //
        /*************************************************************************************************************/
        Set<String> set = map.keySet();//删除分页参数--提取表单参数

        int size=map.size();

        List array_form_params_key=new ArrayList();//表单参数
        List array_form_params_val=new ArrayList();//表单参数值


        for (String keyName : set)
        {
            String value = map.get(keyName);
            if (value != null)
            {
                array_form_params_key.add(keyName);
                array_form_params_val.add(value);
            }

        }
        System.out.println("params_key = " + array_form_params_key);
        System.out.println("params_val = " + array_form_params_val);


    }


}



