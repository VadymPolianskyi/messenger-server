package com.softgroup.common.router.api;


import com.softgroup.common.datamapper.DataMapper;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.RequestData;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.util.Map;
public abstract class AbstractRequestHandler<T extends RequestData, R extends ResponseData> implements RequestHandler {

    @Autowired
    private DataMapper mapper;

    public abstract Response<R> doHandle(Request<T> request);

    @Override
    public Response<R> handle(Request<?> msg) {

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
