package com.afra.facade.projects;

import com.afra.entities.ProjectResourcesEntities;
import com.afra.services.projects.ProjectResourceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/afra/project/resource")
public class ProjectResourceController implements ProjectResource {

    @Autowired
    ProjectResourceServiceImpl service;

    @CrossOrigin
    @GetMapping("/all")
    @Override
    public ResponseEntity<List<ProjectResourcesEntities>> getAllProjectResource() {
        return service.getAllProjectResource();
    }

    @CrossOrigin
    @GetMapping("/byResource/{resourceId}")
    @Override
    public ResponseEntity<List<ProjectResourcesEntities>> getProjectResourceByResource(@PathVariable String resourceId) {
        return service.getProjectResourceByResource(resourceId);
    }

    @CrossOrigin
    @GetMapping("/byProject/{projectId}")
    @Override
    public ResponseEntity<List<ProjectResourcesEntities>> getProjectResourceByProject(@PathVariable String projectId) {
        return service.getProjectResourceByProject(projectId);
    }

    @CrossOrigin
    @GetMapping("/byId/{resourceId}/{projectId}")
    @Override
    public ResponseEntity<ProjectResourcesEntities> getProjectResource(@PathVariable String resourceId,@PathVariable String projectId) {
        return service.getProjectResource(resourceId, projectId);
    }

    @CrossOrigin
    @Override
    @PostMapping("/create")
    public ResponseEntity<ProjectResourcesEntities> createProjectResource(@RequestBody ProjectResourcesEntities data) {
        return service.createProjectResource(data);
    }

    @CrossOrigin
    @Override
    @PutMapping("/update")
    public ResponseEntity<ProjectResourcesEntities> updateProjectResource(@RequestBody ProjectResourcesEntities data) {
        return service.updateProjectResource(data);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @Override
    @DeleteMapping("/delete/{resourceId}/{projectId}")
    public ResponseEntity deleteProjectResource(@PathVariable String resourceId,@PathVariable String projectId) {
        return service.deleteProjectResource(resourceId, projectId);
    }
}
