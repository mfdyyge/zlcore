package com.zl.jdbc.pojo;

/**
 * Created by Administrator on 2017/8/12.
 */
public class table {

    private static String sql;
    private static String tablename;
    private static Object[] paramsKey;//TG.INST_ADDR = ?<有序存储>
    private static Object[] paramsVal; //TG.INST_ADDR = ?普通参数数组<有序存储>
    private static Object[] page;   //分页参数<有序存储>

    public static String getSql() {
        return sql;
    }

    public static void setSql(String sql) {
        table.sql = sql;
    }

    public static String getTablename() {
        return tablename;
    }

    public static void setTablename(String tablename) {
        table.tablename = tablename;
    }

    public static Object[] getParamsKey() {
        return paramsKey;
    }

    public static void setParamsKey(Object[] paramsKey) {
        table.paramsKey = paramsKey;
    }

    public static Object[] getParamsVal() {
        return paramsVal;
    }

    public static void setParamsVal(Object[] paramsVal) {
        table.paramsVal = paramsVal;
    }

    public static Object[] getPage() {
        return page;
    }

    public static void setPage(Object[] page) {
        table.page = page;
    }
}
