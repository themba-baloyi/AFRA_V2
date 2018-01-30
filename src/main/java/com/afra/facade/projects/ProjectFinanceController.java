package com.afra.facade.projects;

import com.afra.entities.ProjectFinanceEntities;
import com.afra.services.projects.ProjectFinanceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/afra/project/finance")
public class ProjectFinanceController implements ProjectFinance{

    @Autowired
    ProjectFinanceServiceImpl service;

    @Override
    @GetMapping("/get/{projectId}")
    public ResponseEntity<ProjectFinanceEntities> viewProjectCost(@PathVariable String projectId) {
        return service.viewProjectCost(projectId);
    }

    @Override
    @PostMapping("/create")
    public ResponseEntity<ProjectFinanceEntities> createProjectCost(@RequestBody ProjectFinanceEntities projFin) {
        return service.createProjectCost(projFin);
    }

    @Override
    @PutMapping("/update")
    public ResponseEntity<ProjectFinanceEntities> updateProjectCost(@RequestBody ProjectFinanceEntities projFin) {
        return service.updateProjectCost(projFin);
    }

    @Override
    @DeleteMapping("/delete/{projectId}")
    public ResponseEntity deleteProjectCost(@PathVariable String projectId) {
        return service.deleteProjectCost(projectId);
    }
}
