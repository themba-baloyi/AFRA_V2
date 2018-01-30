package com.afra.services.projects;


import com.afra.entities.ProjectHoursEntities;
import com.afra.repository.ProjectHourRepo;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.CannotCreateTransactionException;

import java.util.List;

@Service
public class ProjectHoursServiceImpl implements   ProjectHoursService{

    @Autowired
    ProjectHourRepo repo;

    @Override
    public ResponseEntity<List<ProjectHoursEntities>> getAllProjectHours() {
       try {
            List<ProjectHoursEntities> results = IterableUtils.toList(repo.findAll());
            return new ResponseEntity<List<ProjectHoursEntities>>(results, HttpStatus.OK);
       }catch (CannotCreateTransactionException ex){
           return new ResponseEntity<List<ProjectHoursEntities>>(HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }

    @Override
    public ResponseEntity<ProjectHoursEntities> getProjectHoursByProject(String projectId) {
        try {
            ProjectHoursEntities result = repo.findByProjectFk(projectId);
            if(result != null){
                return new ResponseEntity<ProjectHoursEntities>(result, HttpStatus.OK);
            }else {
                return new ResponseEntity<ProjectHoursEntities>(HttpStatus.NOT_FOUND);
            }
        }catch (CannotCreateTransactionException ex){
            return new ResponseEntity<ProjectHoursEntities>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ProjectHoursEntities> createProjectHours(ProjectHoursEntities data) {
        try {
            ProjectHoursEntities result = repo.findByProjectFk(data.getProjectFk());
            if(result == null){
                repo.save(data);
                return new ResponseEntity<ProjectHoursEntities>(result, HttpStatus.OK);
            }else {
                return new ResponseEntity<ProjectHoursEntities>(HttpStatus.CONFLICT);
            }
        }catch (CannotCreateTransactionException ex){
            return new ResponseEntity<ProjectHoursEntities>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ProjectHoursEntities> updateProjectHours(ProjectHoursEntities data) {
        try {
            ProjectHoursEntities result = repo.findByProjectFk(data.getProjectFk());
            if(result != null){
                repo.save(data);
                return new ResponseEntity<ProjectHoursEntities>(result, HttpStatus.OK);
            }else {
                return new ResponseEntity<ProjectHoursEntities>(HttpStatus.NOT_FOUND);
            }
        }catch (CannotCreateTransactionException ex){
            return new ResponseEntity<ProjectHoursEntities>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity deleteProjectHours(String projectId) {
        try {
            ProjectHoursEntities result = repo.findByProjectFk(projectId);
            if(result != null){
                repo.delete(result.getId());
                return new ResponseEntity<ProjectHoursEntities>(result, HttpStatus.OK);
            }else {
                return new ResponseEntity<ProjectHoursEntities>(HttpStatus.NOT_FOUND);
            }
        }catch (CannotCreateTransactionException ex){
            return new ResponseEntity<ProjectHoursEntities>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
