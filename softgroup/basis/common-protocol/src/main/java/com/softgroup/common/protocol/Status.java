package com.softgroup.common.protocol;

/**
 * Author: vadym_polyanski
 * Date: 05.04.17
 * Time: 20:31
 */
public enum Status {
    OK(200, "OK"), BAD_REQUEST(400, "BAD_REQUEST"), FORBIDDER(403, "FORBIDDER"), NOT_FOUND(404, "NOT_FOUND"),
            NOT_ACCEPTABLE(406, "NOT_ACCEPTABLE"), UNPROCESSABLE_ENTITY(422, "UNPROCESSABLE_ENTITY"),
                TO_MANY_REQUESTS(429, "TO_MANY_REQUESTS"), INTERNAL_SERVER_ERROR(500, "INTERNAL_SERVER_ERROR"),
                    NOT_IMPLEMENTED(501, "NOT_IMPLEMENTED");

    private int numVal;
    private String message;

    Status(int numVal, String message) {
        this.numVal = numVal;
        this.message = message;
    }

    public int getNumVal() {
        return numVal;
    }
    
    public String getMessage() {
        return message;
    }
}
