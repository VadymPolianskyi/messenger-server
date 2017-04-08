package com.softgroup.profile.api.message;


import com.softgroup.common.dao.api.entities.ContactEntity;
import com.softgroup.common.dao.api.entities.ProfileEntity;
import com.softgroup.common.protocol.ResponseData;
import com.softgroup.model.maper.ContactDTO;

import java.util.List;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 10:09
 */
public class GetContactProfilesResponse implements ResponseData {
    private List<ContactDTO> contactDTOS;

    public List<ContactDTO> getContactDTOS() {
        return contactDTOS;
    }

    public void setContactDTOS(List<ContactDTO> contactDTOS) {
        this.contactDTOS = contactDTOS;
    }
}
