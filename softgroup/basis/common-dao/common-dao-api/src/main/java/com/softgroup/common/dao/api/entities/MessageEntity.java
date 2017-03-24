package com.softgroup.common.dao.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 17:24
 */
@Entity
@Table(name = "message")
public class MessageEntity implements Serializable {

    private static final long serialVersionUID = -4749434979191853677L;

    @Id
    @Column(name = "id", unique = true)
    private String  id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
