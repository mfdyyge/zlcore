package DataSource;

import com.zl.jdbc.DataSource.DsFactory;
import com.zl.jdbc.JDBCDatabase;
import com.zl.jdbc.JDBCSchema;
import com.zl.jdbc.JDBCTable;
import com.zl.jdbc.db.Column;
import org.junit.Test;

import java.sql.Connection;

/**
 * Created by 钢背猪☣ on 2017-8-30 0030.
 *
 * @ClassName: DataSource
 * @Description: 描述:474752515@qq.com
 * @author: 钢背猪☣
 * @date: 2017-8-30 0030
 */
public class JdbcSchema
{
   private static DsFactory dsFactory;
   private static Connection connection;

   static
   {
       dsFactory=new DsFactory();
       connection=dsFactory.getConnection();
   }
    //数据库对象
    @Test
    public  void JDBCDatabase_test()
    {


        JDBCDatabase jdbcDatabase= new JDBCDatabase(connection);
        System.out.println("数据库对象>jdbcDatabase.getSchemaCount = " + jdbcDatabase.getSchemaCount());

    }

    //数据库用户对象－或者说－数据库命名空间
    @Test
    public  void JDBCSchema_test()
    {

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

        JDBCDatabase jdbcDatabase= new JDBCDatabase(connection);
        JDBCSchema jdbcSchema=new JDBCSchema(connection,jdbcDatabase,"JPA");

        JDBCTable jdbcTable= new JDBCTable(connection,jdbcSchema,"zy");

        System.out.println("数据库表对象> jdbcSchema.getColumnCount = " + jdbcTable.getColumnCount());
        //ColumnImpl[] columns= (ColumnImpl[])
        Column[]            A_columns=jdbcTable.getColumns();
        System.out.println("A_columns[0].toString() = " + A_columns[0].toString());
        System.out.println(" 字段类型 = " +  A_columns[0].getDataType());
        System.out.println(">>>> (columns)= " + A_columns[0].getName());
       // System.out.println("数据库表对象> j Arrays.asList(columns)= " + Arrays.asList(columns));

    }



}
