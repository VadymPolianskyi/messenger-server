package com.softgroup.model.maper;

import com.softgroup.db.entity.data.ProfileStatus;

/**
 * Author: vadym
 * Date: 27.02.17
 * Time: 19:12
 */
public class ProfileDTO {
    private String firstName;
    private String lastName;
    private ProfileStatus profileStatus;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ProfileStatus getProfileStatus() {
        return profileStatus;
    }

    public void setProfileStatus(ProfileStatus profileStatus) {
        this.profileStatus = profileStatus;
    }
}
