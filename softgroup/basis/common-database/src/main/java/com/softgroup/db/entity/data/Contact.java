package com.softgroup.db.entity.data;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 9:24
 */
public class Contact {
    private int id;
    private Profile profile;
    private String name;
    private Profile contact;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Profile getContact() {
        return contact;
    }

    public void setContact(Profile contact) {
        this.contact = contact;
    }
}
