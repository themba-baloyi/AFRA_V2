package com.afra.entities;

import javax.persistence.*;

@Entity
@Table(name = "Resource")
public class ResourceEntities {

    @Id
    private String id;
    private String fname;
    private String type;
    private String role;
    private String email;
    private String lname;

    public ResourceEntities() {
    }

    public ResourceEntities(String id, String fname, String type, String role, String email, String lname) {
        this.id = id;
        this.fname = fname;
        this.type = type;
        this.role = role;
        this.email = email;
        this.lname = lname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
}
