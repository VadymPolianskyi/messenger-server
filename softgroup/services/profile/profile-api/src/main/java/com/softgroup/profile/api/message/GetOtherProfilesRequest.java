package com.softgroup.profile.api.message;

import java.util.List;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 10:15
 */
public class GetOtherProfilesRequest extends Command {
    public List<Integer> userID;

    public List<Integer> getUserID() {
        return userID;
    }

    public void setUserID(List<Integer> userID) {
        this.userID = userID;
    }
}
