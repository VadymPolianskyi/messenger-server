package com.softgroup.profile.api.message;

import com.softgroup.common.protocol.Response;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 16:53
 */
public abstract class ProfileResponse extends Response {
    public ProfileResponse() {
        getHeader().setType("profile");
    }
}
