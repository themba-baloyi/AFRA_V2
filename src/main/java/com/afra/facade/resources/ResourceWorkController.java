package com.afra.facade.resources;

import com.afra.entities.ResourceWorkEntities;
import com.afra.services.resource.ResourceWorkServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/afra/resource/work")
public class ResourceWorkController implements ResourceWork{


    @Autowired
    ResourceWorkServiceImpl service;

    @CrossOrigin
    @Override
    @GetMapping("/all")
    public ResponseEntity<List<ResourceWorkEntities>> getAllResourceWork() {
        return service.getAllResourceWork();
    }

    @CrossOrigin
    @Override
    @GetMapping("/byProjectId/{projectId}")
    public ResponseEntity<List<ResourceWorkEntities>> getResourceWorkByProject(@PathVariable String projectId) {
        return service.getResourceWorkByProject(projectId);
    }

    @CrossOrigin
    @Override
    @GetMapping("/byResourceId/{resourceId}")
    public ResponseEntity<List<ResourceWorkEntities>> getResourceWorkByResource(@PathVariable String resourceId) {
        return service.getResourceWorkByResource(resourceId);
    }

    @CrossOrigin
    @Override
    @GetMapping("/byid/{projectId}/{resourceId}")
    public ResponseEntity<ResourceWorkEntities> getResourceWork(@PathVariable String projectId, @PathVariable String resourceId) {
        return service.getResourceWork(projectId, resourceId);
    }

    @CrossOrigin
    @Override
    @PostMapping("/create")
    public ResponseEntity<ResourceWorkEntities> createResourceWork(@RequestBody ResourceWorkEntities data) {
        return service.createResourceWork(data);
    }

    @CrossOrigin
    @Override
    @PutMapping("/update")
    public ResponseEntity<ResourceWorkEntities> updateResourceWork(@RequestBody ResourceWorkEntities data) {
        return service.updateResourceWork(data);
    }

    @CrossOrigin
    @Override
    @DeleteMapping("/delete/{projectId}/{resourceId}")
    public ResponseEntity deleteResourceWork(@PathVariable String projectId,@PathVariable String resourceId) {
        return service.deleteResourceWork(projectId, resourceId);
    }
}
