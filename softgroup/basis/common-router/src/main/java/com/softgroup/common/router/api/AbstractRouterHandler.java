package com.softgroup.common.router.api;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.factory.HandlerFactory;
import com.softgroup.common.router.api.factory.RequestHandlerFactory;

public abstract class AbstractRouterHandler<T extends Handler> implements RouterHandler, CommonRouterHandler {

	HandlerFactory<T> factory = new RequestHandlerFactory<T>();

	@Override
	public Response<?> handle(Request<?> msg) {

        return factory.getHandler(msg).handle(msg);
	}

}
