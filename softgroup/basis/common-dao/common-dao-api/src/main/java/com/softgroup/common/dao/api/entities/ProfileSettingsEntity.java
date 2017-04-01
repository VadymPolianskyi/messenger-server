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
public class ProfileSettingsEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 2645460488213358603L;

    @Column(name = "settings_data")
    private String settingsData;

    public String getSettingsData() {
        return settingsData;
    }

    public void setSettingsData(String settingsData) {
        this.settingsData = settingsData;
    }
}