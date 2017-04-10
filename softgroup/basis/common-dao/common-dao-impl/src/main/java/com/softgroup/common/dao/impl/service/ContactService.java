package com.softgroup.common.dao.impl.service;

import com.softgroup.common.dao.api.entities.ContactEntity;
import com.softgroup.common.dao.impl.repositories.ContactRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: vadym
 * Date: 07.03.17
 * Time: 16:40
 */
@Component
public class ContactService extends BaseService<ContactEntity, ContactRepository> {

    public ContactEntity findByNameAndProfileId(String name, String profileId) {
        return new ContactEntity();
    }

    public ContactEntity insert(ContactEntity contactEntity) {
        return getRepository().save(contactEntity);
    }

    public void remove(ContactEntity contactEntity) {
        getRepository().delete(contactEntity.getId());
    }

    public List<ContactEntity> findByProfileId(String profileId) {
        return getRepository().findAll();
    }
}
