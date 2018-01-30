package com.afra.services.resource;

import com.afra.entities.ResourceWorkEntities;
import com.afra.repository.ResourceWorkRepo;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.CannotCreateTransactionException;

import java.util.List;

@Service
public class ResourceWorkServiceImpl implements ResourceWorkService {

    @Autowired
    ResourceWorkRepo repo;

    @Override
    public ResponseEntity<List<ResourceWorkEntities>> getAllResourceWork() {
        try {
            List<ResourceWorkEntities> results = IterableUtils.toList(repo.findAll());
            return new ResponseEntity<List<ResourceWorkEntities>>(results, HttpStatus.OK);
        }catch (CannotCreateTransactionException ex){
            return new ResponseEntity<List<ResourceWorkEntities>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<ResourceWorkEntities>> getResourceWorkByProject(String projectId) {
        try {
            List<ResourceWorkEntities> results = IterableUtils.toList(repo.findAllByProjectFk(projectId));

            if(results != null){
                return new ResponseEntity<List<ResourceWorkEntities>>(results, HttpStatus.OK);
            }else {
                return new ResponseEntity<List<ResourceWorkEntities>>(HttpStatus.NOT_FOUND);
            }
        }catch (CannotCreateTransactionException ex){
            return new ResponseEntity<List<ResourceWorkEntities>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<ResourceWorkEntities>> getResourceWorkByResource(String resourceId) {
        try {
            List<ResourceWorkEntities> results = IterableUtils.toList(repo.findAllByResourceFk(resourceId));

            if(results != null){
                return new ResponseEntity<List<ResourceWorkEntities>>(results, HttpStatus.OK);
            }else {
                return new ResponseEntity<List<ResourceWorkEntities>>(HttpStatus.NOT_FOUND);
            }
        }catch (CannotCreateTransactionException ex){
            return new ResponseEntity<List<ResourceWorkEntities>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ResourceWorkEntities> getResourceWork(String projectId, String resourceId) {
        try {
            ResourceWorkEntities result = repo.findByProjectFkAndResourceFk(projectId,resourceId);

            if(result != null){
                return new ResponseEntity<ResourceWorkEntities>(result, HttpStatus.OK);
            }else {
                return new ResponseEntity<ResourceWorkEntities>(HttpStatus.NOT_FOUND);
            }
        }catch (CannotCreateTransactionException ex){
            return new ResponseEntity<ResourceWorkEntities>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ResourceWorkEntities> createResourceWork(ResourceWorkEntities data) {
        try {
            ResourceWorkEntities result = repo.findByProjectFkAndResourceFk(data.getProjectFk(),data.getResourceFk());

            if(result == null){
                repo.save(data);
                return new ResponseEntity<ResourceWorkEntities>(result, HttpStatus.OK);
            }else {
                return new ResponseEntity<ResourceWorkEntities>(HttpStatus.CONFLICT);
            }
        }catch (CannotCreateTransactionException ex){
            return new ResponseEntity<ResourceWorkEntities>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ResourceWorkEntities> updateResourceWork(ResourceWorkEntities data) {
        try {
            ResourceWorkEntities result = repo.findByProjectFkAndResourceFk(data.getProjectFk(),data.getResourceFk());

            if(result != null){
                repo.save(data);
                return new ResponseEntity<ResourceWorkEntities>(result, HttpStatus.OK);
            }else {
                return new ResponseEntity<ResourceWorkEntities>(HttpStatus.NOT_FOUND);
            }
        }catch (CannotCreateTransactionException ex){
            return new ResponseEntity<ResourceWorkEntities>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity deleteResourceWork(String projectId, String resourceId) {
        try {
            ResourceWorkEntities result = repo.findByProjectFkAndResourceFk(projectId,resourceId);

            if(result == null){
                repo.deleteByProjectFkAndResourceFk(projectId, resourceId);
                return new ResponseEntity<ResourceWorkEntities>(HttpStatus.OK);
            }else {
                return new ResponseEntity<ResourceWorkEntities>(HttpStatus.NOT_FOUND);
            }
        }catch (CannotCreateTransactionException ex){
            return new ResponseEntity<ResourceWorkEntities>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
