package com.afra.services.resource;

import com.afra.entities.ResourceEntities;
import com.afra.repository.ResourceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    ResourceRepo repo;

    @Override
    public List<ResourceEntities> getAllResources() {
        return null;
    }

    @Override
    public ResourceEntities getResourceById(String id) {
        return null;
    }

    @Override
    public ResponseEntity<ResourceEntities> createResource(ResourceEntities resource) {
        if (repo.exists(resource.getId())){
            return new ResponseEntity<ResourceEntities>(HttpStatus.ALREADY_REPORTED);
        }else{
            repo.save(resource);
            return new ResponseEntity<ResourceEntities>(resource, HttpStatus.OK);
        }
    }

    @Override
    public ResourceEntities updateResource(ResourceEntities resource) {
        return null;
    }

    @Override
    public boolean deleteResource(String id) {
        return false;
    }
}
