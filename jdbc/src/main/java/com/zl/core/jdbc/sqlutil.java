package com.zl.core.jdbc;

import com.zl.core.base.map.MapUtil;
import com.zl.core.base.string.StringUtil;
import com.zl.core.jdbc.sql.pojo.TableFormParams;

import java.util.*;

public class sqlutil {


    //protected static Logger logger = Logger.getLogger();

    private  static     ThreadLocal<TableFormParams> tableFormParamsThreadLocal=new ThreadLocal<TableFormParams>();
    private             com.zl.core.jdbc.sql.pojo.TableFormParams tableformParams;

    private  static     String sql_insert="";    //添加SQL=> insert into 表名称(name,password,email,birthday) values(?,?,?,?)
    private  static     String sql_delete="";    //删除SQL=> delete from 表名称 where ids=5  (删除此行)---where后面跟一个条件
    private  static     String sql_update="";     //更新SQL=> update 表名称 set +列名称='p006 ',列名称='p002' where ids=6-----用逗号隔开可以修改多列
    private  static     String sql_select="";  //查询SQL=>

    private Map mapTable=new HashMap();
    static
    {

    }

    public static String getSql_Insert(String table,Map map)
    {
        String key=MapUtil.getKey_toString(map);

        Object[] values_array=MapUtil.getValues(map);

        //String values=MapUtil.getValues_toString(map);
        String values2= StringUtil.toString_insert_values(values_array);

        sql_insert="insert into "+table+"("+key+") values("+values2+")";

        return sql_insert;
    }

    public static String getSql_Delte(Map map){


        return sql_delete;
    }

    public static String getSql_Update(Map map){

        return sql_update;
    }


    public static String getSql_select(Map map){

        return sql_select;
    }
    /*******************************************************************************************************************
     * 通过map取得sql语句
     * @param table_name  表名
     * @param MapTableProperties 表字段
     * @return
     */
    public static String getSqlFromMap(String table_name,Map<String, Object> MapTableProperties)
    {

        StringBuffer sql = new StringBuffer("select * from "+table_name+" where 1=1 ");

        Set<String> set = MapTableProperties.keySet();

        for (Object keyName : set)
        {

            Object value = MapTableProperties.get(keyName);

            if (value != null)
            {

                //apche.dbutils.test.utils = apche.dbutils.test.utils + " and " + keyName + " = " + value;
                sql.append( " and " );
                sql.append(keyName);
                sql.append(" = ? ");

            }

        }

        return sql.toString();
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
    public static TableFormParams getTableFormParams_FromMap_oracle(String tableName,Map<String, String> map,  String pageNumber, String pageSize)
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
