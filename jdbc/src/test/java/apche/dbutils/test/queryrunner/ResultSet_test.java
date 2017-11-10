package apche.dbutils.test.queryrunner;

import com.zl.core.jdbc.DataSource.DsFactory;
import com.zl.core.jdbc.apche.dbutils.dao.SqlDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.KeyedHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ResultSet_test
{
    protected static Logger logger = Logger.getLogger(ResultSet_test.class);


    private static DsFactory JdbcUtils;
    private static Connection connection=null;


    static {
        JdbcUtils=new DsFactory("dbjpa");
        connection=JdbcUtils.getConnection();
    }

    @Test
    public  void  test_DsFactory(){

        //JdbcUtils.getDataSource();

    }


    //查找月的第一天,最后一天
    @Test
    public  void  getFrist()
    {

        String sql_a=   "SELECT "+
                "to_char(Trunc(Trunc(SYSDATE, 'MONTH') - 1, 'MONTH'), 'YYYY-MM-DD')  as 当月第一天, "+
                "to_char(Trunc(SYSDATE, 'MONTH') - 1 / 86400, 'YYYY-MM-DD')	         as 当月最后一天 "+
                "FROM dual ";

        String sql_b=   "SELECT "+
                "to_char(Trunc(SYSDATE, 'MONTH'), 'YYYY-MM-DD') as 后月第一天, "+
                "to_char(LAST_DAY(Trunc(SYSDATE, 'MONTH')) + 1 - 1 / 86400, 'YYYY-MM-DD') as 后月最后一天 "+
                "FROM dual ";
        String log_insert="insert into log (LogName,UserName,Class,Mothod,createTime,LogLevel,MSG) values (?,?,?,?,?,?,?)";


        Object [] params = new Object[]{"%4%"};


        //System.out.println("getDataSource = " + DsFactory.getDataSource());
        Connection connection= JdbcUtils.getConnection();
        logger.info(sql_a);
        logger.info(sql_b);
/*
        logger.info(new StringBuffer("行>getConnection = ").append(connection));
*/
        Object result[]= SqlDao.getFirstRowArray(connection,sql_a);
        logger.info(new StringBuffer("行>").append(Arrays.asList(result)));

        Object result_2[]=SqlDao.getFirstRowArray(connection,sql_b);
        logger.info(new StringBuffer("行>").append(Arrays.asList(result_2)));


    }

    @Test// (1) ArrayHandler( )：把结果集中的第一行数据转成对象数组。
    public void ArrayHandler_test() throws SQLException {
        QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "select * from users where id=?";
        String sql_a=   "SELECT "+
                "to_char(Trunc(Trunc(SYSDATE, 'MONTH') - 1, 'MONTH'), 'YYYY-MM-DD')  as 当月第一天, "+
                "to_char(Trunc(SYSDATE, 'MONTH') - 1 / 86400, 'YYYY-MM-DD')	         as 当月最后一天 "+
                "FROM dual ";

        //Object result[] = (Object[]) runner.query(sql_a,1, new ArrayHandler());
        Object result[] = (Object[]) runner.query(sql,"20170925183217017", new ArrayHandler());

        System.out.println("Arrays.asList(result)) = " + Arrays.asList(result));
        //System.out.println(result[0]);
        //System.out.println(result[1]);
    }

    @Test
    public void ArrayListHandler_test2() throws SQLException{
        QueryRunner runner = new QueryRunner();
        String sql = "select * from users";
        List list = (List) runner.query(JdbcUtils.getConnection(),sql, new ArrayListHandler());
        System.out.println(list);
    }

    @Test
    public void ColumnListHandler1_test3() throws SQLException{
        QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "select * from users";
        List list = (List) runner.query(sql, new ColumnListHandler1("name"));
        System.out.println(list);
    }

    @Test
    public void KeyedHandler_test4() throws SQLException{
        QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "select * from users";
        Map<String,Map<String,Object>> map = (Map) runner.query(sql, new KeyedHandler("id"));
        for(Map.Entry<String,Map<String,Object>> me : map.entrySet()){
            String id = me.getKey();
            for(Map.Entry<String, Object> entry : me.getValue().entrySet()){
                String name = entry.getKey();
                Object value = entry.getValue();
                System.out.println(name + "=" + value);
            }
        }
    }

    @Test  //获取总记录数。
    public void ScalarHandler_test5() throws SQLException{
        QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "select count(*) from users";
    /* 方式一：
    Object result[] = (Object[]) runner.query(sql, new ArrayHandler());
    long totalrecord = (Long)result[0];
    int num = (int)totalrecord;
    System.out.println(num);
    int totalrecord = ((Long)result[0]).intValue();
    */

        //方式二：
        int totalrecord = ((Long)runner.query(sql, new ScalarHandler(1))).intValue();
        System.out.println(totalrecord);
    }
}
//自定义
class ColumnListHandler1 implements ResultSetHandler {
    private String columnName;
    public ColumnListHandler1(String columnName){
        this.columnName = columnName;
    }
    public Object handle(ResultSet rs) throws SQLException {
        List list = new ArrayList();
        while(rs.next()){
            list.add(rs.getObject(columnName));
        }
        return list;
    }
}