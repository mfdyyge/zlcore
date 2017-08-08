package com.zl.hb;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public interface HbDao {

	
	public	String 	save(Object obj);

	/**
	 * @author 批量更新-HQL方式
	 * @param setName
	 * @param setNameVal
	 * @param whereName
	 * @param whereVal
	 * @param objpath 
	 */
	
	public	String 	updateHql(Object obj, String objpath, String named, String nameVal, String whereName, String whereVal) ;
	
	public	String	update(Object obj);

	
	public	String	delete(Object obj) ;
	
	/**
	 * @获取指定Id号的记录
	 * @param id
	 * @param String objpath
	 * @return
	 */

	public	Object 	findById(String objpath, Integer id) ;

	public	List	findAll_HQL(String objpath) ;
	
	/**
	* @author 表总记录
	*/
	public	int	findSize_HQL(String objpath);
	
	/**
	* @author HQL
	* @param propertyName			需要查询-对象属性
	* @param value					对象值
	* @param order_propertyName  	排序字段名
	* @param desc   				排序方式
	 * @param objpath 
	* @return
	*/
	public	List	findNamed_HQL(String objpath, String propertyName, Object value, String order_propertyName, String desc);

	/**
	 * @author 需要排序
	 * QBC-Criterion cri=Restrictions.eq(x,x)||like(X.X)||ilike(X.X)		
	 * @param objcls 
	 * @param 	order_propertyName:排序字段
	 * @return  List
	 */
	public	List	findNamed_resultlist(Class objcls, Criterion criterion, Order order_propertyName_val);

	/**
	 * @author 不需要排序
	 * QBC-Criterion cri=Restrictions.eq(x,x)||like(X.X)||ilike(X.X)	
	 */
	public	Object	findNamed_resultlist(Class objcls, Criterion restriction);
	
	/**
	 * @author 	模糊查询-QBC-restriction -iLike 不考虑字符大小 写
	 * @param 	propertyName:查询字段
	 * @param 	value：查询字段值
	 * @param 	order_propertyName:排序字段
	 * @param 	matchmode (MatchMode. START|END|ANYWHERE-任何位置|EXACT-精确)
	 * @return 	
	 */
	public	List	findNamedIlike_Restriction(Class objcls, String propertyName, String value, MatchMode matchmode, String order_propertyName);
	
	/**
	 * @author 模糊查询-QBC-restriction -Like 考虑字符大小 写
	 * @param 	propertyName:查询字段
	 * @param 	value：查询字段值
	 * @param 	order_propertyName:排序字段
	 * @param 	matchmode (MatchMode. START|END|ANYWHERE-任何位置|EXACT-精确)
	 * @return
	 */
	public	List	findNamedlike_Restriction(Class objcls, String propertyName, String value, MatchMode matchmode, String order_propertyName);
	
	/**
	 * @author QBE-Examle org.hibernate.criterion.Example-类允许你通过一个给定实例 构建一个条件查询
	 * @param objcls 
	 * @param  instance Object obj
	 * @return
	 */
	public List	findNamed_example(Object obj, Class objcls, MatchMode matchMode) ;
	
	/**
	 * @author 	原生SQL-查询指定N个字段记录
	 * @param 	tableName		 		查询对象
	 * @param 	queryPropertyName		查询对象-相应字段
	 * @param objcls 
	 * @return	
	 */
	public	List	findNamed_Sql(String objcls, String tableName, String queryPropertyName, String order_propertyName) ;

/**
	 * @author 分页查询
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
public	List getPageList(Class cls, int pageNo, int pageSize, String order_named);
	
/**
	 * @param sql-“from user”-采HQL 方式
	 * @param pagesize
	 * @param pageno
	 * @return
*/
public	List pageList(String sql, int pagesize, int pageno);

/**
 * @author 查询对象全部记录
 * @return List<obj>
 */
public	List findAll(Class objcls) ;

public	Object findById(Class obj, Integer id);

public	Object findNamed_resultobj(Class objcls, Criterion restriction);

public  Session getSession();


/**
 * sum_count_obj_n =sum(id) =count(id)
 * where_id 查询条件
 */
public int findSum_count_HQL(String objpath, String sum_count_obj_n, String where_id);

public Object findSum_count_resultObj(String objpath, String sum_count_obj_n, String where_id);

/**
 * @author 批量删除-HQL方式
 * @param String objpath
 * @param whereName
 * @param whereVal
 */
public String deleteHql(String objpath, String where);

public List findNamed_Sql(String objcls_path, String query_PropertyName,
						  String tableName, String where_propername, String order_propertyName);

}
