package com.afra.facade.projects;

import com.afra.entities.ProjectFinanceEntities;
import org.springframework.http.ResponseEntity;

public interface ProjectFinance {
    ResponseEntity<ProjectFinanceEntities> viewProjectCost(String projectId);
    ResponseEntity<ProjectFinanceEntities> createProjectCost(ProjectFinanceEntities projFin);
    ResponseEntity<ProjectFinanceEntities> updateProjectCost(ProjectFinanceEntities projFin);
    ResponseEntity deleteProjectCost(String projectId);
}
