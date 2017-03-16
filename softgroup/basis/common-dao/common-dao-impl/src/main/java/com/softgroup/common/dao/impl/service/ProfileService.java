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
public class ProfileService {
    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    ProfileSettingsService profileSettingsService;

    public ProfileEntity insertProfile(ProfileEntity profileEntity) {
        return profileRepository.save(profileEntity);
    }

    public void changeAvatarUri(String uri, String id) {
        profileRepository.changeProfileAvatarUri(uri, id);
    }

    public void deleteProfile(ProfileEntity profileEntity) {
        profileRepository.delete(profileEntity);
    }

    public void deleteProfile(String id) {
        ProfileEntity profileEntity = profileRepository.findById(id);

        if (profileEntity.getSettingsEntities() !=null) {
            profileSettingsService.deleteSettings(profileEntity.getSettingsEntities());
        }


        profileRepository.delete(id);
    }

    public List<ProfileEntity> findByFirstNameAndPhoneNumber(String firstName, String phoneNumber){
        return profileRepository.findByFirstNameAndPhoneNumber(firstName, phoneNumber);
    }

    public ProfileEntity findByLocaleCode(String localeCode) {
        return profileRepository.findByLocaleCode(localeCode);
    }

    public ProfileEntity findByDeviceId(String deviceId) {
        return profileRepository.findByDeviceId(deviceId);
    }

    public ProfileEntity findByPhoneNumber(String phoneNumber) {
        return profileRepository.findByPhoneNumber(phoneNumber);
    }

    public void changeProfileName(String firstName, String lastName, String id) {
        profileRepository.updateProfileName(firstName,lastName,id);
    }

    public ProfileEntity findProfileById(String id) {
        return  profileRepository.findById(id);
    }

}
