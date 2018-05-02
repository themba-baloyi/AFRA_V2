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

    @CrossOrigin
    @Override
    @GetMapping("/all")
    public ResponseEntity<List<ProjectHoursEntities>> getAllProjectHours() {
        return service.getAllProjectHours();
    }

    @CrossOrigin
    @Override
    @GetMapping("/{projectId}")
    public ResponseEntity<ProjectHoursEntities> getProjectHoursByProject(@PathVariable String projectId) {
        return service.getProjectHoursByProject(projectId);
    }

    @CrossOrigin
    @Override
    @PostMapping("/create")
    public ResponseEntity<ProjectHoursEntities> createProjectHours(@RequestBody ProjectHoursEntities data) {
        return service.createProjectHours(data);
    }

    @CrossOrigin
    @Override
    @PutMapping("/update")
    public ResponseEntity<ProjectHoursEntities> updateProjectHours(@RequestBody ProjectHoursEntities data) {
        return service.updateProjectHours(data);
    }

    @CrossOrigin
    @Override
    @DeleteMapping("/delete/{projectId}")
    public ResponseEntity deleteProjectHours(@PathVariable String projectId) {
        return service.deleteProjectHours(projectId);
    }
}
