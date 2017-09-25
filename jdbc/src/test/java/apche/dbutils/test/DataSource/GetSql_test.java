package apche.dbutils.test.DataSource;

import com.zl.core.jdbc.SqlGenerator;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/12. 通过map取得sql语句
 */
public class GetSql_test
{
    //protected static Logger logger = Logger.getLogger();

    private String tableName = "emp";

    private static Map<String, Object> map = new HashMap<String, Object>();

    //初始化MAP

    public static void initMap() {

        map.put("TG.TG_NO", "1155");

        map.put("TG.ORG_NO", null);

        map.put("TG.TG_CAP", "555");

        map.put("TG.INST_ADDR", "大钟寺1号");
        map.put("pageNum","3");
        map.put("pageSize","5");

    }

    @Test
    public  void getsql()
    {

        initMap();

        String sql;
        //sql = getSqlFromMap(map);

        sql= SqlGenerator.getSqlFromMap("",map);
        System.out.println("apche.dbutils.test.utils: " + sql);

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
    }


}



