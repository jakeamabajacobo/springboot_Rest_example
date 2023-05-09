package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Iterator;
import java.util.List;

//contoller to handel the web content request

@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService service;
    @GetMapping("/users")
    public List<User> retriveAllUsers(){
        return service.findAll();
    }

    @GetMapping("/userNameonly/{name}")
    public User getName(@PathVariable String name) throws  UserNotFoundException{
        User user = service.findName(name);
        if(user==null) throw new UserNotFoundException(name);

        return user;

//        return String.valueOf(service.findName(name));
    }

    @GetMapping("/user/{id}")
    public User retreiveUser(@PathVariable int id) throws UserNotFoundException {
        User user = service.findOne(id);
        if(user==null) throw new UserNotFoundException("ID: " +id);

        return user;
    }

    @PostMapping("/saveuser")
    public ResponseEntity<Object> createUser(@RequestBody User user){
        logger.info("POST FORM: " + user);
        User savedUser=  service.saveUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PostMapping("/removeuser/{id}")
    public List<User> DeleteUser(@PathVariable int id){
            List<User> userList = service.DeleteById(id);

             if(userList==null) throw new UserNotFoundException("ID: " +id);

             return userList;
    }



}
