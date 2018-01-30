package com.afra.facade.resources;

import com.afra.entities.ResourceEntities;
import com.afra.services.resource.ResourceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/afra/resources")
public class ResourceController{

    @Autowired
    ResourceServiceImpl service;

    @PostMapping("/create")
    public ResponseEntity<ResourceEntities> createResource(@RequestBody ResourceEntities resource) {
        ResponseEntity<ResourceEntities> result = service.createResource(resource);
        return result;
    }
}
