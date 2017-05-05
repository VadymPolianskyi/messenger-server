package com.softgroup.common.dao.impl.service;

import com.softgroup.common.dao.api.entities.ContactEntity;
import com.softgroup.common.dao.impl.repositories.ContactRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Author: vadym
 * Date: 07.03.17
 * Time: 16:40
 */
@Component
public class ContactService extends BaseService<ContactEntity, ContactRepository> {

    public ContactEntity findByNameAndProfileIdAndPhoneNumber(String name, String profileId, String phoneNumber){
        return getRepository().findByNameAndProfileIdAndPhoneNumber();
    }

    public List<ContactEntity> findByProfileId(String profileId) {
        return getRepository().findByProfileId(profileId);
    }
}
