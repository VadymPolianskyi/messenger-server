package com.softgroup.common.dao.impl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * Author: vadym
 * Date: 17.03.17
 * Time: 14:58
 */
@NoRepositoryBean
public interface BaseRepository<T extends Serializable> extends JpaRepository<T,String> {
}
