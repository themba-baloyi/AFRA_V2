package com.afra.entities;

import javax.persistence.*;

@Entity
@Table(name = "Projects")
public class ProjectsEntities {

    @Id
    private String id;
    private String name;
    private String absaNavNum;
    private String absaInNum;


    public ProjectsEntities() {
    }

    public ProjectsEntities(String id, String name, String absaNavNum, String absaInNum) {
        this.id = id;
        this.name = name;
        this.absaNavNum = absaNavNum;
        this.absaInNum = absaInNum;
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

    public String getAbsaNavNum() {
        return absaNavNum;
    }

    public void setAbsaNavNum(String absaNavNum) {
        this.absaNavNum = absaNavNum;
    }

    public String getAbsaInNum() {
        return absaInNum;
    }

    public void setAbsaInNum(String absaInNum) {
        this.absaInNum = absaInNum;
    }


    @Override
    public String toString() {
        return "ProjectsEntities{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", absaNavNum='" + absaNavNum + '\'' +
                ", absaInNum='" + absaInNum + '\'' +
                '}';
    }
}
