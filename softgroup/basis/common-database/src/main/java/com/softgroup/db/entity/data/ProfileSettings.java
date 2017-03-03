package com.softgroup.db.entity.data;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 10:18
 */
@Entity(name = "profile_settings")
public class ProfileSettings {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "id", unique = true)
    private long id;
    private String settings;

    public String getSettings() {
        return settings;
    }

    public void setSettings(String settings) {
        this.settings = settings;
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


}
