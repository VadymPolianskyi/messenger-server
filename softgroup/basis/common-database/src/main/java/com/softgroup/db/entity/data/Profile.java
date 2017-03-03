package com.softgroup.db.entity.data;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 9:17
 */
@Entity(name = "profile")
public class Profile {

    public Profile() {
    }

//    public Profile(String firstName, String lastName, String localeCode, String deviceId) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.localeCode = localeCode;
//        this.deviceId = deviceId;
//    }

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "id", unique = true)
    private String id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String localeCode;

    @Column(nullable = false)
    private String deviceId;

    @OneToOne
    private ProfileSettings settings;

    @OneToOne
    private ProfileStatus status;

    @OneToMany(mappedBy="auhtor",targetEntity = Message.class)
    private List<Message> messages;

//    private List<Contact> contacts;
//    private List<Conversation> conversations;


    public String getId() {
        return id;
    }

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

    public String getLocaleCode() {
        return localeCode;
    }

    public void setLocaleCode(String localeCode) {
        this.localeCode = localeCode;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public ProfileSettings getProfileSettings() {
        return settings;
    }

    public void setProfileSettings(ProfileSettings profileSettings) {
        this.settings = profileSettings;
    }

    public ProfileStatus getProfileStatus() {
        return status;
    }

    public void setProfileStatus(ProfileStatus profileStatus) {
        this.status = profileStatus;
    }

//    public List<Contact> getContacts() {
//        return contacts;
//    }

//    public void setContacts(List<Contact> contacts) {
//        this.contacts = contacts;
//    }
}
