package com.softgroup.profile.api.message;


import com.softgroup.common.dao.api.entities.ContactEntity;
import com.softgroup.common.protocol.RequestData;

import java.util.List;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 9:35
 */
public class ContactsSyncRequest implements RequestData {
    private List<ContactEntity> addedContactEntities;
    private List<ContactEntity> removedContactEntities;

    public List<ContactEntity> getAddedContactEntities() {
        return addedContactEntities;
    }

    public void setAddedContactEntities(List<ContactEntity> addedContactEntities) {
        this.addedContactEntities = addedContactEntities;
    }

    public List<ContactEntity> getRemovedContactEntities() {
        return removedContactEntities;
    }

    public void setRemovedContactEntities(List<ContactEntity> removedContactEntities) {
        this.removedContactEntities = removedContactEntities;
    }
}
