 package com.zl.hb;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Repository;

/*
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.orm.hibernate4.SessionFactoryUtils;
import org.springframework.transaction.annotation.Transactional;
*/



/**
 * 
 * @author		周路
 * @日期 			First-TimeApp: 2011-05-14 14:29  Last-TimeApp: 2012-12-21 11:23
 * @version 	Version  	M2012.12.21
 * @see   		objpath： 	对象路径（此变量为String类型-例如："oa.system.User"）
 * @see			cls: 		对象类
 * @see			obj： 		操作对象
 * @see			log:		日志 log=> LoggerFactory.getLogger(obj.Class)
 */
@Repository
public class HbImp implements HbDao{
	
	@Autowired
	@Qualifier(value="localsessionFactory_ws")
	private SessionFactory sessionFactory;  
/*
	public SessionFactory getSessionFactory() {			return sessionFactory;		}
	public void setSessionFactory(SessionFactory sessionFactory) {		this.sessionFactory= sessionFactory;		}
*/

@Override
public Session getSession() {			return sessionFactory.getCurrentSession();		}
		
@Override
public	String 	save(Object obj)
			{		
					getSession() .save(obj);
					System.out.println("记录持久化完成");
					return "记录持久化完成";
			}

			/**
			 * @author 批量更新-HQL方式
			 * @param setName
			 * @param setNameVal
			 * @param whereName
			 * @param whereVal
			 * @param objpath 
			 */
@Override
public	String 	updateHql(Object obj, String objpath,String named,String nameVal,String whereName,String whereVal) {
		
					String hqlUpdate ="update "+objpath+" as model set model."+named+" = :nameVal where model."+whereName+" =:whereval";
					int updatedEntities =getSession() .createQuery( hqlUpdate )
													  .setString( "setname", nameVal)
													  .setString( "whereval",whereVal )
													  .executeUpdate();
					String msgs=obj.toString()+"批量更新完成!";
					return msgs;
			}
			
@Override	
public	String	update(Object obj) {	
					getSession() .update(obj);
					String msgs=obj.toString()+"更新完成!";
					return msgs;
			}
/**
 * @author 批量删除-HQL方式
 * @param String objpath
 * @param where   xxx='' and xxx=''
 */
@Override
public	String	deleteHql(String objpath,String where) {
		
					/*String hqlUpdate ="delete "+objpath+" where "+where;
					getSession() .createQuery( hqlUpdate ) .executeUpdate();*/
					String msgs=objpath+"批量删除完成!";
					return msgs;
			}
@Override
public	String	delete(Object obj) {
					getSession() .delete(obj);
					return "记录删除成功";
			}
			
/**
 * @获取指定Id号的记录
 * @param id
 * @param String objpath
 * @return
 */
@Override
public	Object 	findById(String objpath,Integer id) {
					Object instance= (Object)getSession() .get(objpath,id);
					return instance;
			}


@Override
public	Object 	findById(Class obj,Integer id) {
					Object instance= (Object)getSession() .get(obj,id);
					return instance;
			}


@Override
public	List	findAll_HQL(String objpath) {
					List	list=null;
							String	queryString =	"from "+objpath;
							Query	queryObject =	getSession() .createQuery(queryString);
										list	=	queryObject.list();
					return list;
			}
@Override	
public	int	findSize_HQL(String objpath)
{
					String	queryString = "select count(*) from "+objpath;
					Query	query	=getSession() .createQuery(queryString);
					int		count	= ((Number)query.uniqueResult()).intValue();
					return count;
}

/**
 * sum_count_obj_n  
 * ==sum(id)
 * ==count(id)
 */
@Override	
public	int	findSum_count_HQL(String table_name,String  sum_count_obj_n,String where_id)
{
		String	queryString = "select "+sum_count_obj_n+" from "+table_name +" where "+where_id;

		//Hql查询返回Bean对象----有对应原生SQL查询方法
		Query	query	=getSession() .createQuery(queryString);
		int		count	= ((Number)query.uniqueResult()).intValue();

		return count;
}


/**
 * sum_count_obj_n  
 * ==sum(id)
 * ==count(id)
 */
@Override	
public	Object	findSum_count_resultObj(String objpath,String  sum_count_obj_n,String where_id)
{            
		String	queryString = "select "+sum_count_obj_n+" from "+objpath +" where "+where_id;
		Query	query	=getSession() .createQuery(queryString);
		Object	obj	= query.uniqueResult();		
		return obj;
}

			/**
			* @author 查询指定字段
			* @param propertyName			查询指定字段
			* @param value					对象值
			* @param order_propertyName  	排序字段名
			* @param desc   				排序方式
			* @param objpath 
			* @return
			*/
@Override
public	List	findNamed_HQL(String objpath,String propertyName, Object value,String order_propertyName,String desc)
{
					List list=null;
					String	queryString = "from "+objpath+" as model where model.? = ?  order by ?  ?";
					Query	queryObject =getSession() .createQuery(queryString);
									list =queryObject.setParameter(0, propertyName)
													 .setParameter(1, value)
													 .setParameter(2, order_propertyName)
													 .setParameter(3, desc)
													 .list();
					return list;
}
			

			
/**
 * @author 需要排序
 * QBC-Criterion cri=Restrictions.eq(x,x)||like(X.X)||ilike(X.X)		
 * @param objcls 
 * @param 	order_propertyName:排序字段
 * @return  List
 */
@Override
public	List	findNamed_resultlist(Class objcls,Criterion criterion,Order order_propertyName_val) {
					List list=null;
					list =getSession() .createCriteria(objcls)
									   .add(criterion)
									   .addOrder(order_propertyName_val)
									   .list();
					return list;
			}
/**
 * @author 不需要排序
 * QBC-Criterion cri=Restrictions.eq(x,x)||like(X.X)||ilike(X.X)	
 */
@Override
public	Object	findNamed_resultobj(Class objcls,Criterion restriction) {
					Object obj=null;
					obj =getSession() .createCriteria(objcls)
									   .add(restriction)
									   .uniqueResult();
					return obj;
			}
/**
 * @author 不需要排序
 * QBC-Criterion cri=Restrictions.eq(x,x)||like(X.X)||ilike(X.X)	
 */
@Override
public	List	findNamed_resultlist(Class objcls,Criterion restriction) {
					List obj=null;
					obj =(List) getSession() .createCriteria(objcls)
									   .add(restriction).list();
					
					
					return obj;
			}

