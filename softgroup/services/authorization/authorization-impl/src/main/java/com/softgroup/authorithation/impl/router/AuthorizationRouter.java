package com.softgroup.authorithation.impl.router;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.common.router.api.AbstractRouterHandler;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;

/**
 * Author: vadym
 * Date: 23.02.17
 * Time: 23:02
 */
public class AuthorizationRouter <T extends AbstractRequestHandler> extends AbstractRouterHandler {

    @Autowired
    List<T> handlers;

    HashMap<String, AbstractRequestHandler> mapOfHandlers = new HashMap<>();

    @PostConstruct
    public void init() {
        for (T handler : handlers) {
            mapOfHandlers.put(handler.getName(), handler);
        }
    }

    @Override
    public String getRouteKey(Request<?> msg) {
        return getName();
    }

    @Override
    public String getName() {
        return "authorizationRouter";
    }

    @Override
    public Response<?> handle(Request<?> msg) {
        return mapOfHandlers.get(msg.getHeader().getType()).handle(msg);
    }
}
