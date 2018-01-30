package com.afra.entities;

import javax.persistence.*;

@Entity
@Table(name = "Supplier_Project")
public class SupplierProjectEntities {

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
    @Column(name = "supplier_fk")
    private String supplierFk;

    @Basic
    @Column(name = "project_fk")
    private String projectFk;


    public SupplierProjectEntities(double estCost, double actCost, String supplierFk, String projectFk) {
        this.estCost = estCost;
        this.actCost = actCost;
        this.supplierFk = supplierFk;
        this.projectFk = projectFk;
    }

    public SupplierProjectEntities() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getSupplierFk() {
        return supplierFk;
    }

    public void setSupplierFk(String supplierFk) {
        this.supplierFk = supplierFk;
    }

    public String getProjectFk() {
        return projectFk;
    }

    public void setProjectFk(String projectFk) {
        this.projectFk = projectFk;
    }

    @Override
    public String toString() {
        return "SupplierProjectEntities{" +
                "id=" + id +
                ", estCost=" + estCost +
                ", actCost=" + actCost +
                ", supplierFk='" + supplierFk + '\'' +
                ", projectFk='" + projectFk + '\'' +
                '}';
    }
}
