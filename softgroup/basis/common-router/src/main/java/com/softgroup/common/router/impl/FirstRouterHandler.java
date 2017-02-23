package com.softgroup.common.router.impl;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRouterHandler;
import com.softgroup.common.router.api.Handler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;

/**
 * Author: vadym
 * Date: 23.02.17
 * Time: 15:12
 */
@Component
public class FirstRouterHandler<T extends AbstractRouterHandler> implements Handler {

    @Autowired
    List<T> routers;

    HashMap<String, T> mapOfRouters = new HashMap<>();

    @PostConstruct
    public void init() {
        for (T router : routers) {
            mapOfRouters.put(router.getName(), router);
        }
    }


    @Override
    public String getName() {
        return "mainRouter";
    }

    @Override
    public Response<?> handle(Request<?> msg) {
        return null;
    }
}
