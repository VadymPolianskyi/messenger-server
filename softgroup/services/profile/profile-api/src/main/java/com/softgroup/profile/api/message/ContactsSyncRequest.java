package com.softgroup.profile.api.message;

import com.softgroup.profile.api.message.data.Contact;

import java.util.List;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 9:35
 */
public class ContactsSyncRequest extends ProfileRequest {
    private List<Contact> addedContacts;
    private List<Contact> removedContacts;

    public List<Contact> getAddedContacts() {
        return addedContacts;
    }

    public void setAddedContacts(List<Contact> addedContacts) {
        this.addedContacts = addedContacts;
    }

    public List<Contact> getRemovedContacts() {
        return removedContacts;
    }

    public void setRemovedContacts(List<Contact> removedContacts) {
        this.removedContacts = removedContacts;
    }



    public void addContact(Contact contact) {
        addedContacts.add(contact);
    }

    public void removeContact(int index) {
        removedContacts.add(addedContacts.remove(index));
    }

}
