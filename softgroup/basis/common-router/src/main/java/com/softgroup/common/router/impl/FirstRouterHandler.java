package com.softgroup.common.router.impl;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRouterHandler;
import com.softgroup.common.router.api.Handler;
import com.softgroup.common.router.api.factory.HandlerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Author: vadym
 * Date: 23.02.17
 * Time: 15:12
 */
@Component
public class FirstRouterHandler implements Handler {
    static Logger log = LoggerFactory.getLogger(FirstRouterHandler.class);


    @Override
    public String getName() {
        return "mainRouter";
    }

    @Autowired
    HandlerFactory<AbstractRouterHandler> routerHandlerFactory;

    @Override
    public Response<?> handle(Request<?> msg) {
        log.info("First router is working");
        return routerHandlerFactory.getHandler(msg).handle(msg);
    }
}
