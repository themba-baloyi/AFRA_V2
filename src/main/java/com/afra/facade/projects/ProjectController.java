package com.afra.facade.projects;

import com.afra.entities.ProjectsEntities;
import com.afra.services.projects.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;
@RestController
@RequestMapping("/afra/project")
public class ProjectController{

    @Autowired
    ProjectServiceImpl service;



    @GetMapping("/projectAll")
    public ResponseEntity<List<ProjectsEntities>> getAllProjects() {
        return service.getAllProjects();
    }

    @GetMapping("/projectById/{id}")
    public ResponseEntity<ProjectsEntities> getProjectById(@PathVariable String id) {
        return service.getProjectById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<ProjectsEntities> createProject(@RequestBody ProjectsEntities project) {
        return service.createProject(project);
    }

    @PutMapping("/update")
    public ResponseEntity<ProjectsEntities> updateProject(@RequestBody ProjectsEntities project) {
        return service.updateProject(project);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProject(@PathVariable String id) {
        return service.deleteProject(id);
    }
}
