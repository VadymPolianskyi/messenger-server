package com.softgroup.db.entity.data;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Author: vadym
 * Date: 27.02.17
 * Time: 21:02
 */
@Entity(name="user_conversation_details")
public class ConversationDetails {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "id", unique = true)
    private String id;



    private Date dateOfCreation;
    private String title;

    @OneToOne
    private Message cursor;


    public String getId() {
        return id;
    }

}
