package com.afra.facade.resources;

import com.afra.entities.ResourceEntities;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface Resource {
    ResponseEntity<List<ResourceEntities>> getAllResources();
    ResponseEntity<ResourceEntities> getResourceById(String id);
    ResponseEntity<ResourceEntities> createResource(ResourceEntities resource);
    ResponseEntity<ResourceEntities> updateResource(ResourceEntities resource);
    ResponseEntity deleteResource(String id);
}
