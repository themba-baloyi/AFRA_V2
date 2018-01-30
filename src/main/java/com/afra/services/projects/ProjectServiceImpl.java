package com.afra.services.projects;

import com.afra.entities.ProjectsEntities;
import com.afra.entities.UsersEntities;
import com.afra.repository.ProjectRepo;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.CannotCreateTransactionException;

import java.util.Iterator;
import java.util.List;
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectRepo repo;



    public boolean checkProjectExist(String projectId){
        ProjectsEntities temp = repo.findOne(projectId);
        return temp == null ? false : true;
    }

    @Override
    public ResponseEntity<List<ProjectsEntities>> getAllProjects() {
        try{
            return new ResponseEntity<List<ProjectsEntities>>(IterableUtils.toList(repo.findAll()), HttpStatus.OK);

        }catch (CannotCreateTransactionException ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ProjectsEntities> getProjectById(String id) {
       try{
           return new ResponseEntity<ProjectsEntities>(repo.findOne(id), HttpStatus.OK);
       }catch (CannotCreateTransactionException ex){
           return new ResponseEntity<ProjectsEntities>(HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }

    @Override
    public ResponseEntity<ProjectsEntities> createProject(ProjectsEntities project) {
        try{
            if(!checkProjectExist(project.getId())){
                repo.save(project);
                return  new ResponseEntity<ProjectsEntities>(project,HttpStatus.OK);
            }else {
                return new ResponseEntity<ProjectsEntities>(HttpStatus.CONFLICT);
            }

        }catch (CannotCreateTransactionException ex){
            return new ResponseEntity<ProjectsEntities>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ProjectsEntities> updateProject(ProjectsEntities project) {
        try {
            if(checkProjectExist(project.getId())){
                repo.save(project);
                return new ResponseEntity<ProjectsEntities>(project, HttpStatus.OK);
            }else {
                return new ResponseEntity<ProjectsEntities>(HttpStatus.NOT_FOUND);
            }
        }catch (CannotCreateTransactionException ex){
            return new ResponseEntity<ProjectsEntities>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity deleteProject(String id) {
        try {
            if (checkProjectExist(id)){
                repo.delete(id);
                return new ResponseEntity(HttpStatus.OK);
            }else{
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        }catch (CannotCreateTransactionException ex){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
