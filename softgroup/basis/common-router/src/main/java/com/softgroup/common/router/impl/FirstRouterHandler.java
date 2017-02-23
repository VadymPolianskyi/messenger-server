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
public class FirstRouterHandler implements Handler {

    @Autowired
    List<AbstractRouterHandler> routers;

    HashMap<String, AbstractRouterHandler> mapOfRouters = new HashMap<>();

    @PostConstruct
    public void init() {
        for (AbstractRouterHandler router : routers) {
            mapOfRouters.put(router.getName(), router);
        }
    }


    @Override
    public String getName() {
        return null;
    }

    @Override
    public Response<?> handle(Request<?> msg) {
        return null;
    }
}
