package DataSource;

import com.zl.core.base.map.MapUtil;
import com.zl.core.base.string.StringUtil;
import com.zl.core.jdbc.sqlutil;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by Administrator on 2017/8/12. 通过map取得sql语句
 */
public class GetSql_test
{
    //protected static Logger logger = Logger.getLogger();

    private String tableName = "emp";



    @Test
    public  void getsql()
    {
        Map map = new HashMap();
        map.put("TG.TG_NO", "1155");

        map.put("TG.ORG_NO", null);
        map.put(null, "key=null");

        map.put("TG.TG_CAP", "555");

        map.put("TG.INST_ADDR", "大钟寺1号");
        map.put("pageNum","3");
        map.put("pageSize","5");


        //initMap();

        String sql;
        Object[] keys =  MapUtil.getKey(map);

        String name=null,name1="",name2,name3="a";

        System.out.println(" name= " + StringUtil.isNull(name) );
        System.out.println("name1 = " + StringUtil.isNull(name1));
        //System.out.println("name2 = " + StringUtil.isNull(name2));
        System.out.println("name3 = " + StringUtil.isNull(name3));
        System.out.println("name3 = " + StringUtil.isNotNull(name3));

        System.out.println("map.entrySet().toArray().toString() = " + map.entrySet().toString());;


        System.out.println("map = " + map);
        MapUtil.removeNullValue(map);
        System.out.println(map);

        //sql= SqlGenerator.getSqlFromMap("",map);
        System.out.println("apche.dbutils.test.utils: " + Arrays.asList(map.keySet().toArray()));
        System.out.println("apche.dbutils.test.utils: " + Arrays.asList(map.values().toArray()));

        //System.out.println("paramers = " + Arrays.asList(SqlGenerator.getArryFromMap(map)));
        //getTableFromMap(map);
        //TableFormParams tableFormParams= SqlGenerator.getTableFormParams_FromMap_oracle(map,"USERS","pageNum","pageSize");
       // System.out.println("tableFormParams.getSql_add() = " + tableFormParams.getSql_add());
    }

    @Test
    public void test_properties(){
        String str=new String("12453452176876145234521277856889");
        String s2=str;
        s2.replaceAll(" ","1");
        System.out.println("s2 = " + s2);
        System.out.println("StringUtil.isNotNull(str) = " + StringUtil.isNull(str));
        System.out.println("StringUtil.isNotNull(str) = " + StringUtil.isNotNull(str));
    }


    @Test
    public void  testMap()
    {
        Map map = new HashMap();
        map.put("TG.TG_NO", "1155");

        map.put("TG.ORG_NO", null);
        map.put(null, "key=null");

        map.put("TG.TG_CAP", "555");

        map.put("TG.INST_ADDR", "大钟寺1号");
        map.put("pageNum","3");
        map.put("pageSize","5");

        System.out.println(map);

        MapUtil.removeNullKey(map);
        System.out.println();
        System.out.println(map);

        MapUtil.removeNullValue(map);
        System.out.println();
        System.out.println(map);
    }
}



