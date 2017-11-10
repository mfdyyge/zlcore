package apche.dbutils.test.createTable;

import com.ibatis.common.jdbc.ScriptRunner;
import com.ibatis.common.resources.Resources;
import com.zl.core.jdbc.DataSource.DsFactory;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class CreateTable_test {

    private static DsFactory dsFactory;

    static {
        dsFactory = new DsFactory(null);

    }

    @Test
    public  void Test_NotNull(){

    }
    /**
     * SQL建立表
     *
     * @throws java.sql.SQLException
     */
    @Test
    public void createTable() throws SQLException, Exception {
        int COUNT = 800;
        dsFactory.setAutoCommitFalse();
        Connection connection = dsFactory.getConnection();

        StringBuffer ddl = new StringBuffer();
        ddl.append("CREATE TABLE t_big (FID INT AUTO_INCREMENT PRIMARY KEY ");
        String log_insert = "insert into log (LogName,UserName,Class,Mothod,createTime,LogLevel,MSG) values (?,?,?,?,?,?,?)";

/*
	SqlRuan sqlRuan=new SqlRuan();
		List<String> sqlList = sqlRuan.loadSql("sql/comlog.sql");
		System.out.println("size:" + sqlList.size());
		for (String sql : sqlList) {
			System.out.println(sql);
		}
*/

        ScriptRunner runner = new ScriptRunner();

        runner.setErrorLogWriter(null);
        runner.setLogWriter(null);
        runner.runScript(connection, Resources.getResourceAsReader("sql/comlog.sql"));
        //runner.runScript(connection,Resources.getResourceAsReader("ddl/mysql/jpetstore-mysql-dataload.sql"));

    }
}