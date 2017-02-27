package com.softgroup.common.router.api.factory;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.router.api.AbstractRouterHandler;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 18:20
 */
public class RouterHandlerFactory<T extends AbstractRouterHandler> extends HandlerFactory<T> {

    protected String getRouteKey(Request<?> msg) {
        return msg.getHeader().getType();
    }
}

