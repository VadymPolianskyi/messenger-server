package com.softgroup.messenger.api.message.data;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 12:21
 */
public class Conversation {
    private Boolean group;
    private String uuid;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Boolean getGroup() {
        return group;
    }

    public void setGroup(Boolean group) {
        this.group = group;
    }
}
