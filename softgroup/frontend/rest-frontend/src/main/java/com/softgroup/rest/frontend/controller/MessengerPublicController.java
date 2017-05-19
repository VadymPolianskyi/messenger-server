package com.softgroup.rest.frontend.controller;

import com.softgroup.common.loger.Loggable;
import com.softgroup.common.protocol.CommonRequest;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.Handler;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: vadym
 * Date: 01.03.17
 * Time: 9:49
 */
@RestController
@RequestMapping(method = RequestMethod.POST,
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE,
        path = "/messenger")
public class MessengerPublicController {

    @Loggable
    static Logger log;

    @Autowired
    private Handler firstRouterHandler;

    @RequestMapping(path = "/public",
            method = RequestMethod.POST)
    public Response publicMessenger(@RequestBody final CommonRequest request) {
        log.info("MessengerPublicController: have got request");
        return firstRouterHandler.handle(request);
    }

}
