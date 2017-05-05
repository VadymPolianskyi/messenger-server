package com.softgroup.common.dao.impl.service;

import com.softgroup.common.dao.impl.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * Author: vadym
 * Date: 15.03.17
 * Time: 19:33
 */
public abstract class BaseService
        <T extends Serializable, R extends BaseRepository<T>> {

    @Autowired
    private R repository;

    public T save(T entity){
        return repository.save(entity);
    }

    public void delete(String id){
        repository.delete(id);
    }

    public T update(T entity){
        return repository.save(entity);
    }

    public List<T> getAll(){
        return repository.findAll();
    }

    public R getRepository() {
        return repository;
    }

    public T getById(String id){
        return repository.findOne(id);
    }
}
