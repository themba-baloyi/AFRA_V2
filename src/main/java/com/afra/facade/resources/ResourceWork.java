package com.afra.facade.resources;

import com.afra.entities.ResourceWorkEntities;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ResourceWork {
    ResponseEntity<List<ResourceWorkEntities>> getAllResourceWork();
    ResponseEntity<List<ResourceWorkEntities>> getResourceWorkByProject(String projectId);
    ResponseEntity<List<ResourceWorkEntities>> getResourceWorkByResource(String resourceId);
    ResponseEntity<ResourceWorkEntities> getResourceWork(String projectId, String resourceId);
    ResponseEntity<ResourceWorkEntities> createResourceWork(ResourceWorkEntities data);
    ResponseEntity<ResourceWorkEntities> updateResourceWork(ResourceWorkEntities data);
    ResponseEntity deleteResourceWork(String projectId, String resourceId);
}
