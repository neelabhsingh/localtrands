package com.localtrends.userservice.model;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "\"user\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

//    @Column(nullable = false)
//    private Date createdOn;
//
//    @Column(nullable = false)
//    private Date updatedOn;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public Date getCreatedOn() {
//        return createdOn;
//    }
//
//    public void setCreatedOn(Date createdOn) {
//        this.createdOn = createdOn;
//    }

//    public Date getUpdatedOn() {
//        return updatedOn;
//    }
//
//    public void setUpdatedOn(Date updatedOn) {
//        this.updatedOn = updatedOn;
//    }
}
