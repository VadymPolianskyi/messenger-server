package com.softgroup.profile.api.message;

import java.io.Serializable;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 9:09
 */
public abstract class ProfileHeader implements Serializable{
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
