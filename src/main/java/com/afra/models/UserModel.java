package com.afra.models;

public class UserModel {


    private String password;
    private String resourceFk;
    private int accessFk;
    private String active;

    public UserModel(String password, String resourceFk, int accessFk, String active) {
        this.password = password;
        this.resourceFk = resourceFk;
        this.accessFk = accessFk;
        this.active = active;
    }

    public UserModel() {
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

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}
