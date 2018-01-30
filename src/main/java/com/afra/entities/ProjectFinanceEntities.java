package com.afra.entities;


import javax.persistence.*;

@Entity
@Table(name = "Finance_Project")
public class ProjectFinanceEntities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    @Column(name = "est_cost")
    private double estCost;

    @Basic
    @Column(name = "act_cost")
    private double actCost;

    @Basic
    @Column(name = "project_fk")
    private String projectFk;


    public ProjectFinanceEntities() {
    }

    public ProjectFinanceEntities(double estCost, double actCost, String projectFk) {
        this.estCost = estCost;
        this.actCost = actCost;
        this.projectFk = projectFk;
    }



    public double getEstCost() {
        return estCost;
    }

    public void setEstCost(double estCost) {
        this.estCost = estCost;
    }

    public double getActCost() {
        return actCost;
    }

    public void setActCost(double actCost) {
        this.actCost = actCost;
    }

    public String getProjectFk() {
        return projectFk;
    }

    public void setProjectFk(String projectFk) {
        this.projectFk = projectFk;
    }

    @Override
    public String toString() {
        return "ProjectFinanceEntities{" +
                "estCost=" + estCost +
                ", actCost=" + actCost +
                ", projectFk='" + projectFk + '\'' +
                '}';
    }
}
