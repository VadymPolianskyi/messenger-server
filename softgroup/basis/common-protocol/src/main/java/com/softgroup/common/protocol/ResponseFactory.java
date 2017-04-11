package com.softgroup.common.protocol;

import org.springframework.stereotype.Component;

/**
 * Author: vadym_polyanski
 * Date: 05.04.17
 * Time: 20:31
 */
@Component
public class ResponseFactory<T extends ResponseData> {
    public Response<T> createResponse(Request request, T responseData) {
        Response<T> response = new Response<T>();
        response.setHeader(request.getHeader());
        response.setData(responseData);
        response.setStatus(new ResponseStatus(Status.OK.getNumVal(), Status.OK.getMessage()));

        return response;
    }

    public Response<T> createResponse(Request request, Status status) {
        Response<T> response = new Response<T>();
        response.setHeader(request.getHeader());
        response.setStatus(new ResponseStatus(status.getNumVal(), status.getMessage()));

        return response;
    }
}
