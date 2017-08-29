package DataSource;

import com.zl.jdbc.DataSource.DsFactory;
import com.zl.jdbc.JDBCDatabase;
import com.zl.jdbc.JDBCSchema;
import com.zl.jdbc.JDBCTable;
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

    //数据库对象
    @Test
    public  void JDBCDatabase_test()
    {
        Connection connection=DsFactory.getConnection();
        JDBCDatabase jdbcDatabase= new JDBCDatabase(connection);
        System.out.println("数据库对象>jdbcDatabase.getSchemaCount = " + jdbcDatabase.getSchemaCount());

    }

    //数据库用户对象－或者说－数据库命名空间
    @Test
    public  void JDBCSchema_test()
    {
        Connection connection=DsFactory.getConnection();
        JDBCDatabase jdbcDatabase= new JDBCDatabase(connection);
        String dbName=jdbcDatabase.getSchemaName(0);

        JDBCSchema jdbcSchema=new JDBCSchema(connection,jdbcDatabase,dbName);
        System.out.println("数据库用户>all> jdbcSchema.getTableCount = " + jdbcSchema.getTableCount());



        JDBCSchema jdbcSchema_jpa=new JDBCSchema(connection,jdbcDatabase,dbName);
        System.out.println("数据库用户>jpa> jdbcSchema.getTableCount = " + jdbcSchema_jpa.getTableCount());

    }

    //数据库表对象
    @Test
    public  void JDBCTable_test()
    {
        Connection connection=DsFactory.getConnection();
        JDBCDatabase jdbcDatabase= new JDBCDatabase(connection);
        JDBCSchema jdbcSchema=new JDBCSchema(connection,jdbcDatabase,"JPA");

        JDBCTable jdbcTable= new JDBCTable(connection,jdbcSchema,"jpa_persons");

        System.out.println("数据库表对象> jdbcSchema.getColumnCount = " + jdbcTable.getColumnCount());

    }

}
