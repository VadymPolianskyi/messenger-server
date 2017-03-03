package com.softgroup.frontend.test.controller;

import com.softgroup.common.datamapper.DataMapper;
import com.softgroup.common.protocol.CommonRequest;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.Handler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;

/**
 * Author: vadym
 * Date: 01.03.17
 * Time: 9:49
 */
@RestController
@RequestMapping(path = "/messenger")
public class MessengerController {
    @Autowired
    Handler firstRouterHandler;

    @Autowired
    DataMapper jacksonDataMapper;

    @RequestMapping(path = "/registration",
            method = RequestMethod.POST)
    public Response publicMessage(@RequestBody final String requestStr) {
        CommonRequest request = jacksonDataMapper.mapData(requestStr.getBytes(StandardCharsets.UTF_8),CommonRequest.class);
        return firstRouterHandler.handle(request);
    }

    @RequestMapping(path = "/test",
            method = RequestMethod.GET)
    public String publicMessage() {
        return "test";
    }
}
