package com.afra.facade.resources;

import com.afra.entities.ResourceEntities;
import com.afra.services.resource.ResourceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/afra/resources")
public class ResourceController implements Resource{

    @Autowired
    ResourceServiceImpl service;

    @Override
    @GetMapping("/all")
    public ResponseEntity<List<ResourceEntities>> getAllResources() {
        return service.getAllResources();
    }

    @Override
    @GetMapping("/byId/{id}")
    public ResponseEntity<ResourceEntities> getResourceById(@PathVariable String id) {
        return service.getResourceById(id);
    }

    @Override
    @PostMapping("/create")
    public ResponseEntity<ResourceEntities> createResource(@RequestBody ResourceEntities resource) {
       return service.createResource(resource);
    }

    @Override
    @PutMapping("/update")
    public ResponseEntity<ResourceEntities> updateResource(@RequestBody ResourceEntities resource) {
        return service.updateResource(resource);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteResource(@PathVariable String id) {
        return service.deleteResource(id);
    }
}
