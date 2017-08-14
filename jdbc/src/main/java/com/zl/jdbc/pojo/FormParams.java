package com.zl.jdbc.pojo;

/**
 * Created by Administrator on 2017/8/12.
 */
public class FormParams
{

    private  String sql;
    private  String tablename;
    private  Object[] paramsKey;//TG.INST_ADDR = ?<有序存储>
    private  Object[] paramsVal; //TG.INST_ADDR = ?普通参数数组<有序存储>
    private  Object[] page;   //分页参数<有序存储>

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
}
