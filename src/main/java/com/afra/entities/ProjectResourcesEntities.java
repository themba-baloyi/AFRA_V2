package com.afra.entities;

import javax.persistence.*;

@Entity
@Table(name = "Project_Resources")
public class ProjectResourcesEntities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    @Column(name = "rate")
    private double rate;

    @Basic
    @Column(name = "resource_fk")
    private String resourceFk;

    @Basic
    @Column(name = "project_fk")
    private String projectFk;

    public ProjectResourcesEntities() {
    }

    public ProjectResourcesEntities(Long id, double rate, String resourceFk, String projectFk) {
        this.id = id;
        this.rate = rate;
        this.resourceFk = resourceFk;
        this.projectFk = projectFk;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getResourceFk() {
        return resourceFk;
    }

    public void setResourceFk(String resourceFk) {
        this.resourceFk = resourceFk;
    }

    public String getProjectFk() {
        return projectFk;
    }

    public void setProjectFk(String projectFk) {
        this.projectFk = projectFk;
    }
}
