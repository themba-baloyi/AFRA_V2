package com.afra.services.users;

import com.afra.entities.UsersEntities;
import org.springframework.http.ResponseEntity;

public interface UsersService {
    ResponseEntity<UsersEntities> login(String id, String password);
    ResponseEntity<UsersEntities> registerUser(UsersEntities data);
    ResponseEntity<UsersEntities> updateUser(UsersEntities data);
    ResponseEntity deleteUser(String id);
    ResponseEntity deactivateUser(String id);
    ResponseEntity activateUser(String id, int accessLevel);

}
