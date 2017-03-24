package com.softgroup.common.dao.api.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Author: vadym
 * Date: 27.02.17
 * Time: 21:02
 */
@Entity
@Table(name = "conversation_details")
public class ConversationDetailsEntity implements Serializable {

    private static final long serialVersionUID = -4252569167518812471L;

    @Id
    @Column(name = "id", unique = true)
    private String id;


    @Column(name = "date")
    private Date dateOfCreation;

    @Column(name = "title")
    private String title;


}
