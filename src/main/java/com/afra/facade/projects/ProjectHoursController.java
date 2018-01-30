package com.afra.facade.projects;

import com.afra.entities.ProjectHoursEntities;
import com.afra.services.projects.ProjectHoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/afra/project/hours")
public class ProjectHoursController implements ProjectHours{

    @Autowired
    ProjectHoursService service;

    @Override
    @GetMapping("/all")
    public ResponseEntity<List<ProjectHoursEntities>> getAllProjectHours() {
        return service.getAllProjectHours();
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ProjectHoursEntities> getProjectHoursByProject(@PathVariable String projectId) {
        return service.getProjectHoursByProject(projectId);
    }

    @Override
    @PostMapping("/create")
    public ResponseEntity<ProjectHoursEntities> createProjectHours(@RequestBody ProjectHoursEntities data) {
        return service.createProjectHours(data);
    }

    @Override
    @PutMapping("/update")
    public ResponseEntity<ProjectHoursEntities> updateProjectHours(@RequestBody ProjectHoursEntities data) {
        return service.updateProjectHours(data);
    }

    @Override
    @DeleteMapping("/delete")
    public ResponseEntity deleteProjectHours(@PathVariable String projectId) {
        return service.deleteProjectHours(projectId);
    }
}
