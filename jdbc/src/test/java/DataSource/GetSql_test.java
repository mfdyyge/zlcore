package DataSource;

import com.zl.core.base.map.utilMap;
import com.zl.core.base.string.utilString;
import com.zl.core.jdbc.sql.pojo.TableFormParams;
import com.zl.core.jdbc.utilSqlGenerator;

import org.junit.Test;

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
    static Map map = new HashMap();
    static {

        map.put("TG.TG_NO", "1155");

        map.put("TG.ORG_NO", null);
        map.put(null, "key=null");

        map.put("TG.TG_CAP", "555");

        map.put("TG.INST_ADDR", "大钟寺1号");
        map.put("pageNum","3");
        map.put("pageSize","5");


    }

@Test
public void  get_add_sql()
{
    String values= utilSqlGenerator.getSql_Insert("user",map);
    System.out.println("insert = " + values);
   // beanutils;

}


    @Test
    public  void getsql()
    {

        //initMap();

        String sql;
        Object[] keys =  utilMap.getKey(map);

        String name=null,name1="",name2,name3="a";

        System.out.println(" name= " + utilString.isNull(name) );
        System.out.println("name1 = " + utilString.isNull(name1));
        //System.out.println("name2 = " + utilString.isNull(name2));
        System.out.println("name3 = " + utilString.isNull(name3));
        System.out.println("name3 = " + utilString.isNotNull(name3));

        System.out.println("map.entrySet().toArray().toString() = " + map.entrySet().toString());;


        System.out.println("map = " + map);
        utilMap.removeNullValue(map);
        System.out.println(map);

        //sql= SqlGenerator.getSqlFromMap("",map);
        System.out.println("apche.dbutils.test.utils: " + Arrays.asList(map.keySet().toArray()));
        System.out.println("apche.dbutils.test.utils: " + Arrays.asList(map.values().toArray()));

        //System.out.println("paramers = " + utilArrays.asList(SqlGenerator.getArryFromMap(map)));
        //getTableFromMap(map);
        TableFormParams tableFormParams= utilSqlGenerator.getTableFormParams_FromMap_oracle("USERS",map,"pageNum","pageSize");
        System.out.println("tableFormParams.getSql_add() = " + tableFormParams.getSql_add());
    }

    @Test
    public void test_properties(){
        String str=new String("12453452176876145234521277856889");
        String s2=str;
        s2.replaceAll(" ","1");
        System.out.println("s2 = " + s2);
        System.out.println("utilString.isNotNull(str) = " + utilString.isNull(str));
        System.out.println("utilString.isNotNull(str) = " + utilString.isNotNull(str));
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

        utilMap.removeNullKey(map);
        System.out.println();
        System.out.println(map);

        utilMap.removeNullValue(map);
        System.out.println();
        System.out.println(map);
    }
}



