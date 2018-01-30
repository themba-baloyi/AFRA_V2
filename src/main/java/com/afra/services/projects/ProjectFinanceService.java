package com.afra.services.projects;

import com.afra.entities.ProjectFinanceEntities;
import com.afra.models.FinanceProjectModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProjectFinanceService {
    ResponseEntity<ProjectFinanceEntities> viewProjectCost(String projectId);
    ResponseEntity<ProjectFinanceEntities> createProjectCost(ProjectFinanceEntities projFin);
    ResponseEntity<ProjectFinanceEntities> updateProjectCost(ProjectFinanceEntities projFin);
    ResponseEntity deleteProjectCost(String projectId);



}
