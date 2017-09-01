package com.zl.core.jdbc.pojo;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/8/12. <br/>
 * 用于SPringMVC(Map) 转换的对应参数对象 =>TableFormParams
 */
public class TableFormParams
{

    private  String sql;
    private  String tablename;

    private  Object[] paramsKey;//TG.INST_ADDR = ?<有序存储>
    private  Object[] paramsVal; //TG.INST_ADDR = ?普通参数数组<有序存储>

    private  Object[] page;   //分页参数<有序存储>

    private  String sql_add;    //添加SQL
    private  String sql_del;    //删除SQL
    private  String sql_up;     //更新SQL
    private  String sql_query;  //查询SQL

    public TableFormParams(String tablename)
    {
        this.tablename = tablename;
    }


    public  String getSql() {
        return sql;
    }

    public  void setSql(String sql) {
        this.sql = sql;
    }

    public  String getTablename() {
        return tablename;
    }

    public  void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public  Object[] getParamsKey() {
        return paramsKey;
    }

    public  void setParamsKey(Object[] paramsKey) {
        this.paramsKey = paramsKey;
    }

    public  Object[] getParamsVal() {
        return paramsVal;
    }

    public  void setParamsVal(Object[] paramsVal) {
        this.paramsVal = paramsVal;
    }

    public  Object[] getPage() {
        return page;
    }

    public  void setPage(Object[] page) {
        this.page = page;
    }




    public void setSql_add(String sql_add)
    {
        this.sql_add = sql_add;
    }


    public void setSql_del(String sql_del)
    {
        this.sql_del = sql_del;
    }


    public void setSql_up(String sql_up)
    {
        this.sql_up = sql_up;
    }

    public void setSql_query(String sql_query)
    {
        this.sql_query = sql_query;
    }

    /******************************************************************************************************************/
    public String getSql_add()
    {
        //sql_add=paramsKey.toString();
        /*for(String pkey:paramsKey)
        {

        }*/

        return sql_add;
    }
    public String getSql_del()
    {
        return sql_del;
    }
    public String getSql_up()
    {
        return sql_up;
    }
    public String getSql_query()
    {
        return sql_query;
    }




    @Override
    public int hashCode()
    {
        int result = getSql().hashCode();
        result = 31 * result + getTablename().hashCode();
        result = 31 * result + Arrays.hashCode(getParamsKey());
        result = 31 * result + Arrays.hashCode(getParamsVal());
        result = 31 * result + Arrays.hashCode(getPage());
        result = 31 * result + getSql_add().hashCode();
        result = 31 * result + getSql_del().hashCode();
        result = 31 * result + getSql_up().hashCode();
        result = 31 * result + getSql_query().hashCode();
        return result;
    }

    @Override
    public String toString()
    {
        return "TableFormParams{" +
                "sql='" + sql + '\'' +
                ", tablename='" + tablename + '\'' +
                ", paramsKey=" + Arrays.toString(paramsKey) +
                ", paramsVal=" + Arrays.toString(paramsVal) +
                ", page=" + Arrays.toString(page) +
                ", sql_add='" + sql_add + '\'' +
                ", sql_del='" + sql_del + '\'' +
                ", sql_up='" + sql_up + '\'' +
                ", sql_query='" + sql_query + '\'' +
                '}';
    }
}
