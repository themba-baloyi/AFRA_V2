package com.afra.entities;

import javax.persistence.*;

@Entity
@Table(name = "Project_Hours")
public class ProjectHoursEntities {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    @Column(name = "month")
    private String month;

    @Basic
    @Column(name = "hours")
    private double hours;

    @Basic
    @Column(name = "project_fk")
    private String projectFk;


    public ProjectHoursEntities() {
    }

    public ProjectHoursEntities(String month, double hours, String projectFk) {
        this.month = month;
        this.hours = hours;
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

    public String getProjectFk() {
        return projectFk;
    }

    public void setProjectFk(String projectFk) {
        this.projectFk = projectFk;
    }

    @Override
    public String toString() {
        return "ProjectHoursEntities{" +
                "id=" + id +
                ", month='" + month + '\'' +
                ", hours=" + hours +
                ", projectFk='" + projectFk + '\'' +
                '}';
    }
}
