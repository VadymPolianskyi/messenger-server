package com.softgroup.common.cache.service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.softgroup.common.cache.entity.AuthorizationDetails;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Author: vadym
 * Date: 18.03.17
 * Time: 18:01
 */
@Component
public class AuthorizationDetailsCacheService extends BaseCacheService<AuthorizationDetails> {

    private static LoadingCache<String, AuthorizationDetails> cache;

    static {
        cache = CacheBuilder.newBuilder()
                .maximumSize(1000)
                .expireAfterWrite(5, TimeUnit.MINUTES)
                .build(new CacheLoader<String, AuthorizationDetails>() {
                    public AuthorizationDetails load(String key) {
                        return get(key);
                    }
                });
    }

    public static AuthorizationDetails get(String key) {
        return get(key);
    }

    @Override
    public void put(AuthorizationDetails authorizationDetails) throws NullPointerException {

        cache.put(authorizationDetails.getRegistrationRequestUuid(),
               authorizationDetails);
    }

    @Override
    public AuthorizationDetails getFromCache(String key) throws ExecutionException, NullPointerException {

        return cache.get(key);
    }
}
