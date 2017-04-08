package com.softgroup.profile.impl.handler;

import com.softgroup.common.dao.api.entities.ContactEntity;
import com.softgroup.common.dao.impl.service.ContactService;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseStatus;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.model.maper.ContactDTO;
import com.softgroup.model.maper.Mapper;
import com.softgroup.profile.api.message.GetContactProfilesRequest;
import com.softgroup.profile.api.message.GetContactProfilesResponse;
import com.softgroup.profile.api.router.ProfileRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 11:44
 */
@Component
public class GetContactProfilesHandler
        extends AbstractRequestHandler<GetContactProfilesRequest,
            GetContactProfilesResponse> implements ProfileRequestHandler {

    @Autowired
    private ContactService contactService;

    @Autowired
    private Mapper mapper;

    public String getName() {
        return "get_contact_profiles";
    }


    @Override
    public Response<GetContactProfilesResponse> doHandle(Request<GetContactProfilesRequest> request) {
        GetContactProfilesRequest requestData = request.getData();
        GetContactProfilesResponse getContactProfilesResponse = new GetContactProfilesResponse();

        String profileId = request.getRoutingData().getProfileId();
        List<ContactDTO>  contactDTOS = getContactDTOs(profileId);
        getContactProfilesResponse.setContactDTOS(contactDTOS);

        Response<GetContactProfilesResponse> response = new Response<GetContactProfilesResponse>();
        response.setHeader(request.getHeader());
        response.setData(getContactProfilesResponse);

        ResponseStatus status = new ResponseStatus();
        status.setCode(200);
        status.setMessage("OK");
        response.setStatus(status);
        return response;
    }

    private List<ContactDTO> getContactDTOs(String profileId) {
        List<ContactDTO>  contactDTOS = new ArrayList<>();
        List<ContactEntity> contactEntities = contactService.findByProfileId(profileId);

        for (ContactEntity contactEntity : contactEntities) {
            contactDTOS.add(mapper.mapContact(contactEntity));
        }

        return contactDTOS;
    }
}
