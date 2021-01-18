package by.savin.comprent.rest;

import by.savin.comprent.entity.User;
import by.savin.comprent.service.UserService;
import by.savin.comprent.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserServiceImpl service;

//    @PutMapping("/user")
//    public void update(@RequestBody User entity){
//        service.updateUser(entity);
//    }
}
