package com.softgroup.profile.impl.router;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.profile.api.router.ProfileRequestHandler;
import com.softgroup.profile.api.router.ProfileRouterHandler;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 11:49
 */
public class ProfileRouter implements ProfileRouterHandler{

    @Autowired
    List<ProfileRequestHandler> handlers;

    HashMap<String, ProfileRequestHandler> mapOfHandlers = new HashMap<>();

    @PostConstruct
    public void init() {
        for (ProfileRequestHandler handler : handlers) {
            mapOfHandlers.put(handler.getName(), handler);
        }
    }


    public String getRouteKey(Request<?> msg) {
        return getName();
    }

    public String getName() {
        return "profile";
    }

    public Response<?> handle(Request<?> msg) {
        return mapOfHandlers.get(msg.getHeader().getCommand()).handle(msg);
    }
}
