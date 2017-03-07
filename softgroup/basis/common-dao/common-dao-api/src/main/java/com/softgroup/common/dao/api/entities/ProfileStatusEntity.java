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
public class ProfileStatusEntity implements Serializable{

    private static final long serialVersionUID = -6115361704804850552L;

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "status")
    private String status;

    @OneToOne(fetch = FetchType.EAGER)
    private ProfileEntity profile;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ProfileEntity getProfile() {
        return profile;
    }

    public void setProfile(ProfileEntity profile) {
        this.profile = profile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProfileStatusEntity)) return false;

        ProfileStatusEntity that = (ProfileStatusEntity) o;

        if (!id.equals(that.id)) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        return profile.equals(that.profile);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + profile.hashCode();
        return result;
    }
}
