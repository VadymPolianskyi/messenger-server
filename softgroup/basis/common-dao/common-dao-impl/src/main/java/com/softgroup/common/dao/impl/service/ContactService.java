package com.softgroup.common.dao.impl.service;

import com.softgroup.common.dao.impl.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Author: vadym
 * Date: 07.03.17
 * Time: 16:40
 */
@Component
public class ContactService {
    @Autowired
    ContactRepository contactRepository;
}
