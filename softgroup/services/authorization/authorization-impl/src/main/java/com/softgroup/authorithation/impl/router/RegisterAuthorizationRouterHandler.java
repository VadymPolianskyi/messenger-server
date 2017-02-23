package com.softgroup.authorithation.impl.router;

import com.softgroup.authorithation.impl.handler.RegisterAuthorizationHandler;
import com.softgroup.authorization.api.message.RegisterResponse;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRouterHandler;
import com.softgroup.common.router.api.Handler;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;

/**
 * Author: vadym
 * Date: 23.02.17
 * Time: 13:20
 */
public class RegisterAuthorizationRouterHandler <T extends RegisterAuthorizationHandler> extends AbstractRouterHandler<T> {


    @Autowired
    List<T> handlers;

    HashMap<String, Handler> routers = new HashMap<>();

    @PostConstruct
    private void init() {
        for (Handler handler : handlers) {
            routers.put(handler.getName(), handler);
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
    public Response<? extends RegisterResponse> handle(Request<?> msg) {
        return null;
    }
}
