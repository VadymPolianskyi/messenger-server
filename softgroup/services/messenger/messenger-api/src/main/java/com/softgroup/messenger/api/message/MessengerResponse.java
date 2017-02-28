package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.Response;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 19:22
 */
public abstract class MessengerResponse extends Response {
    public MessengerResponse() {
        getHeader().setType("messenger");
    }
}
