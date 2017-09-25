package apche.dbutils.test.DataSource;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLObject;
import com.alibaba.druid.sql.dialect.oracle.ast.OracleSQLObjectImpl;
import com.alibaba.druid.sql.dialect.oracle.visitor.OracleASTVisitor;
import com.zl.core.jdbc.DataSource.DsFactory;
import com.zl.core.jdbc.apche.dbutils.dao.SqlDao;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.sql.Connection;
import java.util.Arrays;
import java.util.ResourceBundle;

/**
 * Created by 钢背猪☣ on 2017-8-7 0007.
 *
 * @ClassName: apche.dbutils.test.queryrunner
 * @Description: 描述:474752515@qq.com
 * @author: 钢背猪☣
 * @date: 2017-8-7 0007
 */
public class Test_DataSourceFactory
{
    protected static Logger logger = Logger.getLogger(Test_DataSourceFactory.class);


    private StringBuffer msg;


    static String getUserTypeTreeSql = "select level depth, parent_type, child_type, ATTR_NO, child_type_owner from  (select TYPE_NAME parent_type, ELEM_TYPE_NAME child_type, 0 ATTR_NO,       ELEM_TYPE_OWNER child_type_owner     from USER_COLL_TYPES  union   select TYPE_NAME parent_type, ATTR_TYPE_NAME child_type, ATTR_NO,       ATTR_TYPE_OWNER child_type_owner     from USER_TYPE_ATTRS  ) start with parent_type  = ?  connect by prior  child_type = parent_type";
    String sqlHint = null;
    static String getAllTypeTreeSql = "select parent_type, parent_type_owner, child_type, ATTR_NO, child_type_owner from ( select TYPE_NAME parent_type,  OWNER parent_type_owner,     ELEM_TYPE_NAME child_type, 0 ATTR_NO,     ELEM_TYPE_OWNER child_type_owner   from ALL_COLL_TYPES union   select TYPE_NAME parent_type, OWNER parent_type_owner,     ATTR_TYPE_NAME child_type, ATTR_NO,     ATTR_TYPE_OWNER child_type_owner   from ALL_TYPE_ATTRS ) start with parent_type  = ?  and parent_type_owner = ? connect by prior child_type = parent_type   and ( child_type_owner = parent_type_owner or child_type_owner is null )";


    private static DsFactory dsFactory;
    static ResourceBundle resourceBundle;
    static
    {
        dsFactory=new DsFactory();
        resourceBundle=ResourceBundle.getBundle("sql/comlog.sql");

    }



    @Test
    public void  DsFactory_test()
    {
/*        logger.error("DsFactoryTest()");
        logger.debug("test error");*/

        //logger.info(MDC.getContext());


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
        Connection connection= dsFactory.getConnection();
/*        logger.info(sql_a);
        logger.info(sql_b);

        logger.info(new StringBuffer("行>getConnection = ").append(connection));

        Object result[]=SqlDao.getFirstRowArray(connection,sql_a);
        logger.info(new StringBuffer("行>").append(Arrays.asList(result)));

        Object result_2[]=SqlDao.getFirstRowArray(connection,sql_b);
        logger.info(new StringBuffer("行>").append(Arrays.asList(result_2)));*/


    }

    @Test
    public void test_Dao()
    {

        String sql = "select * from jpa_persons where id like ? ";
        Object [] params = new Object[]{"%4%"};


        //System.out.println("getDataSource = " + DsFactory.getDataSource());
        Connection connection= dsFactory.getConnection();
        logger.info(connection);

        Object result[]= SqlDao.getFirstRowArray(connection,sql,params);
        logger.info(Arrays.asList(result));

    }


    /*测试DsFactory*/
    @Test
    public  void  DsFactory()
    {
        System.out.println("DsFactory.getDataSource = " + dsFactory.getDataSource());

        DsFactory dsFactory1=new DsFactory("db1");
        Connection connection_db1=dsFactory1.getConnection();
        Connection connection    =dsFactory.getConnection();

        System.out.println("DsFactory.Connection = " + connection_db1);

        System.out.println("Connection = " + dsFactory1.isValid());
        System.out.println("connection = " + dsFactory1.isValid(connection_db1));

        System.out.println("connection.hashCode()  = " + connection.hashCode());
        System.out.println("connection_db1.hashCode() = " +connection_db1.hashCode());


        //判断两个Connection 是否相等
        System.out.println("connection == connection_db1 >" + connection.equals(connection_db1));
    }


    /**
     * Druid.SQLUtuils
     */
    @Test
    public void  oracle_SQLUtils()
    {

        oracle.sql.SQLUtil sqlUtil=new oracle.sql.SQLUtil();

    }

    /**
     * Druid.SQLUtuils
     */
    @Test
    public void  druid_SQLUtils()
    {
        SQLObject toOracleString = new OracleSQLObjectImpl()
        {
            @Override
            public void accept0(OracleASTVisitor oracleASTVisitor)
            {

            }
        };

        SQLUtils.toOracleString(toOracleString);
    }



}
