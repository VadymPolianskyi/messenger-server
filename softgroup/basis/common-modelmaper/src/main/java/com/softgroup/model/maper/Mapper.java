package com.softgroup.model.maper;

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

    public Object map(Object base, Class classToMapping) {
        return modelMapper.map(base,classToMapping);
    }
}
