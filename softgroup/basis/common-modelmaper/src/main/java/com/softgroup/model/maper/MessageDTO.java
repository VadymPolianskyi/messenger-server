package com.softgroup.model.maper;

import com.softgroup.common.dao.api.entities.types.MessageType;
/**
 * Author: vadym_polyanski
 * Date: 08.04.17
 * Time: 22:38
 */
public class MessageDTO {

    private String senderId;

    private String conversationId;

    private String payload;

    private MessageType type;

    private Long createDate;

    private Long serverReceiveDate;
}
