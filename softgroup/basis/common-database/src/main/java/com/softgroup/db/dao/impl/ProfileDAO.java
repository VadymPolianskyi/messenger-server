package com.softgroup.db.dao.impl;

import com.softgroup.db.dao.api.MessengerDAO;
import com.softgroup.db.dao.api.SessionManager;
import com.softgroup.db.entity.data.Profile;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Author: vadym
 * Date: 28.02.17
 * Time: 19:19
 */
public class ProfileDAO implements MessengerDAO<Profile, String> {

    @Autowired
    private SessionManager sessionManager;

    @Override
    public void update(Profile profile) {
        sessionManager.openCurrentSessionwithTransaction();
        sessionManager.getCurrentSession().update(profile);
        sessionManager.closeCurrentSessionwithTransaction();
    }

    @Override
    public Profile findById(String id) {
        sessionManager.openCurrentSession();
        Profile profile = (Profile) sessionManager.getCurrentSession().get(Profile.class, id);
        sessionManager.closeCurrentSession();
        return profile;

    }

    @Override
    public void delete(Profile profile) {
        sessionManager.openCurrentSessionwithTransaction();
        sessionManager.getCurrentSession().delete(profile);
        sessionManager.closeCurrentSessionwithTransaction();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Profile> findAll() {
        sessionManager.openCurrentSession();
//        List<Profile> profiles = (List<Profile>) sessionManager.getCurrentSession().createQuery("from PROFILE").list();
        sessionManager.closeCurrentSession();
//        return profiles;
        return null;
    }

    @Override
    public void deleteAll() {
        sessionManager.openCurrentSessionwithTransaction();
        List<Profile> profiles = findAll();
        for (Profile profile : profiles) {
            delete(profile);
        }
        sessionManager.closeCurrentSessionwithTransaction();
    }
}
