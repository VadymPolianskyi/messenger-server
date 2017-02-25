package com.softgroup.common.router.api.factory;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.router.api.RequestHandler;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 18:46
 */
public class RequestHandlerFactory <T extends RequestHandler> extends HandlerFactory<T> {
    protected String getRouteKey(Request<?> msg) {
        return msg.getHeader().getCommand();
    }
}
