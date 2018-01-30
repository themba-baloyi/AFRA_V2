package com.afra.entities;

import javax.persistence.*;

@Entity
@Table(name = "Users")
public class UsersEntities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String password;
    private String resourceFk;
    private int accessFk;

    public UsersEntities() {
    }

    public UsersEntities(String password, String resourceFk, int accessFk) {
        this.password = password;
        this.resourceFk = resourceFk;
        this.accessFk = accessFk;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getResourceFk() {
        return resourceFk;
    }

    public void setResourceFk(String resourceFk) {
        this.resourceFk = resourceFk;
    }

    public int getAccessFk() {
        return accessFk;
    }

    public void setAccessFk(int accessFk) {
        this.accessFk = accessFk;
    }

}
