package com.softgroup.model.maper;

import com.softgroup.common.dao.api.entities.BaseEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Author: vadym
 * Date: 28.02.17
 * Time: 18:55
 */
public class Mapper<T extends BaseEntity, R> {

    @Autowired
    ModelMapper modelMapper;

    public R map(T base, Class<R> classToMapping) {
        return modelMapper.map(base,classToMapping);
    }

    public T mapRevert(R base, Class<T> classToMapping) {
        return modelMapper.map(base,classToMapping);
    }
}
