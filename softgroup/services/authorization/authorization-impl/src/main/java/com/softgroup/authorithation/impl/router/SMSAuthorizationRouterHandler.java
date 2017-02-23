package com.softgroup.authorithation.impl.router;

import com.softgroup.authorithation.impl.handler.SMSAuthorizationHandler;
import com.softgroup.authorization.api.message.SMSResponse;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRouterHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;

/**
 * Author: vadym
 * Date: 23.02.17
 * Time: 8:18
 */
@Component
public class SMSAuthorizationRouterHandler<T extends SMSAuthorizationHandler> extends AbstractRouterHandler<T> {

    @Autowired
    List<T> handlers;

    HashMap<String, SMSAuthorizationHandler> routers = new HashMap<>();

    @PostConstruct
    private void init() {
        for (SMSAuthorizationHandler handler : handlers) {
            routers.put(handler.getName(), handler);
        }
    }


    @Override
    public String getName() {
        return "smsRouter";
    }

    @Override
    public Response<? extends SMSResponse> handle(Request<?> msg) {
        return (Response<? extends SMSResponse>) routers.get(msg.getHeader().getType()).handle(msg);
    }

    @Override
    public String getRouteKey(Request<?> msg) {
        return null;
    }
}