			/**
			 * @author 	模糊查询-QBC-restriction -iLike 不考虑字符大小 写
			 * @param 	propertyName:查询字段
			 * @param 	value：查询字段值
			 * @param 	order_propertyName:排序字段
			 * @param 	matchmode (MatchMode. START|END|ANYWHERE-任何位置|EXACT-精确)
			 * @return 	
			 */
@Override
public	List	findNamedIlike_Restriction(Class objcls,String propertyName,String value, MatchMode matchmode,String order_propertyName) {		
					List list=null;
					list =getSession() .createCriteria(objcls)
									   .add(Restrictions.ilike(propertyName, value,matchmode))
									   .addOrder(Order.desc(order_propertyName))
									   .list();
					return list;
			}
			
			/**
			 * @author 模糊查询-QBC-restriction -Like 考虑字符大小 写
			 * @param 	propertyName:查询字段
			 * @param 	value：查询字段值
			 * @param 	order_propertyName:排序字段
			 * @param 	matchmode (MatchMode. START|END|ANYWHERE-任何位置|EXACT-精确)
			 * @return
			 */
@Override
public	List	findNamedlike_Restriction(Class objcls,String propertyName,String value, MatchMode matchmode,String order_propertyName) {
					List list=null;
					list =getSession() .createCriteria(objcls)
									   .add(Restrictions.like(propertyName, value,matchmode))
									   .addOrder(Order.desc(order_propertyName))
									   .list();
					return list;
			}
			
/**
			 * @author QBE-Examle org.hibernate.criterion.Example-类允许你通过一个给定实例 构建一个条件查询
			 * @param objcls 
			 * @param  instance Object obj
			 * @return
			 */
@Override
public List	findNamed_example(Object obj, Class objcls,MatchMode matchMode) {
					List list=null;
					list =getSession() .createCriteria(objcls)
									   .add(Example.create(obj).enableLike(matchMode))
									   .list();
					return list;
			}



			/**
			 * @author 	原生HQL-查询指定N个字段记录
			 * @param 	tableName		 		查询对象
			 * @param 	queryPropertyName		查询对象-相应字段
			 * @param   objcls
			 * @return	
			 */
@Override
public	List	findNamed_Sql(String objcls_path,String tableName,String queryPropertyName,String order_propertyName) {
					List list=null;
					//.createSQLQuery("SELECT ID, NAME, BIRTHDATE, DOG_ID FROM CATS").addEntity(Cat.class);
					String hqlUpdate ="SELECT ? FROM ? order by ? desc";
					list=getSession() .createSQLQuery( hqlUpdate )
									  .addEntity(objcls_path)
									  .setParameter(0, queryPropertyName)
									  .setParameter(1, tableName)
									  .setParameter(2, order_propertyName)
									  .list();
					return list;
			}

@Override
public	List	findNamed_Sql(String objcls_path,String query_PropertyName,String tableName,String where_propername,String order_propertyName) {
					List list=null;
					//.createSQLQuery("SELECT ID, NAME, BIRTHDATE, DOG_ID FROM CATS").addEntity(Cat.class);
					String hqlUpdate ="SELECT ? FROM ? order where 1=1 and ? order by ? desc";
					list=getSession() .createSQLQuery( hqlUpdate )
									  .addEntity(objcls_path)
									  .setParameter(0, query_PropertyName)
									  .setParameter(1, where_propername)
									  .setParameter(2, order_propertyName)
									  .list();
					return list;
			}
		/**
			 * @author 分页查询
			 * @param pageNo
			 * @param pageSize
			 * @return
			 */
@Override
public	List getPageList(Class cls,int pageNo,int pageSize,String order_named){
				List list=getSession() .createCriteria(cls)
										.setFirstResult((pageNo-1)*pageSize)
										.setMaxResults(pageSize)
										.addOrder(Order.desc(order_named))
										.list();
				return list;
		}
			
		/**
			 * @param sql-“from user”-采HQL 方式
			 * @param pagesize
			 * @param pageno
			 * @return
		*/
@Override
public	List pageList(String sql,int pagesize,int pageno){
				List list = null;
					Query query =getSession() .createQuery(sql);
					
					query.setFirstResult((pageno - 1) * pagesize);
					query.setMaxResults(pagesize);
					list = query.list();
				return list;
		}
		
		/**
		 * @author 查询对象全部记录
		 * @return List<obj>
		 */
@Override
public	List findAll(Class objcls) {
				
				List list=(List)getSession().createCriteria(objcls).list();
				return list;
		}


}