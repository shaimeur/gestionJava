package com.shaimeur.entities;

import jakarta.persistence.*;

@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id ;
    @Column(name = "email")
    String email;
    @Column(name = "password")
    String password;

    public Admin(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Admin(Long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public Admin() {
    }


}
