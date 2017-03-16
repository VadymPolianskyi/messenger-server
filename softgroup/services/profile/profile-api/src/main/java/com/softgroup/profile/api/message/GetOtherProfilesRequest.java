package com.softgroup.profile.api.message;

import com.softgroup.common.protocol.RequestData;

import java.util.List;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 10:15
 */
public class GetOtherProfilesRequest implements RequestData {
    public List<String> userID;

    public List<String> getUserID() {
        return userID;
    }

    public void setUserID(List<String> userID) {
        this.userID = userID;
    }
}
