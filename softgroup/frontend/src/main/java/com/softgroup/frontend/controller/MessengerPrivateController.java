package com.softgroup.frontend.controller;

import com.softgroup.common.datamapper.DataMapper;
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
import java.nio.charset.StandardCharsets;

/**
 * Created by vadym_polyanski on 24.03.17.
 */
@RestController
@RequestMapping(path = "/messenger")
public class MessengerPrivateController {
    @Autowired
    HttpSession session;

    @Autowired
    DataMapper jacksonDataMapper;

    @Autowired
    Handler firstRouterHandler;

    @RequestMapping(path = "/private",
            method = RequestMethod.POST)
    public Response privateMessenger(@RequestBody final String requestStr) {
        CommonRequest request = jacksonDataMapper.mapData(requestStr.getBytes(StandardCharsets.UTF_8),CommonRequest.class);
        request.setRoutingData((RoutingData) session.getAttribute("routing_data"));
        return firstRouterHandler.handle(request);
    }
}
