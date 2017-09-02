package com.zl.core.jdbc;


import com.zl.core.jdbc.sql.pojo.TableFormParams;

import java.util.*;
import java.util.Collection;

/**
 * Created by Administrator on 2017/8/12. 通过map取得sql语句
 * @author   刚背猪
 *
 */
public class SqlGenerator
{
    private  static  ThreadLocal<TableFormParams> tb=new ThreadLocal<TableFormParams>();

    static
    {
        ;
    }

    /**
     * 获取sql
     * @return
     */
    public  static String getQueryPageSql_oracle()
    {
        com.zl.core.jdbc.sql.pojo.TableFormParams tableformParams;
        String sql_add="insert into "+"tableName";    //添加SQL -//"insert into users(name,password,email,birthday) values(?,?,?,?)"
        String sql_del;    //删除SQL
        String sql_up;     //更新SQL
        String sql_query;  //查询SQL
        return "";
    }



    /**
     * 通过map取得sql语句
     * @param map
     * @return
     */
    public static String getSqlFromMap(Map<String, String> map)
    {

        String sql = "select * from emp where 1=1 ";

        Set<String> set = map.keySet();

        for (String keyName : set)
        {

            String value = map.get(keyName);

            if (value != null)
            {

                //utils = utils + " and " + keyName + " = " + value;
                sql = sql + " and " + keyName + " = ? ";

            }

        }

        return sql;

    }

    /**
     * 通过map取得sql语句对应的参数:Object params[] = { "钢背猪☣", "123", "gacl@sina.com", new Date() };
     * @param   map
     * @return  Object[]=>
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
     * 获取表单参数对象map =>                       <br/>
     * 保存到对象  [ TableFormParams ]             <br/>
     * 表名       [ TableFormParams.tablename ]   <br/>
     * 分页参数    [ TableFormParams.page ]        <br/>
     * 表单字段    [ TableFormParams.paramsKey[] | TableFormParams.paramsVal[] ] <br/>
     *
     * @param map           //例子:{tablename:"user",params1:"valxx",params2:"val2xx",params3:"val3xx",pageNumber:1,pageSize:20}
     * @param tableName     //表名
     * @param pageNumber    //当前页码
     * @param pageSize      //每页显示记录数
     */
    public static TableFormParams getTableFormParams_FromMap_oracle(Map<String, String> map, String tableName, String pageNumber, String pageSize)
    {
        //"SELECT * FROM (SELECT A.*,ROWNUM RN " + "FROM (" + sql + ") A WHERE ROWNUM <=? )  WHERE RN >=?";
        TableFormParams tableformParams      =new TableFormParams(tableName); //设置表名

        Object[]        tableformParams_page =new Object[2];                  //分页值



        /**
         * 1.分页参数
         * ***********************************************************************************************************/
        if(null != pageNumber && null != pageSize )
        {
            int page_num    =Integer.parseInt(map.get(pageNumber));map.remove(pageNumber);//提取后删除分页参数
            int page_size   =Integer.parseInt(map.get(pageSize));  map.remove(pageSize);  //提取后删除分页参数
            /************************************************************/
            //page.setPageEnd((page_num - 1) * page_size + 1);  // 每页结束条数
            //page.setPageBegin((page_num) * page_size);        // 每页开始条数
            /************************************************************/
            tableformParams_page[0]=(page_num - 1) * page_size + 1;   // 结束条数
            tableformParams_page[1]=(page_num) * page_size;           // 开始条数
            tableformParams.setPage(tableformParams_page);
            /************************************************************/

            System.out.println("tableformParams_page[0] = " + tableformParams_page[0]);
            System.out.println("tableformParams_page[1] = " + tableformParams_page[1]);
        }


        /**
         * 2.表单字段[ ParamsKey | ParamsVal ]
         * ***********************************************************************************************************/
        Set<String> set = map.keySet();           //表单参数
        List tableformParams_key=new ArrayList(); //表单参数:Key
        List tableformParams_val=new ArrayList(); //表单参数:Val

        for (String keyName : set)
        {
            String value = map.get(keyName);
            if (null != value)
            {
                tableformParams_key.add(keyName);
                tableformParams_val.add(value);
            }

        }
        /**
         * ***********************************************************************************************************/
        tableformParams.setParamsKey(tableformParams_key.toArray());
        tableformParams.setParamsVal(tableformParams_val.toArray());

        return tableformParams;
    }


}



