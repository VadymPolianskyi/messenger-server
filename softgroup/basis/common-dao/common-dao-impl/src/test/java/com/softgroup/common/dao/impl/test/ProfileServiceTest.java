package com.softgroup.common.dao.impl.test;

import com.softgroup.common.dao.api.entities.ProfileEntity;
import com.softgroup.common.dao.impl.configuration.CommonDaoAppCfg;
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


    @Test
    public void creatingTest(){
        ProfileEntity profileEntity = new ProfileEntity();

        ProfileEntity profileEntity1 = new ProfileEntity();

        profileEntity.setCreateDateTime(4765387542L);
        profileEntity.setName("dimas");
        profileEntity.setPhoneNumber("047653765");

        profileEntity = profileService.save(profileEntity);

        ProfileEntity profile = profileService.findProfileById("id56477");

    }


    @Test
    public void deleteProfileTest() {
        ProfileEntity profileEntity = new ProfileEntity();


        profileEntity.setCreateDateTime(43538L);
        profileEntity.setName("vadym");
        profileEntity.setPhoneNumber("0953538");

        profileService.save(profileEntity);
        profileService.delete(profileEntity.getId());

    }
}
