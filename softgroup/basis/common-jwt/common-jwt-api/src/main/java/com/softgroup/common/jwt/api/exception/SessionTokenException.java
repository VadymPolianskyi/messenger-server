package com.softgroup.common.jwt.api.exception;

/**
 * Author: vadym
 * Date: 17.03.17
 * Time: 18:20
 */
public class SessionTokenException extends TokenException {

    private static final long serialVersionUID = 5383014488627998471L;

    public SessionTokenException(String message) {
        super(message);
    }

    public SessionTokenException(String message, Throwable cause) {
        super(message, cause);
    }
}
