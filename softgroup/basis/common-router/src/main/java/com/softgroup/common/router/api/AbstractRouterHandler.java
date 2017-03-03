package com.softgroup.common.router.api;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.factory.HandlerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractRouterHandler<T extends AbstractRequestHandler> implements RouterHandler, CommonRouterHandler {

	@Autowired
	HandlerFactory<T> requestHandlerFactory;

	@Override
	public Response<?> handle(Request<?> msg) {
        return requestHandlerFactory.getHandler(msg).handle(msg);
	}

}
