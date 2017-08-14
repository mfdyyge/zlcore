package com.zl.jdbc.page;

/**
 * Created by Administrator on 2017/8/8.
 * 定义分页查询方法
 */

import com.zl.jdbc.DataSource.DsFactory;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public class QueryRemote {

    // 获得c3p0连接池对象
    private static DataSource ds;

    @SuppressWarnings({
            "unchecked", "rawtypes"
    })
    public static List<Object> query(String sql, Page page, Object[] params, Class<?> clss)
    {
        ds = getResource();
        QueryRunner runner = new QueryRunner(ds);

        List<Object> list = null;
        try {
            sql = sql.toUpperCase();
            if (null == page) {
                list = (List<Object>) runner.query(sql, new BeanListHandler(clss.newInstance().getClass()), params);
            }
            else {
                if (null == params) {
                    params = new Object[]{};
                }
                String pageSql = "SELECT * FROM (SELECT A.*,ROWNUM RN " + "FROM (" + sql + ") A WHERE ROWNUM <=? )  WHERE RN >=?";

                // 查询总数
                String totalSql = "SELECT COUNT(*) FROM (" + sql + ")";
                BigDecimal count = runner.query(totalSql,new ScalarHandler<BigDecimal>(),params);
                page.setTotalSize(count.intValue());
                page.init();

                Object[] pageParams = new Object[params.length + 2];
                System.arraycopy(params, 0, pageParams, 0, params.length);

                pageParams[params.length] = page.getPageEnd();
                pageParams[params.length + 1] = page.getPageBegin();




                list = (List<Object>) runner.query(pageSql, new BeanListHandler(clss.newInstance().getClass()), pageParams);
            }
        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    private static DataSource getResource()
    {
        ds= DsFactory.getDataSource();
        return ds;
    }
}

