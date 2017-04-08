package com.softgroup.profile.api.message;


import com.softgroup.common.dao.api.entities.ContactEntity;
import com.softgroup.common.protocol.RequestData;
import com.softgroup.model.maper.ContactDTO;

import java.util.List;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 9:35
 */
public class ContactsSyncRequest implements RequestData {

    private List<ContactDTO> addedContacts;

    private List<ContactDTO> removedContacts;

    public List<ContactDTO> getAddedContacts() {
        return addedContacts;
    }

    public void setAddedContacts(List<ContactDTO> addedContacts) {
        this.addedContacts = addedContacts;
    }

    public List<ContactDTO> getRemovedContacts() {
        return removedContacts;
    }

    public void setRemovedContacts(List<ContactDTO> removedContacts) {
        this.removedContacts = removedContacts;
    }
}
