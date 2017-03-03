package com.softgroup.common.router.impl;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRouterHandler;
import com.softgroup.common.router.api.Handler;
import com.softgroup.common.router.api.factory.HandlerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Author: vadym
 * Date: 23.02.17
 * Time: 15:12
 */
@Component
public class FirstRouterHandler implements Handler {


    @Override
    public String getName() {
        return "mainRouter";
    }

    @Autowired
    HandlerFactory<AbstractRouterHandler> routerHandlerFactory;

    @Override
    public Response<?> handle(Request<?> msg) {
        return routerHandlerFactory.getHandler(msg).handle(msg);
    }
}
