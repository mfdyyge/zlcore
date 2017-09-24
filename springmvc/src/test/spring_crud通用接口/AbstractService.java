package com.fence.service;

import com.fence.common.IFenceOperations;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Juyan on 2014/12/26 0026.
 */
@Transactional
public abstract class AbstractService<T extends Serializable> implements IFenceOperations<T> {


  protected abstract IFenceOperations<T> getDao();

  @Override
  public T findById(int id) {
    return getDao().findById(id);
  }

  @Override
  public List<T> findAll() {
    return getDao().findAll();
  }

  @Override
  public T update(T entity) {
    return getDao().update(entity);
  }

  @Override
  public void delete(T entity) {
    getDao().delete(entity);

  }

  @Override
  public void deleteById(int entityId) {
    getDao().deleteById(entityId);
  }

  @Override
  public List<T> findByProperty(String propertyName, Object value) {
    return getDao().findByProperty(propertyName, value);
  }


  @Override
  public void save(T entity) {
    getDao().save(entity);
  }

  @Override
  public int findCount() {

    return getDao().findCount();
  }

}
