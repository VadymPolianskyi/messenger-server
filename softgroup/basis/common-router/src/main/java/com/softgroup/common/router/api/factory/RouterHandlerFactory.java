package com.softgroup.common.router.api.factory;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.router.api.AbstractRouterHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 18:20
 */
@Component
public class RouterHandlerFactory<T extends AbstractRouterHandler> extends HandlerFactory<T> {

    static Logger log = LoggerFactory.getLogger(RequestHandlerFactory.class);

    protected String getRouteKey(Request<?> msg) {
        log.info("RouterFactory is working");
        return msg.getHeader().getType();
    }
}