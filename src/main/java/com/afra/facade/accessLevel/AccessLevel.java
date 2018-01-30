package com.afra.facade.accessLevel;

import com.afra.entities.AccessLevelsEntities;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AccessLevel {
    ResponseEntity<List<AccessLevelsEntities>> getAllAccessLevels();
    ResponseEntity<AccessLevelsEntities> getAccessLevelById(Integer id);
    ResponseEntity<AccessLevelsEntities> createAccessLevel(AccessLevelsEntities accessLevel);
    ResponseEntity<AccessLevelsEntities> updateAccessLevel(AccessLevelsEntities accessLevel);
    ResponseEntity deleteAccessLevel(Integer id);
}
