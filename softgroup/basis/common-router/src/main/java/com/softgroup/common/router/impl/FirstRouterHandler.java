package com.softgroup.common.router.impl;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRouterHandler;
import com.softgroup.common.router.api.Handler;
import com.softgroup.common.router.api.factory.HandlerFactory;
import com.softgroup.common.router.api.factory.RouterHandlerFactory;
import org.springframework.stereotype.Component;

/**
 * Author: vadym
 * Date: 23.02.17
 * Time: 15:12
 */
@Component
public class FirstRouterHandler<T extends AbstractRouterHandler> implements Handler {


    @Override
    public String getName() {
        return "mainRouter";
    }

    HandlerFactory<T> factory = new RouterHandlerFactory<T>();

    @Override
    public Response<?> handle(Request<?> msg) {

        return factory.getHandler(msg).handle(msg);
    }
}
