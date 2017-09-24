package com.fence.common;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Juyan on 2014/12/26 0026.
 */
public interface IFenceOperations<T extends Serializable> {


  public T findById(final int id);

  public void save(T entity);

  public List<T> findByProperty(String propertyName, Object value);

  public List<T> findAll();

  public int findCount();

  public T update(final T entity);

  public void delete(final T entity);

  public void deleteById(final int entityId);

}
