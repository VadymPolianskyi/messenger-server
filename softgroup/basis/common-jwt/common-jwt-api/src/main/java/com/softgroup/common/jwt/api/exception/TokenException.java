package com.softgroup.common.jwt.api.exception;

import io.jsonwebtoken.JwtException;

/**
 * Author: vadym
 * Date: 17.03.17
 * Time: 18:37
 */
public class TokenException extends JwtException {

    private static final long serialVersionUID = -5724165599309149753L;

    public TokenException(String message) {
        super(message);
    }

    public TokenException(String message, Throwable cause) {
        super(message, cause);
    }
}
