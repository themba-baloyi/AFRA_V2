package com.afra.services.projects;

import com.afra.entities.ProjectsEntities;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProjectService {
    ResponseEntity<List<ProjectsEntities>> getAllProjects();
    ResponseEntity<ProjectsEntities> getProjectById(String id);
    ResponseEntity<ProjectsEntities> createProject(ProjectsEntities project);
    ResponseEntity<ProjectsEntities> updateProject(ProjectsEntities project);
    ResponseEntity deleteProject(String id);
}
