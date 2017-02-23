package com.softgroup.authorithation.impl.router;

import com.softgroup.authorithation.impl.handler.LoginAuthorizationHandler;
import com.softgroup.authorization.api.message.LoginResponse;
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
 * Time: 13:15
 */
@Component
public class LoginAuthorizationRouterHandler<T extends LoginAuthorizationHandler > extends AbstractRouterHandler {

    @Autowired
    List<T> handlers;

    HashMap<String, Handler> mapOfHandlers = new HashMap<>();

    @PostConstruct
    public void init() {
        for (Handler handler : handlers) {
            mapOfHandlers.put(handler.getName(), handler);
        }
    }

    @Override
    public String getRouteKey(Request<?> msg) {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Response<? extends LoginResponse> handle(Request<?> msg) {
        return null;
    }
}
