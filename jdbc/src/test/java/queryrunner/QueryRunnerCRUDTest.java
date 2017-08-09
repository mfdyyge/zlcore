package queryrunner;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.rowset.serial.SerialClob;

import com.zl.jdbc.DataSource.DsFactory_Druid;
import com.zl.jdbc.apche.dbutils.domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * @ClassName: DBUtilsCRUDTest
 * @Description:使用dbutils框架的QueryRunner类完成CRUD,以及批处理
 * @author: 钢背猪☣
 * @date: 2014-10-5 下午4:56:44
 *
 */
public class QueryRunnerCRUDTest {

	@Test
	public void add() throws SQLException {
		// 将数据源传递给QueryRunner，QueryRunner内部通过数据源获取数据库连接
		QueryRunner qr = new QueryRunner(DsFactory_Druid.getDataSource());
		String sql = "insert into users(name,password,email,birthday) values(?,?,?,?)";
		Object params[] = { "钢背猪☣", "123", "gacl@sina.com", new Date() };
		qr.update(sql, params);
	}

	@Test
	public void delete() throws SQLException {

		QueryRunner qr = new QueryRunner(DsFactory_Druid.getDataSource());
		String sql = "delete from users where id=?";
		qr.update(sql, 1);

	}

	@Test
	public void update() throws SQLException {
		QueryRunner qr = new QueryRunner(DsFactory_Druid.getDataSource());
		String sql = "update users set name=? where id=?";
		Object params[] = { "ddd", 5 };
		qr.update(sql, params);
	}

	@Test
	public void findUserById() throws SQLException {
		QueryRunner qr = new QueryRunner(DsFactory_Druid.getDataSource());
		String sql = "select * from t_user u where u.user_id=?";
		User user = qr.query(sql, new ResultSetHandler<User>() {
			public User handle(ResultSet rs) throws SQLException {
				if (rs.next()) {
					User user = new User();
					user.setUserId(rs.getInt(1));
					user.setUserName(rs.getString("user_name"));
					user.setDesc(rs.getString("desc"));
					return user;
				}
				return null;
			}
		}, new Object[] { 1 });
		System.out.println("findUserById:" + user);
	}

	@Test
	public void findAllUser() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(DsFactory_Druid.getDataSource());
		String sql = "select * from t_user";
		List<User> userList = queryRunner.query(sql,
				new ResultSetHandler<List<User>>() {
					public List<User> handle(ResultSet rs) throws SQLException {
						List<User> userList = Lists.newArrayList();
						while (rs.next()) {
							User user = new User();
							user.setUserId(rs.getInt(1));
							user.setUserName(rs.getString("user_name"));
							user.setDesc(rs.getString("desc"));
							userList.add(user);
						}
						return userList;
					}

				});
		System.out.println("userList: " + userList);
	}

	/**
	 * @Method: testBatch
	 * @Description:批处理
	 * @Anthor:钢背猪☣
	 *
	 * @throws SQLException
	 */
	@Test
	public void testBatch() throws SQLException {
		QueryRunner qr = new QueryRunner(DsFactory_Druid.getDataSource());
		String sql = "insert into users(name,password,email,birthday) values(?,?,?,?)";
		Object params[][] = new Object[10][];
		for (int i = 0; i < 10; i++) {
			params[i] = new Object[] { "aa" + i, "123", "aa@sina.com",
					new Date() };
		}
		qr.batch(sql, params);
	}

	@Test
	public void testclob() throws SQLException, IOException {
		QueryRunner runner = new QueryRunner(DsFactory_Druid.getDataSource());
		String sql = "insert into testclob(resume) values(?)"; // clob
		// 这种方式获取的路径，其中的空格会被使用“%20”代替
		String path = QueryRunnerCRUDTest.class.getClassLoader()
				.getResource("data.txt").getPath();
		// 将“%20”替换回空格
		path = path.replaceAll("%20", " ");
		FileReader in = new FileReader(path);
		char[] buffer = new char[(int) new File(path).length()];
		in.read(buffer);
		SerialClob clob = new SerialClob(buffer);
		Object params[] = { clob };
		runner.update(sql, params);
	}
}
