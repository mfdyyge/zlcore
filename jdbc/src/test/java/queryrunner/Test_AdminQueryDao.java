package queryrunner;

import com.zl.jdbc.DataSource.DsFactory_Druid;
import com.zl.jdbc.apche.dbutils.dao.QueryRunnerDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: Test_AdminQueryDao
 * @Description:测试dbutils各种类型的处理器
 * @author: 钢背猪☣
 * @date: 2014-10-6 上午8:39:14
 *
 */
public class Test_AdminQueryDao {

	//AdminQueryDao


	@Test
	public void test_AdminDao()
	{
/*		String sql = "select * from jpa_persons where id=? and add_id=?";
		Object [] params = new Object[]{"43","98"};

		Object result[] = (Object[]) AdminQueryDao.queryArray(sql,params);
		System.out.println(Arrays.asList(result));
		*/

		String sql = "select * from jpa_persons where id like ? ";
		Object [] params = new Object[]{"%4%"};

		/*
		Object result[] = (Object[]) AdminQueryDao.queryArray(sql,params);
		System.out.println(Arrays.asList(result));
		*/
	}

	/**
	 * 只查出一条记录
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testArrayHandler() throws SQLException
	{
		//QueryRunner query_apc = new QueryRunner(JdbcUtils.getDataSource());
		QueryRunner query_apc = new QueryRunner(DsFactory_Druid.getDataSource());
		String sql = "select * from jpa_persons";
		Object result[] = (Object[]) query_apc.query(sql, new ArrayHandler());
		System.out.println(Arrays.asList(result)); // list toString()
	}

	@Test
	public void testArrayListHandler() throws SQLException
	{
		//
		QueryRunner query_apc = new QueryRunner(DsFactory_Druid.getDataSource());

		//顺序读取数据表的内容
		String sql = "select * from jpa_persons";
		List<Object[]> list = (List) query_apc.query(sql, new ArrayListHandler());
		for (Object[] o : list) {
			System.out.println(Arrays.asList(o));
		}
	}

	@Test
	public void testColumnListHandler() throws SQLException
	{
		//查询指定列|或者说表中的某个"单列"
		QueryRunner query_apc = new QueryRunner(DsFactory_Druid.getDataSource());

		String sql = "select * from jpa_persons";
		List list_id = (List) query_apc.query(sql, new ColumnListHandler("id"));
		System.out.println(list_id);
		List list_addid = (List) query_apc.query(sql, new ColumnListHandler("add_id"));
		System.out.println(list_addid);
	}

	@Test
	public void testKeyedHandler() throws Exception
	{
		QueryRunner query_apc = new QueryRunner(DsFactory_Druid.getDataSource());
		String sql = "select * from jpa_persons";

		Map<Integer, Map> map = (Map) query_apc.query(sql, new KeyedHandler("add_id"));
		for (Map.Entry<Integer, Map> me : map.entrySet()) {
			int id = me.getKey();
			Map<String, Object> innermap = me.getValue();
			for (Map.Entry<String, Object> innerme : innermap.entrySet()) {
				String columnName = innerme.getKey();
				Object value = innerme.getValue();
				System.out.println(columnName + "=" + value);
			}
			System.out.println("----------------");
		}
	}

	@Test
	public void testMapHandler() throws SQLException {

		QueryRunner query_apc = new QueryRunner(DsFactory_Druid.getDataSource());
		String sql = "select * from jpa_persons";

		Map<String, Object> map = (Map) query_apc.query(sql, new MapHandler());
		for (Map.Entry<String, Object> me : map.entrySet()) {
			System.out.println(me.getKey() + "=" + me.getValue());
		}
	}

	@Test
	public void testMapListHandler() throws SQLException
	{
		QueryRunner query_apc = new QueryRunner(DsFactory_Druid.getDataSource());

		String sql = "select * from jpa_persons";
		List<Map> list = (List) query_apc.query(sql, new MapListHandler());
		for (Map<String, Object> map : list)
		{
			for (Map.Entry<String, Object> me : map.entrySet())
			{
				System.out.println(me.getKey() + "=" + me.getValue());
			}
		}
	}

	@Test
	public void testScalarHandler() throws SQLException
	{
		QueryRunner query_apc = new QueryRunner();
		Connection connection=DsFactory_Druid.getConnection();

		String sql = "select count(id) from jpa_persons"; // [13] list[13]
		//int count = ((Long) query_apc.query(connection,sql, new ScalarHandler(1))).intValue();
		int count= QueryRunnerDao.getCount(connection,sql);
		System.out.println(count);
	}
}