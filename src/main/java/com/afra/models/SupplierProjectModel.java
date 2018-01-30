package com.afra.models;

public class SupplierProjectModel {
    double estCost, actualCost, recoveryCost;
    String supplierId, projectId;

    public SupplierProjectModel(double estCost, double actualCost, double recoveryCost, String supplierId, String projectId) {
        this.estCost = estCost;
        this.actualCost = actualCost;
        this.recoveryCost = recoveryCost;
        this.supplierId = supplierId;
        this.projectId = projectId;
    }

    public SupplierProjectModel() {
    }

    public double getEstCost() {
        return estCost;
    }

    public void setEstCost(double estCost) {
        this.estCost = estCost;
    }

    public double getActualCost() {
        return actualCost;
    }

    public void setActualCost(double actualCost) {
        this.actualCost = actualCost;
    }

    public double getRecoveryCost() {
        return recoveryCost;
    }

    public void setRecoveryCost(double recoveryCost) {
        this.recoveryCost = recoveryCost;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
}
