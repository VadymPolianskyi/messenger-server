package com.softgroup.common.dao.impl.repositories;

import com.softgroup.common.dao.api.entities.ConversationEntity;
import com.softgroup.common.dao.api.entities.ProfileEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;


/**
 * Author: vadym
 * Date: 05.03.17
 * Time: 10:24
 */
public interface ProfileRepository extends PagingAndSortingRepository<ProfileEntity, String> {

    List<ProfileEntity> findByFirstName(String firstName);

    List<ProfileEntity> findByFirstNameAndPhoneNumber(String firstName, String phoneNumber);

    ProfileEntity findByLocaleCode(String localeCode);

    ProfileEntity findByDeviceId(String deviceId);

    ProfileEntity findByPhoneNumber(String phoneNumber);

    ProfileEntity findById(String id);

    @Transactional
    @Modifying
    @Query("update ProfileEntity u set u.firstName = ?1, u.lastName = ?2 where u.id = ?3")
    void updateProfileName(String first, String last, String id);

    @Transactional
    @Modifying
    @Query("update ProfileEntity u set u.avatarUri = 'uri' where u.id = 'id'")
    void changeProfileAvatarUri(String uri, String id);
}
