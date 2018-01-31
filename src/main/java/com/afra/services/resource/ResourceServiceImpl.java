package com.afra.services.resource;

import com.afra.entities.ResourceEntities;
import com.afra.repository.ResourceRepo;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.CannotCreateTransactionException;

import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    ResourceRepo repo;


    @Override
    public ResponseEntity<List<ResourceEntities>> getAllResources() {
        try{
            List<ResourceEntities> result = IterableUtils.toList(repo.findAll());
            return new ResponseEntity<List<ResourceEntities>>(result, HttpStatus.OK);
        }catch (CannotCreateTransactionException ex){
            return new ResponseEntity<List<ResourceEntities>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ResourceEntities> getResourceById(String id) {
        try{

            ResourceEntities result = repo.findOne(id);
            if (result != null){
                return new ResponseEntity<ResourceEntities>(result,HttpStatus.OK);
            }else{
                return new ResponseEntity<ResourceEntities>( HttpStatus.NOT_FOUND);
            }
        }catch (CannotCreateTransactionException ex){
            return new ResponseEntity<ResourceEntities>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ResourceEntities> createResource(ResourceEntities resource) {
        try{
            if (repo.exists(resource.getId())){
                return new ResponseEntity<ResourceEntities>(HttpStatus.CONFLICT);
            }else{
                repo.save(resource);
                return new ResponseEntity<ResourceEntities>(resource, HttpStatus.OK);
            }
        }catch (CannotCreateTransactionException ex){
            return new ResponseEntity<ResourceEntities>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ResourceEntities> updateResource(ResourceEntities resource) {
        try{
            ResourceEntities results = repo.findOne(resource.getId());
            if (results == null){
                return new ResponseEntity<ResourceEntities>(HttpStatus.NOT_FOUND);
            }else{
                repo.save(resource);
                return new ResponseEntity<ResourceEntities>(resource, HttpStatus.OK);
            }
        }catch (CannotCreateTransactionException ex){
            return new ResponseEntity<ResourceEntities>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity deleteResource(String id) {
        try{
            ResourceEntities results = repo.findOne(id);
            if (results == null){
                return new ResponseEntity<ResourceEntities>(HttpStatus.NOT_FOUND);
            }else{
                repo.delete(id);
                return new ResponseEntity<ResourceEntities>(HttpStatus.OK);
            }
        }catch (CannotCreateTransactionException ex){
            return new ResponseEntity<ResourceEntities>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
