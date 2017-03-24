package com.softgroup.common.dao.impl.service;

import com.softgroup.common.dao.api.entities.DeviceEntity;
import com.softgroup.common.dao.impl.repositories.DeviceRepository;
import org.springframework.stereotype.Component;

/**
 * Author: vadym
 * Date: 18.03.17
 * Time: 20:52
 */
@Component
public class DeviceService
        extends  BaseService<DeviceEntity, DeviceRepository> {

    public DeviceEntity insertDevice(DeviceEntity deviceEntity) {
        return getRepository().save(deviceEntity);
    }
    public DeviceEntity findDeviceEntityById(String id) {
        return getRepository().findById(id);
    }
    public void setTimeOfUpdatingOfToken (Long time, String id) {
        getRepository().setTimeOfUpdatingOfToken(time,id);
    }
}
