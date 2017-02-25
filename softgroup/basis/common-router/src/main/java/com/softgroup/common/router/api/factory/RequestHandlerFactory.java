package com.softgroup.common.router.api.factory;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.router.api.AbstractRequestHandler;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 18:46
 */
public class RequestHandlerFactory <T extends AbstractRequestHandler> extends HandlerFactory<T> {
    protected String getRouteKey(Request<?> msg) {
        return msg.getHeader().getCommand();
    }
}
