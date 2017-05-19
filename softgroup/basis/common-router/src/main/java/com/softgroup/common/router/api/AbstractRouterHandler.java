package com.softgroup.common.router.api;

import com.softgroup.common.loger.Loggable;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.factory.HandlerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractRouterHandler<T extends RequestHandler> implements RouterHandler, CommonRouterHandler {

	@Autowired
	HandlerFactory<T> requestHandlerFactory;

	@Loggable
	static Logger log;

	@Override
	public Response<?> handle(Request<?> msg) {
		log.info("Router " + getName() + " is working");
        return requestHandlerFactory.getHandler(msg).handle(msg);
	}

}
