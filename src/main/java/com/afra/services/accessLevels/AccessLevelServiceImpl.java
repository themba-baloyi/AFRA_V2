package com.afra.services.accessLevels;

import com.afra.entities.AccessLevelsEntities;
import com.afra.repository.AccessLevelRepo;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.CannotCreateTransactionException;

import java.util.List;

//todo: sort out the id issues
@Service
public class AccessLevelServiceImpl implements AccessLevelService {

    @Autowired
    AccessLevelRepo repo;



    @Override
    public ResponseEntity<List<AccessLevelsEntities>> getAllAccessLevels() {
        try{
            return new ResponseEntity<List<AccessLevelsEntities>>(IterableUtils.toList(repo.findAll()), HttpStatus.OK);
        }catch (CannotCreateTransactionException ex){
            return new ResponseEntity<List<AccessLevelsEntities>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<AccessLevelsEntities> getAccessLevelById(Integer id) {
        try{
            AccessLevelsEntities result = repo.findOne(id);
            if(result != null){
                return new ResponseEntity<AccessLevelsEntities>(result, HttpStatus.OK);
            }else {
                return new ResponseEntity<AccessLevelsEntities>(HttpStatus.NOT_FOUND);
            }
        }catch (CannotCreateTransactionException ex){
            return new ResponseEntity<AccessLevelsEntities>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<AccessLevelsEntities> createAccessLevel(AccessLevelsEntities accessLevel) {
        try{
            if(repo.findOne(accessLevel.getId()) == null){
                repo.save(accessLevel);
                return new ResponseEntity<AccessLevelsEntities>(accessLevel, HttpStatus.OK);
            }else {
                return new ResponseEntity<AccessLevelsEntities>(HttpStatus.CONFLICT);
            }
        }catch (CannotCreateTransactionException ex){
            return new ResponseEntity<AccessLevelsEntities>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<AccessLevelsEntities> updateAccessLevel(AccessLevelsEntities accessLevel) {
        try{
            if(repo.findOne(accessLevel.getId()) != null){
                repo.save(accessLevel);
                return new ResponseEntity<AccessLevelsEntities>(accessLevel, HttpStatus.OK);
            }else {
                return new ResponseEntity<AccessLevelsEntities>(HttpStatus.NOT_FOUND);
            }
        }catch (CannotCreateTransactionException ex){
            return new ResponseEntity<AccessLevelsEntities>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity deleteAccessLevel(Integer id) {
        try{
            if(repo.findOne(id) != null){
                repo.delete(id);
                return new ResponseEntity<>( HttpStatus.OK);
            }else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (CannotCreateTransactionException ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
