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

import java.util.Arrays;
import java.util.List;

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
        profileEntity.setId("id56477");
        profileEntity.setFirstName("Anastasia");
        profileEntity.setLastName("Manich");

        ProfileEntity profileEntity1 = new ProfileEntity();
        profileEntity1.setId("id5758");
        profileEntity1.setFirstName("Vadym");
        profileEntity1.setLastName("Polyanski");

        profileEntity = profileService.insertProfile(profileEntity);
        profileEntity1 = profileService.insertProfile(profileEntity1);

        ProfileSettingsEntity settingsEntity = new ProfileSettingsEntity();
        settingsEntity.setId("1");
        settingsEntity.setSettingsData("data_1");
        settingsEntity.setProfile(profileEntity);

        ProfileSettingsEntity settingsEntity1 = new ProfileSettingsEntity();
        settingsEntity1.setId("2");
        settingsEntity1.setSettingsData("dfffffaaaaata_2");
        settingsEntity1.setProfile(profileEntity);

        settingsEntity = profileSettingsRepository.save(settingsEntity);
        settingsEntity1 = profileSettingsRepository.save(settingsEntity1);

        profileEntity.setSettingsEntities(Arrays.asList(settingsEntity, settingsEntity1));

        profileEntity = profileService.insertProfile(profileEntity);
        ProfileEntity profile = profileService.findProfileById("id56477");

        List<ProfileSettingsEntity> settings = profile.getSettingsEntities();
    }

    @Test
    public void changeNameTest() {
        profileService.changeProfileName("Lady", "Gaga", "id5758");
        profileService.changeProfileName("Brad", "Pit", "id56477");
    }

    @Test
    public void deleteProfileTest() {
        ProfileEntity profileEntity = new ProfileEntity();
        profileEntity.setId("id35737");
        profileEntity.setFirstName("some");
        profileEntity.setLastName("person");

        ProfileEntity profileEntity1 = new ProfileEntity();
        profileEntity1.setId("id47836");
        profileEntity1.setFirstName("another");
        profileEntity1.setLastName("fdgh");

        profileService.insertProfile(profileEntity);
        profileService.insertProfile(profileEntity1);
        profileService.deleteProfile(profileEntity);

        profileService.deleteProfile("id47836");
        profileService.deleteProfile("id56477");

    }
}
