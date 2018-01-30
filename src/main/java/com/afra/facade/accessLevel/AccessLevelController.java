package com.afra.facade.accessLevel;

import com.afra.entities.AccessLevelsEntities;
import com.afra.services.accessLevels.AccessLevelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/afra/access")
public class AccessLevelController implements AccessLevel{

    @Autowired
    AccessLevelServiceImpl service;


    @Override
    @GetMapping("/access")
    public ResponseEntity<List<AccessLevelsEntities>> getAllAccessLevels() {
        return service.getAllAccessLevels();
    }

    @Override
    @GetMapping("/access{id}")
    public ResponseEntity<AccessLevelsEntities> getAccessLevelById(@PathVariable Integer id) {
        return service.getAccessLevelById(id);
    }

    @Override
    @PostMapping("/create")
    public ResponseEntity<AccessLevelsEntities> createAccessLevel(@RequestBody AccessLevelsEntities accessLevel) {
        return service.createAccessLevel(accessLevel);
    }

    @Override
    @PutMapping("/update")
    public ResponseEntity<AccessLevelsEntities> updateAccessLevel(@RequestBody AccessLevelsEntities accessLevel) {
        return service.updateAccessLevel(accessLevel);
    }

    @Override
    @DeleteMapping("/delete")
    public ResponseEntity deleteAccessLevel(Integer id) {
        return service.deleteAccessLevel(id);
    }
}
