package com.softgroup.common.router.api;


import com.softgroup.common.datamapper.DataMapper;
import com.softgroup.common.datamapper.JacksonDataMapper;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.RequestData;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseData;

import java.util.Map;

public abstract class AbstractRequestHandler<T extends RequestData, R extends ResponseData> implements RequestHandler {


    public abstract Response<R> doHandle(Request<T> request);

    @Override
    public Response<R> handle(Request<?> msg) {
//        Request<T> tRequest = new Request<>();
//        tRequest.setHeader(msg.getHeader());
//        JacksonDataMapper jacksonDataMapper = new JacksonDataMapper();
//
//        Class thisClass = AbstractRequestHandler.class;
//        ParameterizedType type = (ParameterizedType) thisClass.getGenericSuperclass();
//        Class parameter = (Class) type.getActualTypeArguments()[0];
//        tRequest.setData(jacksonDataMapper.convert((Map<String, Object>)msg.getData(), (Class<T>) parameter));


        DataMapper mapper = new JacksonDataMapper();
        Map<String, Object> map = mapper.convertToMap(msg);
        RequestData data = mapper.convert(map, RequestData.class);
        Request<T> converted = new Request<T>();
        converted.setHeader(msg.getHeader());
        converted.setData((T) data);

        return doHandle(converted);
    }

}
