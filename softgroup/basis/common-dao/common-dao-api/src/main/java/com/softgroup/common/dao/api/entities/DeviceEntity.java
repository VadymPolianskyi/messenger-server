package com.softgroup.common.dao.api.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Author: vadym
 * Date: 15.03.17
 * Time: 19:51
 */
@Entity
@Table(name = "device")
public class DeviceEntity  implements Serializable {

    private static final long serialVersionUID = 7834796409815852123L;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", unique = true)
    private String id;

    @Column(name = "locale_code")
    private String locale_code;

    @Column(name = "device_id")
    private String deviceId;

    @Column(name = "update_date_time")
    private Long updateDateTime;

    @Column(name = "profile_id")
    private String profileId;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public String getLocale_code() {
        return locale_code;
    }

    public void setLocale_code(String locale_code) {
        this.locale_code = locale_code;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Long getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(Long updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeviceEntity that = (DeviceEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (locale_code != null ? !locale_code.equals(that.locale_code) : that.locale_code != null) return false;
        if (deviceId != null ? !deviceId.equals(that.deviceId) : that.deviceId != null) return false;
        if (updateDateTime != null ? !updateDateTime.equals(that.updateDateTime) : that.updateDateTime != null)
            return false;
        return profileId != null ? profileId.equals(that.profileId) : that.profileId == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (locale_code != null ? locale_code.hashCode() : 0);
        result = 31 * result + (deviceId != null ? deviceId.hashCode() : 0);
        result = 31 * result + (updateDateTime != null ? updateDateTime.hashCode() : 0);
        result = 31 * result + (profileId != null ? profileId.hashCode() : 0);
        return result;
    }
}
