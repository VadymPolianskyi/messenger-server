package com.softgroup.common.jwt.api.exception;

/**
 * Author: vadym
 * Date: 17.03.17
 * Time: 18:20
 */
public class DeviceTokenException extends TokenException {

    private static final long serialVersionUID = -1310746105793297242L;

    public DeviceTokenException(String message) {
        super(message);
    }

    public DeviceTokenException(String message, Throwable cause) {
        super(message, cause);
    }
}
