package com.afra.persistance.users;

import com.afra.entities.UsersEntities;
import com.afra.models.UserModel;
import com.afra.services.users.UserServiceImpl;
import com.afra.services.users.UsersService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
public class UserTest {


    @Test
    public void RegisterUser(){
        UserServiceImpl service = new UserServiceImpl();
        UsersEntities model = new UsersEntities();
        model.setAccessFk(1);
        model.setPassword("Test");
        model.setResourceFk("Test too");
        ResponseEntity<UsersEntities> result = service.registerUser(model);
        Assert.assertNotNull("Success",result);
    }
}
