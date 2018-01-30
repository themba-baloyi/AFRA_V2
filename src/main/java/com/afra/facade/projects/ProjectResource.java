package com.afra.facade.projects;

import com.afra.entities.ProjectResourcesEntities;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProjectResource {
    ResponseEntity<List<ProjectResourcesEntities>> getAllProjectResource();
    ResponseEntity<List<ProjectResourcesEntities>> getProjectResourceByResource(String resourceId);
    ResponseEntity<List<ProjectResourcesEntities>> getProjectResourceByProject(String resourceId);
    ResponseEntity<ProjectResourcesEntities> getProjectResource(String resourceId, String projectId);
    ResponseEntity<ProjectResourcesEntities> createProjectResource(ProjectResourcesEntities data);
    ResponseEntity<ProjectResourcesEntities> updateProjectResource(ProjectResourcesEntities data);
    ResponseEntity deleteProjectResource(String resourceId, String projectId);
}
