package com.afra.services.projects;

import com.afra.entities.ProjectResourcesEntities;
import com.afra.repository.ProjectResourceRepo;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.CannotCreateTransactionException;

import java.util.List;

@Service
public class ProjectResourceServiceImpl implements ProjectResourceService {

    @Autowired
    ProjectResourceRepo repo;

    @Override
    public ResponseEntity<List<ProjectResourcesEntities>> getAllProjectResource() {
       try {
           List<ProjectResourcesEntities> results = IterableUtils.toList(repo.findAll());
           return new ResponseEntity<List<ProjectResourcesEntities>>(results, HttpStatus.OK);
       }catch (CannotCreateTransactionException ex){
           return new ResponseEntity<List<ProjectResourcesEntities>>(HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }

    @Override
    public ResponseEntity<List<ProjectResourcesEntities>> getProjectResourceByResource(String resourceId) {
        try {

            List<ProjectResourcesEntities> results = IterableUtils.toList(repo.findAllByResourceFk(resourceId));
            if(results != null){
                return new ResponseEntity<List<ProjectResourcesEntities>>(results,HttpStatus.OK);
            }else {
                return new ResponseEntity<List<ProjectResourcesEntities>>(HttpStatus.NOT_FOUND);
            }
        }catch (CannotCreateTransactionException ex){
            return new ResponseEntity<List<ProjectResourcesEntities>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<ProjectResourcesEntities>> getProjectResourceByProject(String projectId) {
        try {
            List<ProjectResourcesEntities> results = IterableUtils.toList(repo.findAllByProjectFk(projectId));
            if(results != null){
                return new ResponseEntity<List<ProjectResourcesEntities>>(results,HttpStatus.OK);
            }else {
                return new ResponseEntity<List<ProjectResourcesEntities>>(HttpStatus.NOT_FOUND);
            }
        }catch (CannotCreateTransactionException ex){
            return new ResponseEntity<List<ProjectResourcesEntities>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ProjectResourcesEntities> getProjectResource(String resourceId, String projectId) {
        try {
            ProjectResourcesEntities results = repo.findByProjectFkAndResourceFk(resourceId,projectId);
            if(results != null){
                return new ResponseEntity<ProjectResourcesEntities>(results,HttpStatus.OK);
            }else {
                return new ResponseEntity<ProjectResourcesEntities>(HttpStatus.NOT_FOUND);
            }
        }catch (CannotCreateTransactionException ex){
            return new ResponseEntity<ProjectResourcesEntities>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ProjectResourcesEntities> createProjectResource(ProjectResourcesEntities data) {
        try {
            ProjectResourcesEntities results = repo.findByProjectFkAndResourceFk(data.getResourceFk(), data.getProjectFk());
            if(results == null){
                repo.save(data);
                return new ResponseEntity<ProjectResourcesEntities>(data,HttpStatus.OK);
            }else {
                return new ResponseEntity<ProjectResourcesEntities>(HttpStatus.CONFLICT);
            }
        }catch (CannotCreateTransactionException ex){
            return new ResponseEntity<ProjectResourcesEntities>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ProjectResourcesEntities> updateProjectResource(ProjectResourcesEntities data) {
        try {
            ProjectResourcesEntities results = repo.findByProjectFkAndResourceFk(data.getResourceFk(), data.getProjectFk());
            if(results != null){
                repo.save(data);
                return new ResponseEntity<ProjectResourcesEntities>(data,HttpStatus.OK);
            }else {
                return new ResponseEntity<ProjectResourcesEntities>(HttpStatus.NOT_FOUND);
            }
        }catch (CannotCreateTransactionException ex){
            return new ResponseEntity<ProjectResourcesEntities>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity deleteProjectResource(String resourceId, String projectId) {
        try {
            ProjectResourcesEntities results = repo.findByProjectFkAndResourceFk(resourceId, projectId);
            if(results != null){
                repo.deleteByProjectFkAndResourceFk(projectId,resourceId);
                return new ResponseEntity(HttpStatus.OK);
            }else {
                return new ResponseEntity<ProjectResourcesEntities>(HttpStatus.NOT_FOUND);
            }
        }catch (CannotCreateTransactionException ex){
            return new ResponseEntity<ProjectResourcesEntities>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
