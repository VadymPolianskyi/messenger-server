package com.softgroup.common.protocol;

import java.io.Serializable;

public class Request<T extends Serializable> extends RoutingAction<T> implements RequestData{
	private static final long serialVersionUID = -1024761631293962969L;
}
