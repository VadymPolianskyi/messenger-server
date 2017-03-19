package com.softgroup.common.dao.api.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 10:24
 */
@Entity
@Table(name = "profile_settings")
public class ProfileSettingsEntity implements Serializable {

    private static final long serialVersionUID = 2645460488213358603L;

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "settings_data")
    private String settingsData;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSettingsData() {
        return settingsData;
    }

    public void setSettingsData(String settingsData) {
        this.settingsData = settingsData;
    }
}