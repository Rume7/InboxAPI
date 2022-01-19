package com.codehacks.inbox.user;

import org.springframework.data.cassandra.core.mapping.Table;

/**
 *
 * @author Rhume
 */
@Table(value="user")
public class User {
    
    private String id;

    public User() {   }

    public User(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
