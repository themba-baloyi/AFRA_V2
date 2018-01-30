package com.afra.facade.projects;

import com.afra.entities.ProjectResourcesEntities;
import com.afra.services.projects.ProjectResourceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/afra/project/resource")
public class ProjectResourceController implements ProjectResource {

    @Autowired
    ProjectResourceServiceImpl service;

    @GetMapping("/all")
    @Override
    public ResponseEntity<List<ProjectResourcesEntities>> getAllProjectResource() {
        return service.getAllProjectResource();
    }

    @GetMapping("/byResource/{resourceId}")
    @Override
    public ResponseEntity<List<ProjectResourcesEntities>> getProjectResourceByResource(String resourceId) {
        return service.getProjectResourceByResource(resourceId);
    }

    @GetMapping("/byProject/{projectId}")
    @Override
    public ResponseEntity<List<ProjectResourcesEntities>> getProjectResourceByProject(String projectId) {
        return service.getProjectResourceByProject(projectId);
    }

    @GetMapping("/byId")
    @Override
    public ResponseEntity<ProjectResourcesEntities> getProjectResource(String resourceId, String projectId) {
        return service.getProjectResource(resourceId, projectId);
    }

    @Override
    public ResponseEntity<ProjectResourcesEntities> createProjectResource(ProjectResourcesEntities data) {
        return null;
    }

    @Override
    public ResponseEntity<ProjectResourcesEntities> updateProjectResource(ProjectResourcesEntities data) {
        return null;
    }

    @Override
    public ResponseEntity deleteProjectResource(String resourceId, String projectId) {
        return null;
    }
}
