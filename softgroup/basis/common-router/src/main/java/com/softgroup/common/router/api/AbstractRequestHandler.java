package com.softgroup.common.router.api;


import com.softgroup.common.datamapper.DataMapper;
import com.softgroup.common.loger.Loggable;
import com.softgroup.common.protocol.*;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.util.Map;
public abstract class AbstractRequestHandler<T extends RequestData, R extends ResponseData> implements RequestHandler {

    @Autowired
    private DataMapper mapper;

    @Autowired
    protected ResponseFactory<R> responseFactory;

    @Loggable
    static Logger log;

    public abstract Response<R> doHandle(Request<T> request);

    @Override
    public Response<R> handle(Request<?> msg) {
        log.info("Handler '" + getName() + "' is working");

        Map<String, Object> map = (Map<String, Object>) msg.getData();

        Class<T> persistentClass = (Class<T>)
                ((ParameterizedType)getClass().getGenericSuperclass())
                        .getActualTypeArguments()[0];

        T data = mapper.convert(map, persistentClass);
        Request<T> converted = new Request<T>();
        converted.setHeader(msg.getHeader());
        converted.setData(data);
        return doHandle(converted);
    }

}
