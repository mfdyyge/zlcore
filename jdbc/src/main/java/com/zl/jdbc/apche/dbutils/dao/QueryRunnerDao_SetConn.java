package com.zl.jdbc.apche.dbutils.dao;

import com.zl.jdbc.apche.dbutils.util.MapUtil;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author	钢背猪☣
 * @version 2017年8月7日
 *
 */
/**
 * @author: 	钢背猪☣
 * @ClassName: 	DBUtilsCRUDTest
 * @Description:使用dbutils框架的-利用DBUtils对JDBC一次完整的封装
 * @date: 		2014-10-5 下午4:56:44
 * @version 	2017年8月7日
 *
 */
public class QueryRunnerDao_SetConn {

	private static final QueryRunner runner=new QueryRunner() ;

	/**
	 * @Description:查询（返回Array结果）
	 * @param conn
	 * @param sql
	 * @param params
	 * @return
	 */
	public static Object[] queryArray(Connection conn, String sql, Object... params)
	{
		Object[] result = null;
		try {
			result = runner.query(conn, sql, new ArrayHandler(), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 查询（返回ArrayList结果）
	 * @param conn
	 * @param sql
	 * @param params
	 * @return
	 */
	public static List<Object[]> queryArrayList(Connection conn, String sql, Object... params)
	{
		List<Object[]> result = null;
		try {
			result = runner.query(conn, sql, new ArrayListHandler(), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 查询（返回Map结果）
	 * @param conn
	 * @param sql
	 * @param params
	 * @return
	 */
	public static Map<String, Object> queryMap(Connection conn, String sql, Object... params)
	{
		Map<String, Object> result = null;
		try {
			result = runner.query(conn, sql, new MapHandler(), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 查询（返回MapList结果）
	 * @param conn
	 * @param sql
	 * @param params
	 * @return
	 */
	public static List<Map<String, Object>> queryMapList(Connection conn, String sql, Object... params)
	{
		List<Map<String, Object>> result = null;
		try {
			result = runner.query(conn, sql, new MapListHandler(), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 查询（返回Bean结果）
	 * @param cls
	 * @param map
	 * @param conn
	 * @param sql
	 * @param params
	 * @param <T>
	 * @return
	 */
	public static <T> T queryBean(Connection conn,Class<T> cls, Map<String, String> map,  String sql, Object... params)
	{
		T result = null;
		try {
			if (MapUtil.isNotEmpty(map)) {
				result = runner.query(conn, sql,
						new BeanHandler<T>(cls, new BasicRowProcessor(new BeanProcessor(map))), params);
			} else {
				result = runner.query(conn, sql, new BeanHandler<T>(cls), params);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 查询（返回BeanList结果）
	 * @param cls
	 * @param map
	 * @param conn
	 * @param sql
	 * @param params
	 * @param <T>
	 * @return
	 */
	public static <T> List<T> queryBeanList(Connection conn,Class<T> cls, Map<String, String> map,  String sql,	Object... params)
	{
		List<T> result = null;
		try {
			if (MapUtil.isNotEmpty(map)) {
				result = runner.query(conn, sql, new BeanListHandler<T>(cls, new BasicRowProcessor(new BeanProcessor(map))), params);
			} else {
				result = runner.query(conn, sql, new BeanListHandler<T>(cls), params);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 查询指定列名的值（单条数据）
	 * @param column
	 * @param conn
	 * @param sql
	 * @param params
	 * @param <T>
	 * @return
	 */
	public static <T> T queryColumn(Connection conn,   String sql,String column, Object... params)
	{
		T result = null;
		try {
			result = runner.query(conn, sql, new ScalarHandler<T>(column), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 查询指定列名的值（多条数据）
	 * @param column
	 * @param conn
	 * @param sql
	 * @param params
	 * @param <T>
	 * @return
	 */
	public static <T> List<T> queryColumnList(Connection conn,String column,   String sql, Object... params)
	{
		List<T> result = null;
		try {
			result = runner.query(conn, sql, new ColumnListHandler<T>(column), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 查询指定列名对应的记录映射
	 * @param column
	 * @param conn
	 * @param sql
	 * @param params
	 * @param <T>
	 * @return
	 */
	public static <T> Map<T, Map<String, Object>> queryKeyMap(Connection conn,String column,  String sql,Object... params)
	{
		Map<T, Map<String, Object>> result = null;
		try {
			result = runner.query(conn, sql, new KeyedHandler<T>(column), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 *  更新（包括UPDATE、INSERT、DELETE，返回受影响的行数） \n
	 *  注意: 此方法需要用到DataSouce_Factory里面的回滚事务
	 * @param conn
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public static int update(Connection conn, String sql, Object... params) throws SQLException
	{
		int result = 0;

			result = runner.update(conn, sql, params);

		return result;
	}
}