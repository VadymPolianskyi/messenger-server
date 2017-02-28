package com.softgroup.model.maper;

import com.softgroup.db.entity.data.Profile;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Author: vadym
 * Date: 28.02.17
 * Time: 18:55
 */
public class Mapper {

    @Autowired
    ModelMapper modelMapper;
    public ProfileDTO map(Profile profile) {
        return modelMapper.map(profile, ProfileDTO.class);
    }
}
