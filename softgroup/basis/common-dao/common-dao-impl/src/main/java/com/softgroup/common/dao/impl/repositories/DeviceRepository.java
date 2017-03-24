package com.softgroup.common.dao.impl.repositories;

import com.softgroup.common.dao.api.entities.DeviceEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * Author: vadym
 * Date: 18.03.17
 * Time: 20:52
 */
public interface DeviceRepository extends BaseRepository<DeviceEntity>  {
    DeviceEntity findById(String id);

    @Transactional
    @Modifying
    @Query("update DeviceEntity dev set dev.updateDateTime = ?1 where dev.id = ?2")
    void setTimeOfUpdatingOfToken(Long time, String id);
}
