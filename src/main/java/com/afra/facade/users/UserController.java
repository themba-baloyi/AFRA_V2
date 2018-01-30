package com.afra.facade.users;

import com.afra.entities.UsersEntities;
import com.afra.services.users.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/afra/user")
public class UserController {

    @Autowired
    UsersService service;


    @GetMapping("/login")
    public ResponseEntity<UsersEntities> login(@RequestParam String abNumber, @RequestParam String password) {
        if(abNumber != "" || password != ""){
            ResponseEntity<UsersEntities> user = service.login(abNumber, password);
            return user;

        }else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<UsersEntities> registerUser(@RequestBody UsersEntities user) {
        ResponseEntity<UsersEntities> result = service.registerUser(user);
        return result;
    }

    @PutMapping("/update")
    public ResponseEntity<UsersEntities> updateUser(@RequestBody UsersEntities user) {
        ResponseEntity<UsersEntities> result = service.updateUser(user);
        return result;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable String id) {
        ResponseEntity result = service.deleteUser(id);
        return result;
    }

    @PutMapping("/deactivate/{id}")
    public ResponseEntity deactivate(String id) {
        ResponseEntity result = service.deactivateUser(id);
        return  result;
    }

    @PutMapping("/activate/{id}/{access}")
    public ResponseEntity activate(String id, int accessLevel) {
        ResponseEntity result = service.activateUser(id, accessLevel);
        return  result;
    }
}
