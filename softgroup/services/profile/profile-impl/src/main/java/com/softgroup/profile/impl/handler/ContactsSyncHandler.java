package com.softgroup.profile.impl.handler;

import com.softgroup.common.dao.api.entities.ContactEntity;
import com.softgroup.common.dao.impl.service.ContactService;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseStatus;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.model.maper.ContactDTO;
import com.softgroup.profile.api.message.ContactsSyncRequest;
import com.softgroup.profile.api.message.ContactsSyncResponse;
import com.softgroup.profile.api.message.GetContactProfilesRequest;
import com.softgroup.profile.api.message.GetContactProfilesResponse;
import com.softgroup.profile.api.router.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 11:41
 */
@Component
public class ContactsSyncHandler
        extends AbstractRequestHandler<ContactsSyncRequest,
                ContactsSyncResponse> implements ProfileRequestHandler {

    @Autowired
    private ContactService contactService;

    public String getName() {
        return "contacts_sync";
    }

    @Override
    public Response<ContactsSyncResponse> doHandle(Request<ContactsSyncRequest> request) {
        ContactsSyncRequest requestData = request.getData();
        ContactsSyncResponse contactsSyncResponse = new ContactsSyncResponse();

        String profileId = request.getRoutingData().getProfileId();
        addContacts(requestData.getAddedContacts(), profileId);
        removeContacts(requestData.getRemovedContacts(), profileId);

        Response<ContactsSyncResponse> response = new Response<ContactsSyncResponse>();
        response.setHeader(request.getHeader());
        response.setData(contactsSyncResponse);

        ResponseStatus status = new ResponseStatus();
        status.setCode(200);
        status.setMessage("OK");
        response.setStatus(status);
        return response;
    }

    private void addContacts(List<ContactDTO> addContacts, String profileId) {
        for (ContactDTO addContact : addContacts) {
            ContactEntity contactEntity =
                    contactService.findByNameAndProfileId(addContact.getName(), profileId);
            if (contactEntity == null) {
                ContactEntity currentContact = new ContactEntity();
                currentContact.setName(addContact.getName());
                currentContact.setData(addContact.getPhoneNumber());
                contactService.insert(currentContact);
            }
        }

    }

    private void removeContacts(List<ContactDTO> removeContacts, String profileId) {
        for (ContactDTO removeContact : removeContacts) {
            ContactEntity contactEntity =
                    contactService.findByNameAndProfileId(removeContact.getName(), profileId);
            if (contactEntity != null) {
                contactService.remove(contactEntity);
            }
        }
    }
}
