package com.softgroup.model.maper;

import com.softgroup.common.dao.api.entities.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: vadym
 * Date: 28.02.17
 * Time: 18:55
 */
public class Mapper {

    @Autowired
    ModelMapper modelMapper;

    public ProfileDTO mapProfile(ProfileEntity profileEntity) {
        return modelMapper.map(profileEntity, ProfileDTO.class);
    }

    public ConversationDTO mapConversation(ConversationEntity conversationEntity) {
        return modelMapper.map(conversationEntity, ConversationDTO.class);
    }

    public MessageDTO mapMessage(MessageEntity messageEntity){
        return modelMapper.map(messageEntity, MessageDTO.class);
    }

    public ProfileSettingsDTO mapProfileSettings(ProfileSettingsEntity profileSettingsEntity) {
        return modelMapper.map(profileSettingsEntity, ProfileSettingsDTO.class);
    }

    public ContactDTO mapContact(ContactEntity contactEntity) {
        return modelMapper.map(contactEntity, ContactDTO.class);
    }
}
