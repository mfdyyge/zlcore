package com.fence.dao;

import com.fence.common.IFenceOperations;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Juyan on 2014/12/26 0026.
 */
public abstract class AbstractDao<T extends Serializable> implements IFenceOperations<T> {

  public void setClazz(Class<T> clazz) {
    this.clazz = clazz;
  }

  protected final Session getCurrentSession() {
    return sessionFactory.getCurrentSession();
  }


  private Class<T> clazz;


  @Resource
  private SessionFactory sessionFactory;


  @Override
  public T findById(int id) {
    return (T) getCurrentSession().get(clazz, id);
  }

  @Override
  public List findAll() {
    return getCurrentSession().createQuery("from " + clazz.getName()).list();
  }

  @Override
  public void save(T entity) {
    getCurrentSession().saveOrUpdate(entity);
  }

  @Override
  public T update(T entity) {
    getCurrentSession().update(entity);
    return entity;
  }

  @Override
  public void delete(T entity) {
    getCurrentSession().delete(entity);
  }

  @Override
  public void deleteById(int entityId) {
    final T entity = findById(entityId);
    delete(entity);
  }

  @Override
  public List<T> findByProperty(String propertyName, Object value) {
    String queryString = "from User as model where model."
        + propertyName + "= ?";
    Query queryObject = getCurrentSession().createQuery(queryString);
    queryObject.setParameter(0, value);
    return queryObject.list();
  }

  @Override
  public int findCount() {

    return new Integer(getCurrentSession().createQuery("from " + clazz.getName()).uniqueResult().toString());
  }

}
