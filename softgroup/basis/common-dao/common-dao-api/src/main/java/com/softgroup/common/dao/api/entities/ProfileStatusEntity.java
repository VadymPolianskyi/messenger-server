package com.softgroup.common.dao.api.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 10:24
 */
@Entity
@Table(name = "profile_status")
public class ProfileStatusEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -6115361704804850552L;

    @Column(name = "profile_id")
    private String profileId;

    @Column(name = "is_online")
    private Boolean isOnline;

    @Column(name = "last_time_online")
    private Long lastTimeOnline;

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public Boolean getOnline() {
        return isOnline;
    }

    public void setOnline(Boolean online) {
        isOnline = online;
    }

    public Long getLastTimeOnline() {
        return lastTimeOnline;
    }

    public void setLastTimeOnline(Long lastTimeOnline) {
        this.lastTimeOnline = lastTimeOnline;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProfileStatusEntity that = (ProfileStatusEntity) o;

        if (profileId != null ? !profileId.equals(that.profileId) : that.profileId != null) return false;
        if (isOnline != null ? !isOnline.equals(that.isOnline) : that.isOnline != null) return false;
        return lastTimeOnline != null ? lastTimeOnline.equals(that.lastTimeOnline) : that.lastTimeOnline == null;
    }

    @Override
    public int hashCode() {
        int result = profileId != null ? profileId.hashCode() : 0;
        result = 31 * result + (isOnline != null ? isOnline.hashCode() : 0);
        result = 31 * result + (lastTimeOnline != null ? lastTimeOnline.hashCode() : 0);
        return result;
    }
}
