package DataSource;

import com.zl.jdbc.DataSource.DsFactory;
import com.zl.jdbc.apche.dbutils.dao.QueryRunnerDao;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.sql.Connection;
import java.util.Arrays;

/**
 * Created by 钢背猪☣ on 2017-8-7 0007.
 *
 * @ClassName: queryrunner
 * @Description: 描述:474752515@qq.com
 * @author: 钢背猪☣
 * @date: 2017-8-7 0007
 */
public class Test_DataSourceFactory
{
    protected static Logger logger = Logger.getLogger(Test_DataSourceFactory.class);

    private static DsFactory dsFactory;
    private StringBuffer msg;


    static
    {
        dsFactory=new DsFactory();

    }



    @Test
    public void  DsFactory_test()
    {
        //logger.info("test error");
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


        Object [] params = new Object[]{"%4%"};


        //System.out.println("getDataSource = " + DsFactory.getDataSource());
        Connection connection= dsFactory.getConnection();
        logger.info(new StringBuffer("行>getConnection = ").append(connection));

        Object result[]=QueryRunnerDao.getFirstRowArray(connection,sql_a);
        logger.info(new StringBuffer("行>").append(Arrays.asList(result)));

        Object result_2[]=QueryRunnerDao.getFirstRowArray(connection,sql_b);
        logger.info(new StringBuffer("行>").append(Arrays.asList(result_2)));

    }

    @Test
    public void test_Dao()
    {

        String sql = "select * from jpa_persons where id like ? ";
        Object [] params = new Object[]{"%4%"};


        //System.out.println("getDataSource = " + DsFactory.getDataSource());
        Connection connection= dsFactory.getConnection();
        logger.info(connection);

        Object result[]=QueryRunnerDao.getFirstRowArray(connection,sql,params);
        logger.info(Arrays.asList(result));

    }


    /*测试DsFactory*/
    @Test
    public  void  DsFactory()
    {
        System.out.println("DsFactory.getDataSource = " + dsFactory.getDataSource());

        DsFactory dsFactory1=new DsFactory("db1");
        Connection connection=dsFactory1.getConnection();


        System.out.println("DsFactory.Connection = " + connection);

        System.out.println("Connection = " + dsFactory1.isValid());
        System.out.println("connection = " + dsFactory1.isValid(connection));

        System.out.println("connection = " + connection.hashCode());
        System.out.println("DsFactory.getConnection().hashCode() = " + dsFactory1.getConnection().hashCode());


        //判断两个Connection 是否相等
        System.out.println("connection =threadLocal.get(Connection) " + connection.equals(dsFactory1.getConnection()));
    }


}
