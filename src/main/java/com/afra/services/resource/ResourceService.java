package com.afra.services.resource;

import com.afra.entities.ResourceEntities;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ResourceService {
    ResponseEntity<List<ResourceEntities>> getAllResources();
    ResponseEntity<ResourceEntities> getResourceById(String id);
    ResponseEntity<ResourceEntities> createResource(ResourceEntities resource);
    ResponseEntity<ResourceEntities> updateResource(ResourceEntities resource);
    ResponseEntity deleteResource(String id);
}
