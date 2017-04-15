package com.softgroup.messenger.api.dto;

/**
 * Author: vadym_polyanski
 * Date: 14.04.17
 * Time: 16:42
 */
public class ConversationSettingsDTO {
    private String adminId;

    private String name;

    private String logo;

    private String conversationId;

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }
}
