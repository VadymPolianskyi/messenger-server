package com.softgroup.db.dao.api;

import java.io.Serializable;
import java.util.List;
/**
 * Author: vadym
 * Date: 28.02.17
 * Time: 19:08
 */
public interface MessengerDAO <T, Id extends Serializable> {


    public void update(T entity);

    public T findById(Id id);

    public void delete(T entity);

    public List<T> findAll();

    public void deleteAll();
}
