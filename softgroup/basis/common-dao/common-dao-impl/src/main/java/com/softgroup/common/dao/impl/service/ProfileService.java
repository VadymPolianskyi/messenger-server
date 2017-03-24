package com.softgroup.common.dao.impl.service;

import com.softgroup.common.dao.api.entities.ProfileEntity;
import com.softgroup.common.dao.impl.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Author: vadym
 * Date: 07.03.17
 * Time: 16:40
 */
@Component
public class ProfileService {
    @Autowired
    ProfileRepository profileRepository;

    public ProfileEntity insertProfile(ProfileEntity profileEntity) {
        return profileRepository.save(profileEntity);
    }


    public void deleteProfile(ProfileEntity profileEntity) {
        profileRepository.delete(profileEntity);
    }



    public ProfileEntity findByPhoneNumber(String phoneNumber) {
        return profileRepository.findByPhoneNumber(phoneNumber);
    }

    public ProfileEntity findProfileById(String id) {
        return  profileRepository.findById(id);
    }

}
