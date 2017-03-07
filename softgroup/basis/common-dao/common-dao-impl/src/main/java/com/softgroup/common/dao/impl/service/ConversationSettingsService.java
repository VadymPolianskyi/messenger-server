package com.softgroup.common.dao.impl.service;

import com.softgroup.common.dao.impl.repositories.ConversationSettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Author: vadym
 * Date: 07.03.17
 * Time: 16:42
 */
@Component
public class ConversationSettingsService {
    @Autowired
    ConversationSettingsRepository conversationSettingsRepository;
}