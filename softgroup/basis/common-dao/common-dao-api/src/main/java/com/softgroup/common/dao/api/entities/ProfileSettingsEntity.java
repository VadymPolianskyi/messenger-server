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

    @ManyToOne(fetch = FetchType.EAGER)
    private ProfileEntity profileEntity;

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

    public ProfileEntity getProfile() {
        return profileEntity;
    }

    public void setProfile(ProfileEntity profile) {
        this.profileEntity = profile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProfileSettingsEntity)) return false;

        ProfileSettingsEntity that = (ProfileSettingsEntity) o;

        if (!id.equals(that.id)) return false;
        if (settingsData != null ? !settingsData.equals(that.settingsData) : that.settingsData != null) return false;
        return profileEntity.equals(that.profileEntity);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (settingsData != null ? settingsData.hashCode() : 0);
        result = 31 * result + profileEntity.hashCode();
        return result;
    }
}