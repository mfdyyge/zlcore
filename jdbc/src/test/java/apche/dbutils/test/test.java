package apche.dbutils.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.zl.core.base.json.Random;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.KeyedHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

public class test
{

@SuppressWarnings("unchecked")
public static void main(String[] args) throws ClassNotFoundException {

        McUserField userField =new McUserField();

        Connection conn =null;
        String jdbcURL ="jdbc:oracle:thin:@localhost:1521:orcl";
        String jdbcDriver ="oracle.jdbc.driver.OracleDriver";
        try
        {
        DbUtils.loadDriver(jdbcDriver);
        conn = DriverManager.getConnection(jdbcURL, "jpa", "jpa");
        conn.setAutoCommit(false);//关闭自动提交
        QueryRunner qRunner =new QueryRunner();

        // 以下部分代码插入一条数据
                Random s1 = new Random();
               Integer rdsj=new Integer(s1.GeneratePassworrd(4));
                System.out.println("***Insert begin*** rdsj="+rdsj);


                userField =new McUserField();
                qRunner.update(conn, "insert into mc_user_field ("
                        +"id,name,sort_order,required,visible)"
                        +"values (?,?,?,?,?)", new Object[] { rdsj,
                        userField.getName(),
                        userField.getSortOrder(), userField.getRequired(),
                        userField.getVisible() });
                System.out.println("***Insert end***");
/*
         // 以下部分代码更新一条数据
                System.out.println("***update begin***");
                userField =new McUserField();
                qRunner.update(conn, "update mc_user_field set "+"name = ?,sort_order = ?,"+"required = ?,visible = ?"+"where id = ?",new Object[] { userField.getName(),
                        userField.getSortOrder(), userField.getRequired(),
                        userField.getVisible(), userField.getId() });
                System.out.println("***update end***");*/

                // 以下部分代码采用MapHandler存储方式查询
                System.out.println("***Using MapHandler***");
                Map map = (Map) qRunner.query(conn,
                "select * from mc_user_field where id = ?",
                new MapHandler(), new Object[] { "5" });

                System.out.println("id ------------- name ");
                System.out.println(map.get("id") +"  ------------- " + map.get("name"));

        // 以下部分代码采用MapListHandler存储方式查询
                System.out.println("***Using MapListHandler***");
                List lMap = (List) qRunner.query(conn,
                "select * from mc_user_field", new MapListHandler());

                System.out.println("id ------------- name ");
                for (int i =0; i < lMap.size(); i++) {
                Map vals = (Map) lMap.get(i);
                System.out.println(vals.get("id") +"  ------------- "
                + vals.get("name"));
                }

        // 以下部分代码采用BeanHandler存储方式查询
                System.out.println("***Using BeanHandler***");
                userField = (McUserField) qRunner.query(conn,"select * from mc_user_field where id = ?",new BeanHandler(Class.forName("cn.lining.test.UserField")),new Object[] { "5" });
                System.out.println("id ------------- name ");
                System.out.println(userField.getId() +"  ------------- " + userField.getName());

        // 以下部分代码采用BeanListHandler存储方式查询
                System.out.println("***Using BeanListHandler***");
                List lBean = (List) qRunner.query(conn,
                "select * from mc_user_field", new BeanListHandler(Class
                .forName("cn.lining.test.UserField")));
                System.out.println("id ------------- name ");
                for (int i =0; i < lBean.size(); i++) {
                userField = (McUserField) lBean.get(i);
                System.out.println(userField.getId() +"  ------------- "
                + userField.getName());
                }

        // 以下部分代码采用ArrayHandler存储方式查询
                System.out.println("***Using ArrayHandler***");
                Object[] array = (Object[]) qRunner.query(conn,
                "select * from mc_user_field where id = ?",
                new ArrayHandler(), new Object[] { "5" });

                System.out.println("id ------------- name ");
                System.out.println(array[0].toString() +"  ------------- "
                + array[1].toString());

        // 以下部分代码采用ArrayListHandler存储方式查询
                System.out.println("***Using ArrayListHandler***");
                List lArray = (List) qRunner.query(conn,
                "select * from mc_user_field", new ArrayListHandler());
                System.out.println("id ------------- name ");
                for (int i =0; i < lArray.size(); i++) {
                Object[] var = (Object[]) lArray.get(i);
                System.out.println(var[0].toString() +"  ------------- "
                + var[1].toString());
                }

        // 以下部分代码采用ColumnListHandler存储方式查询指定列
                System.out.println("***Using ColumnListHandler***");
                List lName = (List) qRunner.query(conn,
                "select * from mc_user_field where id = ?",
                new ColumnListHandler("name"), new Object[] { "5" });
                System.out.println("name ");
                for (int i =0; i < lName.size(); i++) {
                String name = (String) lName.get(i);
                System.out.println(name);
                }

        // 以下部分代码采用ScalarHandler存储方式查询
                System.out.println("***Using ScalarHandler***");
                String name = (String) qRunner.query(conn,
                "select * from mc_user_field where id = ?",
                new ScalarHandler("name"), new Object[] { "5" });

                System.out.println("name ");
                System.out.println(name);

        // 以下部分代码采用KeyedHandler存储方式查询
                System.out.println("***Using KeyedHandler***");
                Map<String, Map> map2 = (Map<String, Map>) qRunner.query(conn,
                "select * from mc_user_field", new KeyedHandler("name"));

                System.out.println("name: field_name2");
                Map vals = (Map) map2.get("field_name2");
                System.out.println(vals.get("id") +""+ vals.get("name") );


        // 以下部分代码删除一条数据
        System.out.println("***delete begin***");
        userField =new McUserField();
        qRunner.update(conn, "delete from mc_user_field where id2 = ?",
        new Object[] { userField.getId() });
        System.out.println("***delete end***");

        }
        catch (SQLException ex) {
        ex.printStackTrace();
        try {
        System.out.println("***rollback begin***");
        DbUtils.rollback(conn);
        System.out.println("***rollback end***");
        } catch (SQLException e) {
        e.printStackTrace();
        }
        } finally {
        DbUtils.closeQuietly(conn);
        }

        }
        }