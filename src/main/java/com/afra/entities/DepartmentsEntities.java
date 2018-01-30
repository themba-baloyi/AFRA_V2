package com.afra.entities;

import javax.persistence.*;

@Entity
@Table(name = "Departments")
public class DepartmentsEntities {

    @Id
    @Column(name = "id")
    private String id;

    @Basic
    @Column(name = "name")
    private String name;

    public DepartmentsEntities(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public DepartmentsEntities() {

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

    @Override
    public String toString() {
        return "DepartmentsEntities{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
