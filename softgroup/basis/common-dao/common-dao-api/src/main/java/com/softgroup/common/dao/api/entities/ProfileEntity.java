package com.softgroup.common.dao.api.entities;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;


/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 10:24
 */
@Entity
@Table(name = "profiles")
public class ProfileEntity implements Serializable{

    private static final long serialVersionUID = 2645460488213358603L;

    @Id
    @Column(name = "id")
    private String id;

	@Column(name = "phone_number")
    private String phoneNumber;

	@Column(name = "create_date_time")
    private Long createDateTime;

	@Column(name = "update_date_time")
	private Long updateDateTime;

	@Column(name = "first_name")
    private String firstName;

	@Column(name = "last_name")
    private String lastName;

	@Column(name = "status")
    private String status;

	@Column(name = "avatar_uri")
    private String avatarUri;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "profile")
	private List<ProfileSettingsEntity> settingsEntities;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "profile")
	private List<ProfileStatusEntity> statusEntities;

    @OneToMany(fetch = FetchType.EAGER)
    private List<MessageEntity> messageEntities;


    @ManyToMany(fetch = FetchType.EAGER)
    private List<ConversationEntity> conversationEntities;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Long createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Long getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(Long updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAvatarUri() {
        return avatarUri;
    }

    public void setAvatarUri(String avatarUri) {
        this.avatarUri = avatarUri;
    }

    public List<ProfileSettingsEntity> getSettingsEntities() {
        return settingsEntities;
    }

    public void setSettingsEntities(List<ProfileSettingsEntity> settingsEntities) {
        this.settingsEntities = settingsEntities;
    }

    public List<ProfileStatusEntity> getStatusEntities() {
        return statusEntities;
    }

    public void setStatusEntities(List<ProfileStatusEntity> statusEntities) {
        this.statusEntities = statusEntities;
    }

    public List<MessageEntity> getMessageEntities() {
        return messageEntities;
    }

    public void setMessageEntities(List<MessageEntity> messageEntities) {
        this.messageEntities = messageEntities;
    }

    public List<ConversationEntity> getConversationEntities() {
        return conversationEntities;
    }

    public void setConversationEntities(List<ConversationEntity> conversationEntities) {
        this.conversationEntities = conversationEntities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProfileEntity)) return false;

        ProfileEntity that = (ProfileEntity) o;

        if (!id.equals(that.id)) return false;
        if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) return false;
        if (!createDateTime.equals(that.createDateTime)) return false;
        if (updateDateTime != null ? !updateDateTime.equals(that.updateDateTime) : that.updateDateTime != null)
            return false;
        if (!firstName.equals(that.firstName)) return false;
        if (!lastName.equals(that.lastName)) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (avatarUri != null ? !avatarUri.equals(that.avatarUri) : that.avatarUri != null) return false;
        if (!settingsEntities.equals(that.settingsEntities)) return false;
        if (statusEntities != null ? !statusEntities.equals(that.statusEntities) : that.statusEntities != null)
            return false;
        if (messageEntities != null ? !messageEntities.equals(that.messageEntities) : that.messageEntities != null)
            return false;
        return conversationEntities != null ? conversationEntities.equals(that.conversationEntities) : that.conversationEntities == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + createDateTime.hashCode();
        result = 31 * result + (updateDateTime != null ? updateDateTime.hashCode() : 0);
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (avatarUri != null ? avatarUri.hashCode() : 0);
        result = 31 * result + settingsEntities.hashCode();
        result = 31 * result + (statusEntities != null ? statusEntities.hashCode() : 0);
        result = 31 * result + (messageEntities != null ? messageEntities.hashCode() : 0);
        result = 31 * result + (conversationEntities != null ? conversationEntities.hashCode() : 0);
        return result;
    }
}