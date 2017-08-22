package DataSource;

import com.zl.jdbc.DataSource.DsFactory;
import com.zl.jdbc.apche.dbutils.dao.QueryRunnerDao;
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
    @Test
    public void test_Dao()
    {

        String sql = "select * from jpa_persons where id like ? ";
        Object [] params = new Object[]{"%4%"};


        //System.out.println("getDataSource = " + DsFactory.getDataSource());
        Connection connection= DsFactory.getConnection();
        System.out.println("getConnection = " + connection);

        Object result[]=QueryRunnerDao.getFirstRowArray(connection,sql,params);
        System.out.println(Arrays.asList(result));

    }


    /*测试DsFactory*/
    @Test
    public  void  DsFactory()
    {
        System.out.println("DsFactory.getDataSource = " + DsFactory.getDataSource());

        Connection connection=DsFactory.getConnection();

        System.out.println("DsFactory.Connection = " + connection);

        System.out.println("Connection = " + DsFactory.isValid());
        System.out.println("connection = " + DsFactory.isValid(connection));

        System.out.println("connection = " + connection.hashCode());
        System.out.println("DsFactory.getConnection().hashCode() = " + DsFactory.getConnection().hashCode());


        //判断两个Connection 是否相等
        System.out.println("connection =threadLocal.get(Connection) " + connection.equals(DsFactory.getConnection()));
    }
}
