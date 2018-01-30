package com.afra.services.resource;

import com.afra.entities.ResourceEntities;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ResourceService {
    List<ResourceEntities> getAllResources();
    ResourceEntities getResourceById(String id);
    ResponseEntity<ResourceEntities> createResource(ResourceEntities resource);
    ResourceEntities updateResource(ResourceEntities resource);
    boolean deleteResource(String id);
}
