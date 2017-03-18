package com.softgroup.common.dao.impl.test;

import com.softgroup.common.dao.api.entities.ProfileEntity;
import com.softgroup.common.dao.api.entities.ProfileSettingsEntity;
import com.softgroup.common.dao.impl.configuration.CommonDaoAppCfg;
import com.softgroup.common.dao.impl.repositories.ProfileSettingsRepository;
import com.softgroup.common.dao.impl.service.ProfileService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Odin on 04.03.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CommonDaoAppCfg.class})
public class ProfileServiceTest {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private ProfileSettingsRepository profileSettingsRepository;

    @Test
    public void creatingTest(){
        ProfileEntity profileEntity = new ProfileEntity();

        ProfileEntity profileEntity1 = new ProfileEntity();

        profileEntity = profileService.insertProfile(profileEntity);
        profileEntity1 = profileService.insertProfile(profileEntity1);

        ProfileSettingsEntity settingsEntity = new ProfileSettingsEntity();
        settingsEntity.setId("1");
        settingsEntity.setSettingsData("data_1");

        ProfileSettingsEntity settingsEntity1 = new ProfileSettingsEntity();
        settingsEntity1.setId("2");
        settingsEntity1.setSettingsData("dfffffaaaaata_2");

        settingsEntity = profileSettingsRepository.save(settingsEntity);
        settingsEntity1 = profileSettingsRepository.save(settingsEntity1);


        profileEntity = profileService.insertProfile(profileEntity);
        ProfileEntity profile = profileService.findProfileById("id56477");

    }


    @Test
    public void deleteProfileTest() {
        ProfileEntity profileEntity = new ProfileEntity();

        ProfileEntity profileEntity1 = new ProfileEntity();

        profileService.insertProfile(profileEntity);
        profileService.insertProfile(profileEntity1);
        profileService.deleteProfile(profileEntity);

    }
}
