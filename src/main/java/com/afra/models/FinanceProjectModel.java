package com.afra.models;

public class FinanceProjectModel {

    private String projectName;
    private double estCost, actCost, recoveryCost;

    public FinanceProjectModel(String projectName, double estCost, double actCost, double recoveryCost) {
        this.projectName = projectName;
        this.estCost = estCost;
        this.actCost = actCost;
        this.recoveryCost = recoveryCost;
    }

    public double getRecoveryCost() {
        return recoveryCost;
    }

    public void setRecoveryCost(double recoveryCost) {
        this.recoveryCost = recoveryCost;
    }

    public FinanceProjectModel() {

    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
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
}
