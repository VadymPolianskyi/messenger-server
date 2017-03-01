package com.softgroup.db.dao.impl;

import com.softgroup.db.dao.api.MessengerDAO;
import com.softgroup.db.entity.data.Profile;
import com.softgroup.db.repository.ProfileCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

/**
 * Author: vadym
 * Date: 28.02.17
 * Time: 19:19
 */
public class ProfileDAO implements MessengerDAO<Profile, String> {

    @Autowired
    private ProfileCrudRepository profileCrudRepository;

    @Override
    public void update(Profile profile) {
        profileCrudRepository.save(profile);
    }

    @Override
    public Profile findById(String id) {
        Profile profile = profileCrudRepository.findOne(UUID.fromString(id));
        return profile;

    }

    @Override
    public void delete(Profile profile) {
        profileCrudRepository.delete(profile);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Profile> findAll() {
        List<Profile> profiles = profileCrudRepository.findAll();
        return profiles;
    }

    @Override
    public void deleteAll() {
        List<Profile> profiles = findAll();
        for (Profile profile : profiles) {
            delete(profile);
        }
    }

    @Override
    public void insert(Profile profile) {
        profileCrudRepository.save(profile);
    }
}
