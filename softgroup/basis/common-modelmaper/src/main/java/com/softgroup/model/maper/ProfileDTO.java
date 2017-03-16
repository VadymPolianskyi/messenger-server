package com.softgroup.model.maper;


import com.softgroup.common.dao.api.entities.ProfileStatusEntity;

/**
 * Author: vadym
 * Date: 27.02.17
 * Time: 19:12
 */
public class ProfileDTO {
    private String firstName;
    private String lastName;
    private ProfileStatusEntity profileStatusEntity;

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

    public ProfileStatusEntity getProfileStatusEntity() {
        return profileStatusEntity;
    }

    public void setProfileStatusEntity(ProfileStatusEntity profileStatusEntity) {
        this.profileStatusEntity = profileStatusEntity;
    }
}
