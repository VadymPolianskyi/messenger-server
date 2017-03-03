package com.softgroup.common.router.api.factory;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.router.api.Handler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 12:35
 */
@Component
public abstract class HandlerFactory<T extends Handler> {
    @Autowired
    List<T> handlerList;


    HashMap<String, T> handlerMap = new HashMap<>();

    @PostConstruct
    public void init() {
        for (T handler : handlerList) {
            handlerMap.put(handler.getName(), handler);
        }
    }

    public T getHandler(Request<?> msg) {
        return handlerMap.get(getRouteKey(msg));
    }

    protected abstract String getRouteKey(Request<?> msg);
}
