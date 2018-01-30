package com.afra.services.projects;

import com.afra.entities.ProjectHoursEntities;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProjectHoursService {
    ResponseEntity<List<ProjectHoursEntities>> getAllProjectHours();
    ResponseEntity<ProjectHoursEntities> getProjectHoursByProject(String projectId);
    ResponseEntity<ProjectHoursEntities> createProjectHours(ProjectHoursEntities data);
    ResponseEntity<ProjectHoursEntities> updateProjectHours(ProjectHoursEntities data);
    ResponseEntity deleteProjectHours(String projectId);
}
