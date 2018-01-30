package com.afra.entities;

import javax.persistence.*;

@Entity
@Table(name = "Resource_Work")
public class ResourceWorkEntities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String month;
    private double hours;
    private int year;
    private String confirmation;
    private String resourceFk;
    private String projectFk;

    public ResourceWorkEntities() {
    }

    public ResourceWorkEntities(String month, double hours, int year, String confirmation, String resourceFk, String projectFk) {
        this.month = month;
        this.hours = hours;
        this.year = year;
        this.confirmation = confirmation;
        this.resourceFk = resourceFk;
        this.projectFk = projectFk;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(String confirmation) {
        this.confirmation = confirmation;
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

    @Override
    public String toString() {
        return "ResourceWorkEntities{" +
                "id=" + id +
                ", month='" + month + '\'' +
                ", hours=" + hours +
                ", year=" + year +
                ", confirmation='" + confirmation + '\'' +
                ", resourceFk='" + resourceFk + '\'' +
                ", projectFk='" + projectFk + '\'' +
                '}';
    }
}
