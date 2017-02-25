package com.softgroup.messenger.api.message.data;

import com.softgroup.common.protocol.Data;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 17:24
 */
public class Message {
    private String dispatcherID;
    private String text;

    public String getDispatcherID() {
        return dispatcherID;
    }

    public void setDispatcherID(String dispatcherID) {
        this.dispatcherID = dispatcherID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    private Data data;
}
