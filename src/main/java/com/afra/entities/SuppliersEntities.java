package com.afra.entities;

import javax.persistence.*;

@Entity
@Table(name = "Suppliers")
public class SuppliersEntities {

    @Id
    private String id;
    private String name;
    private String resourceFk;

    public SuppliersEntities() {
    }

    public SuppliersEntities(String id, String name, String resourceFk) {
        this.id = id;
        this.name = name;
        this.resourceFk = resourceFk;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResourceFk() {
        return resourceFk;
    }

    public void setResourceFk(String resourceFk) {
        this.resourceFk = resourceFk;
    }

    @Override
    public String toString() {
        return "SuppliersEntities{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", resourceFk='" + resourceFk + '\'' +
                '}';
    }
}
