package com.softgroup.common.dao.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Author: vadym
 * Date: 25.02.17
 * Time: 12:21
 */
@Entity
@Table(name = "conversation")
public class ConversationEntity implements Serializable {

    private static final long serialVersionUID = -6612011557733766424L;

    @Id
    @Column(name = "id", unique = true)
    private String id;

    private String name;

    private String logoImageUri;

    private Integer type;

    private Long lastMessageIndex;



}
