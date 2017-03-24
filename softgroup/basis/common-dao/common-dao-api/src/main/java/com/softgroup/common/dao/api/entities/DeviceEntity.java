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

//    @ManyToOne(fetch = FetchType.EAGER)
//    private ProfileEntity profileEntity;

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
    //    public ProfileEntity getProfileEntity() {
//        return profileEntity;
//    }

//    public void setProfileEntity(ProfileEntity profileEntity) {
//        this.profileEntity = profileEntity;
//    }

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
}
