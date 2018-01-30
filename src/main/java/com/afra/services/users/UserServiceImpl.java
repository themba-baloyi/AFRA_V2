package com.afra.services.users;

import com.afra.entities.UsersEntities;
import com.afra.repository.ResourceRepo;
import com.afra.repository.UsersRepo;
import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.CannotCreateTransactionException;

@Service
public class UserServiceImpl implements UsersService {

    @Autowired
    UsersRepo repo;

    @Autowired
    ResourceRepo resourceRepo;

    @Override
    public ResponseEntity<UsersEntities> login(String id, String password) {
        try{
            UsersEntities user = repo.login(id, password);
            if(user != null){
                return new ResponseEntity<UsersEntities>(user, HttpStatus.OK);
            }
            else{
                return new ResponseEntity<UsersEntities>(HttpStatus.CONFLICT);
            }
        }catch (CannotCreateTransactionException ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<UsersEntities> registerUser(UsersEntities data) {

        UsersEntities temp = repo.findByResourceFk(data.getResourceFk());
        Long userId;

        if(temp !=null){
             userId = temp.getId();

            if( repo.exists(userId)){
                return new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
            }else {
                try{
                    if(resourceRepo.exists(data.getResourceFk())){
                        repo.save(data);
                        return new ResponseEntity<UsersEntities>(data, HttpStatus.OK);
                    }else{
                        return new ResponseEntity<UsersEntities>(HttpStatus.CONFLICT);
                    }

                }catch (CannotCreateTransactionException ex){
                    return new ResponseEntity<UsersEntities>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        }else{
            return new ResponseEntity<UsersEntities>(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public ResponseEntity<UsersEntities> updateUser(UsersEntities data) {
        UsersEntities temp = repo.findByResourceFk(data.getResourceFk());

        if(temp != null){
            try{
                repo.save(data);
                return new ResponseEntity<UsersEntities>(data,HttpStatus.OK);
            }catch (CannotCreateTransactionException ex){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }else{
            return new ResponseEntity<UsersEntities>(HttpStatus.NO_CONTENT);
        }
    }

    @Override
    public ResponseEntity deleteUser(String id) {
        if (id != null && checkExistance(id)){
            try{
                repo.deleteByResourceFk(id);
                return new ResponseEntity(true, HttpStatus.OK);

            }catch (CannotCreateTransactionException ex){
                return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }else {
            return new ResponseEntity(false, HttpStatus.NO_CONTENT);
        }
    }

    @Override
    public ResponseEntity deactivateUser(String id) {
        if (checkExistance(id)){
            try{
                repo.deactivateById(id);
                return new ResponseEntity(true, HttpStatus.OK);
            }catch (CannotCreateTransactionException ex){
                return new ResponseEntity(false,HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }else{
            return new ResponseEntity(false, HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public ResponseEntity activateUser(String id, int accessLevel) {
        if (checkExistance(id)){
            try{
                repo.activateById(id, accessLevel);
                return new ResponseEntity(true, HttpStatus.OK);
            }catch (CannotCreateTransactionException ex){
                return new ResponseEntity(false,HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }else{
            return new ResponseEntity(false, HttpStatus.NOT_FOUND);
        }

    }

    public boolean checkExistance(String resourceId){
        UsersEntities temp = repo.findByResourceFk(resourceId);
        return temp == null ? false : true;

    }
}
