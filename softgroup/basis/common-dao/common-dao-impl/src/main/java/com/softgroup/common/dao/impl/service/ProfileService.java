package com.softgroup.common.dao.impl.service;

import com.softgroup.common.dao.api.entities.ProfileEntity;
import com.softgroup.common.dao.impl.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Author: vadym
 * Date: 07.03.17
 * Time: 16:40
 */
@Component
public class ProfileService extends BaseService<ProfileEntity, ProfileRepository> {

    @Autowired
    ProfileSettingsService profileSettingsService;

    public ProfileEntity insertProfile(ProfileEntity profileEntity) {
        return getRepository().save(profileEntity);
    }


    public void deleteProfile(ProfileEntity profileEntity) {
        getRepository().delete(profileEntity);
    }

    public void deleteProfile(String id) {
        ProfileEntity profileEntity = getRepository().findById(id);

        if (profileEntity.getSettingsEntities() !=null) {
            profileSettingsService.deleteSettings(profileEntity.getSettingsEntities());
        }


        getRepository().delete(id);
    }

    public List<ProfileEntity> findByFirstNameAndPhoneNumber(String firstName, String phoneNumber){
        return getRepository().findByFirstNameAndPhoneNumber(firstName, phoneNumber);
    }

    public ProfileEntity findByLocaleCode(String localeCode) {
        return getRepository().findByLocaleCode(localeCode);
    }

    public ProfileEntity findByDeviceId(String deviceId) {
        return getRepository().findByDeviceId(deviceId);
    }

    public ProfileEntity findByPhoneNumber(String phoneNumber) {
        return getRepository().findByPhoneNumber(phoneNumber);
    }

    public ProfileEntity findProfileById(String id) {
        return  getRepository().findById(id);
    }

}
