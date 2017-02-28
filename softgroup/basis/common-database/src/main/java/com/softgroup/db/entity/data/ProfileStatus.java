package com.softgroup.db.entity.data;

import javax.persistence.Entity;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 10:24
 */
@Entity
public class    ProfileStatus {
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String status;

    public ProfileStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
