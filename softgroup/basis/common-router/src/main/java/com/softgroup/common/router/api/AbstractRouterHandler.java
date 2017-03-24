package com.softgroup.common.router.api;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.factory.HandlerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractRouterHandler<T extends RequestHandler> implements RouterHandler, CommonRouterHandler {

	@Autowired
	HandlerFactory<T> requestHandlerFactory;

	static Logger log = LoggerFactory.getLogger(AbstractRouterHandler.class);

	@Override
	public Response<?> handle(Request<?> msg) {
		log.info("Router " + getName() + " is working");
        return requestHandlerFactory.getHandler(msg).handle(msg);
	}

}
