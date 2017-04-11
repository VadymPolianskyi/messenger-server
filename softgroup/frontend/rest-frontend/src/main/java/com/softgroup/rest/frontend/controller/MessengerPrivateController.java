package com.softgroup.rest.frontend.controller;

import com.softgroup.common.protocol.CommonRequest;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.RoutingData;
import com.softgroup.common.router.api.Handler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
/**
 * Created by vadym_polyanski on 24.03.17.
 */
@RestController
@RequestMapping(path = "/messenger")
public class MessengerPrivateController {
    @Autowired
    HttpSession session;

    @Autowired
    Handler firstRouterHandler;

    @RequestMapping(path = "/private",
            method = RequestMethod.POST)
    public Response privateMessenger(@RequestBody final CommonRequest request) {
        request.setRoutingData((RoutingData) session.getAttribute("routing_data"));
        return firstRouterHandler.handle(request);
    }
}
