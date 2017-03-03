package com.softgroup.profile.api.message;

import com.softgroup.common.protocol.Request;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 9:34
 */
public abstract class ProfileRequest extends Request{
    public ProfileRequest() {
        getHeader().setType("profile");
    }
}
