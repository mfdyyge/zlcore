package utils;

import com.zl.jdbc.pojo.TableFormParams;
import com.zl.jdbc.utils.GetSql;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/12. 通过map取得sql语句
 */
public class GetSql_test
{
    private String tableName = "emp";

    private static Map<String, String> map = new HashMap<String, String>();

    //初始化MAP

    public static void initMap() {

        map.put("TG.TG_NO", "1155");

        map.put("TG.ORG_NO", null);

        map.put("TG.TG_CAP", "555");

        map.put("TG.INST_ADDR", "大钟寺1号");
        map.put("pageNum","3");
        map.put("pageSize","5");

    }

    public static void main(String[] args)
    {

        initMap();

        String sql;
        //sql = getSqlFromMap(map);
        sql= GetSql.getSqlFromMap(map);
        System.out.println("utils: " + sql);
        System.out.println("paramers = " + Arrays.asList(GetSql.getArryFromMap(map)));
        //getTableFromMap(map);
        TableFormParams tableFormParams=GetSql.getTableFormParams_FromMap_oracle(map,"USERS","pageNum","pageSize");
        System.out.println("tableFormParams.getSql_add() = " + tableFormParams.getSql_add());
    }



}



