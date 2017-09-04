package com.zl.core.jdbc.apche.dbutils.dao;

import com.zl.core.jdbc.apche.dbutils.page.Page;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class QueryRunnerDao {



	/**
	 * 批量操作，包括批量保存、修改、删除
	 * @param connection
	 * @param sql
	 * @param params
	 * @return
	 */
	public static int[] batch(Connection connection, String sql, Object[][] params) {
		try {
			return new QueryRunner().batch(connection, sql, params);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}


	/**
	 * 删除操作
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public static int delete(Connection connection, String sql, Object... params) {
		try {
			return new QueryRunner().update(connection, sql, params);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	/**
	 * 更新操作
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public static int update(Connection connection, String sql, Object... params) {
		try {
			new QueryRunner().update(connection, sql, params);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	/**
	 * 保存操作
	 * @param connection
	 * @param sql
	 * @param params
	 * @return
	 */
	public static int save(Connection connection, String sql, Object... params) {
		try {
			return new QueryRunner().update(connection, sql, params);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}


	/**
	 * 根据sql查询list对象
	 * @param connection
	 * @param sql
	 * @param type
	 * @param params
	 * @param <T>
	 * @return
	 */
	public static <T> List<T> getListBean(Connection connection, String sql, Class<T> type, Object... params) {
		try
		{
			return new QueryRunner().query(connection, sql, new BeanListHandler<T>(type), params);
		}
		catch (Exception ex){			ex.printStackTrace();		}
		return null;
	}

	public static List<Object> getListBean_Page(String sql, Page page, Object[] params, Class<?> clss)
	{


		List<Object> list = null;
		try
		{
			sql = sql.toUpperCase();
			if (null == page)
			{
				list = (List<Object>) new QueryRunner().query(sql, new BeanListHandler(clss.newInstance().getClass()), params);
			}
			else
			{
				if (null == params)
				{
					params = new Object[]{};
				}

				// 查询总数
				String totalSql = "SELECT COUNT(*) FROM (" + sql + ")";
				BigDecimal count = new QueryRunner().query(totalSql,new ScalarHandler<BigDecimal>(),params);
				page.setTotalSize(count.intValue());
				page.init();

				Object[] pageParams = new Object[params.length + 2];
				System.arraycopy(params, 0, pageParams, 0, params.length);

				pageParams[params.length] = page.getPageEnd();
				pageParams[params.length + 1] = page.getPageBegin();


				String pageSql = "SELECT * FROM (SELECT A.*,ROWNUM RN " + "FROM (" + sql + ") A WHERE ROWNUM <=? )  WHERE RN >=?";
				list = (List<Object>) new QueryRunner().query(pageSql, new BeanListHandler(clss.newInstance().getClass()), pageParams);
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 根据sql查询list对象
	 * @param connection
	 * @param sql
	 * @param type
	 * @param <T>
	 * @return
	 */
	public static <T> List<T> getListBean(Connection connection, String sql, Class<T> type) {
		try {
			return new QueryRunner().query(connection, sql, new BeanListHandler<T>(type));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据sql和对象，查询结果并以对象形式返回
	 * @param connection
	 * @param sql
	 * @param type
	 * @param params
	 * @param <T>
	 * @return
	 */
	public static <T> T getBean(Connection connection, String sql, Class<T> type, Object... params) {
		try {
			return new QueryRunner().query(connection, sql, new BeanHandler<T>(type), params);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}


	/**
	 * 根据sql和对象，查询结果并以对象形式返回
	 * @param connection
	 * @param sql
	 * @param type
	 * @param <T>
	 * @return
	 */
	public static <T> T getBean(Connection connection, String sql, Class<T> type) {
		try {
			return new QueryRunner().query(connection, sql, new BeanHandler<T>(type));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}



	/**
	 * 根据传入的sql查询所有记录，以List Map形式返回
	 * @param connection
	 * @param sql
	 * @param params
	 * @return
	 */
	public static List<Map<String, Object>> getListMap(Connection connection, String sql, Object... params) {
		try {
			return new QueryRunner().query(connection, sql, new MapListHandler(), params);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}


	/**
	 * 根据传入的sql查询所有记录，以List Map形式返回
	 * @param connection
	 * @param sql
	 * @return
	 */
	public static List<Map<String, Object>> getListMap(Connection connection, String sql) {
		try {
			return new QueryRunner().query(connection, sql, new MapListHandler());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}


	/**
	 * 根据传入的sql，查询记录，以Map形式返回第一行记录。 注意：如果有多行记录，只会返回第一行，所以适用场景需要注意，可以使用根据主键来查询的场景
	 * @param connection
	 * @param sql
	 * @param params
	 * @return
	 */
	public static Map<String, Object> getFirstRowMap(Connection connection, String sql, Object... params) {
		try {
			return new QueryRunner().query(connection, sql, new MapHandler(), params);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}


	/**
	 * 根据传入的sql，查询记录，以Map形式返回第一行记录。 注意：如果有多行记录，只会返回第一行，所以适用场景需要注意，可以使用根据主键来查询的场景
	 * @param connection
	 * @param sql
	 * @return
	 */
	public static Map<String, Object> getFirstRowMap(Connection connection, String sql) {
		try {
			return new QueryRunner().query(connection, sql, new MapHandler());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}



	/**
	 * 根据sql查询返回所有记录，以List数组形式返回
	 * @param connection
	 * @param sql
	 * @param params
	 * @return
	 */
	public static List<Object[]> getListArray(Connection connection, String sql, Object... params) {
		try {
			return new QueryRunner().query(connection, sql, new ArrayListHandler(), params);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}



	/**
	 * 根据sql查询返回所有记录，以List数组形式返回
	 * 
	 * @param sql
	 * @return
	 */
	public static List<Object[]> getListArray(Connection connection, String sql) {
		try {
			new QueryRunner().query(connection, sql, new ArrayListHandler());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据传入的sql，查询记录，以数组形式返回第一行记录。 注意：如果有多行记录，只会返回第一行，所以适用场景需要注意，可以使用根据主键来查询的场景
	 * @param connection
	 * @param sql
	 * @param params
	 * @return
	 */
	public static Object[] getFirstRowArray(Connection connection, String sql, Object... params) {
		try {
			return new QueryRunner().query(connection, sql, new ArrayHandler(), params);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}


	/**
	 * 根据传入的sql，查询记录，以数组形式返回第一行记录。 注意：如果有多行记录，只会返回第一行，所以适用场景需要注意，可以使用根据主键来查询的场景
	 * @param connection
	 * @param sql
	 * @return
	 */
	public static Object[] getFirstRowArray(Connection connection, String sql) {
		try {
			return new QueryRunner().query(connection, sql, new ArrayHandler());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}


	/**
	 * 得到查询记录的条数
	 * @param 	connection
	 * @param 	sql
	 * @param	params
	 * @return 	查询记录条数
	 */
	public static int getCount(Connection conn, String sql, Object... params) {
		try {
			// ScalarHandler 将ResultSet的一个列到一个对象
			Object value = new QueryRunner().query(conn, sql, new ScalarHandler<>(), params);
			return objectToInteger(value);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}


	/**
	 * 得到查询记录的条数
	 * @param 	connection
	 * @param 	sql
	 * @return 	查询记录条数
	 */
	public static int getCount(Connection connection, String sql) {
		try {
			// ScalarHandler 将ResultSet的一个列到一个对象
			Object value = new QueryRunner().query(connection, sql, new ScalarHandler<>());
			return objectToInteger(value);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	public static int objectToInteger(Object obj) {
		try {
			if (obj != null && !obj.toString().trim().equals(""))
				return Integer.parseInt(obj.toString());
		} catch (Exception ex) {
			ex.printStackTrace();
			return 0;
		}
		return 0;
	}

}
