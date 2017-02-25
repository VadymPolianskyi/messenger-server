package com.softgroup.authorization.impl.router;

import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.authorization.api.router.AuthorizationRouterHandler;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;

/**
 * Author: vadym
 * Date: 23.02.17
 * Time: 23:02
 */
public class AuthorizationRouter implements AuthorizationRouterHandler {

    @Autowired
    List<AuthorizationRequestHandler> handlers;

    HashMap<String, AuthorizationRequestHandler> mapOfHandlers = new HashMap<>();

    @PostConstruct
    public void init() {
        for (AuthorizationRequestHandler handler : handlers) {
            mapOfHandlers.put(handler.getName(), handler);
        }
    }

    @Override
    public String getRouteKey(Request<?> msg) {
        return getName();
    }

    @Override
    public String getName() {
        return "authorization";
    }

    @Override
    public Response<?> handle(Request<?> msg) {
        return mapOfHandlers.get(msg.getHeader().getCommand()).handle(msg);
    }
}
