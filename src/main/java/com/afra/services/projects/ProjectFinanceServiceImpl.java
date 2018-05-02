package com.afra.services.projects;

import com.afra.entities.ProjectFinanceEntities;
import com.afra.repository.ProjectFinanceRepo;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.CannotCreateTransactionException;

import java.util.List;


@Service
public class ProjectFinanceServiceImpl implements ProjectFinanceService {

    @Autowired
    ProjectServiceImpl service;

    @Autowired
    ProjectFinanceRepo repo;


    @Override
    public ResponseEntity<ProjectFinanceEntities> viewProjectCost(String projectId) {
        if(checkRecord(projectId)){
            try{
                ProjectFinanceEntities result = repo.findByProjectFk(projectId);
                return  new ResponseEntity<>(result, HttpStatus.OK);
            }catch (CannotCreateTransactionException ex){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<ProjectFinanceEntities> createProjectCost(ProjectFinanceEntities projFin) {
        try {
            if (!checkRecord(projFin.getProjectFk())){
                repo.save(projFin);
                return new ResponseEntity<>(projFin, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
        }catch (CannotCreateTransactionException ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ProjectFinanceEntities> updateProjectCost(ProjectFinanceEntities projFin) {
        try {
            if (checkRecord(projFin.getProjectFk())){
                repo.updateProjectFinance(projFin.getActCost(), projFin.getEstCost(), projFin.getProjectFk());
                return new ResponseEntity<ProjectFinanceEntities>(projFin, HttpStatus.OK);
            }else{
                return new ResponseEntity<ProjectFinanceEntities>(HttpStatus.CONFLICT);
            }
        }catch (CannotCreateTransactionException ex){
            return new ResponseEntity<ProjectFinanceEntities>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//todo: fix this delete method
    @Override
    public ResponseEntity deleteProjectCost(String projectId) {
        try {
            if (checkRecord(projectId)){
                if(repo.deleteByProjectFk(projectId)){
                    return new ResponseEntity<ProjectFinanceEntities>(HttpStatus.OK);
                }else{
                    return new ResponseEntity(HttpStatus.NOT_FOUND);
                }
            }else{
                return new ResponseEntity<ProjectFinanceEntities>(HttpStatus.NOT_FOUND);
            }
        }catch (CannotCreateTransactionException ex){
            return new ResponseEntity<ProjectFinanceEntities>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<ProjectFinanceEntities>> getAllProjectCost() {
        try {
            List<ProjectFinanceEntities> results = IterableUtils.toList(repo.findAll());
            return new ResponseEntity<List<ProjectFinanceEntities>>(results, HttpStatus.OK);

        }catch (CannotCreateTransactionException ex){
            return new ResponseEntity<List<ProjectFinanceEntities>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public boolean checkRecord(String projectFk){
        if(repo.findByProjectFk(projectFk)!= null){
            return true;
        }else {
            return false;
        }
    }
}
