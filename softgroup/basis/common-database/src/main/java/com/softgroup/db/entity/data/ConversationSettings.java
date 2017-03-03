package com.softgroup.db.entity.data;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * Author: vadym
 * Date: 27.02.17
 * Time: 21:02
 */
@Entity(name="conversation_settings")
public class ConversationSettings {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "id", unique = true)
    private String id;

    public String getId() {
        return id;
    }
}
