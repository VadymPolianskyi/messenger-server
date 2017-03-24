package com.softgroup.common.cache.service;

import com.softgroup.common.cache.entity.CasheData;

import java.util.concurrent.ExecutionException;

/**
 * Author: vadym
 * Date: 18.03.17
 * Time: 21:08
 */
public abstract class BaseCacheService <T extends CasheData>{
    public abstract void put(T casheData);

    public abstract T getFromCache(String key) throws ExecutionException;
}
