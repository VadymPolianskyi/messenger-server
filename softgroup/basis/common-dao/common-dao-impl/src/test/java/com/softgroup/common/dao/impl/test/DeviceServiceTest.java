package com.softgroup.common.dao.impl.test;

import com.softgroup.common.dao.api.entities.DeviceEntity;
import com.softgroup.common.dao.api.entities.ProfileEntity;
import com.softgroup.common.dao.impl.configuration.CommonDaoAppCfg;
import com.softgroup.common.dao.impl.service.DeviceService;
import com.softgroup.common.dao.impl.service.ProfileService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by vadym_polyanski on 22.03.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CommonDaoAppCfg.class})
public class DeviceServiceTest {


    @Autowired
    private ProfileService profileService;

    @Autowired
    private DeviceService deviceService;
    private String id;


    @Test
    public void creatingTest() {
        ProfileEntity profileEntity = new ProfileEntity();
        profileEntity.setCreateDateTime(4765387542L);
        profileEntity.setName("dimas");
        profileEntity.setPhoneNumber("047653765");
        profileEntity = profileService.insertProfile(profileEntity);

        DeviceEntity deviceEntity = new DeviceEntity();
        deviceEntity.setUpdateDateTime(892482L);
        deviceEntity.setDeviceId("48924ifo3902");
        deviceEntity.setLocale_code("UA");
        deviceEntity.setProfileId(profileEntity.getId());
        deviceEntity = deviceService.insertDevice(deviceEntity);
        this.id = deviceEntity.getId();
    }


    @Test
    public void updateTokenTime() {
        deviceService.setTimeOfUpdatingOfToken(384294535L, id);
    }
}
