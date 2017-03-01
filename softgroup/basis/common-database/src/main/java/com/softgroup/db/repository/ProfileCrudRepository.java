package com.softgroup.db.repository;

import com.softgroup.db.entity.data.Profile;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

/**
 * Author: vadym
 * Date: 01.03.17
 * Time: 8:39
 */
public interface ProfileCrudRepository extends CrudRepository<Profile, UUID> {
    public List<Profile> findAll();
}
