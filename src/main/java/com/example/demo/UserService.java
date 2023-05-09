package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

//User Service - handle communication to User Object class to UserController
@Component
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    public static int userCount = 5;
    private static List<User> users = new ArrayList<>();

    static{
        users.add(new User(1,"Jacob",new Date()));
        users.add(new User(2,"Jhiro",new Date()));
        users.add(new User(3,"Jake",new Date()));
        users.add(new User(4,"jeff",new Date()));
        users.add(new User(5,"Jun",new Date()));
    }

    public List<User> findAll(){
        return users;
    }


    public User saveUser(User user){
        if(user.getId()==null){
            user.setId(++userCount);
        }

        users.add(user);
        return user;
    }



    public User findOne(int id){
        for(User user:users){
            if(user.getId()==id)
                return user;
        }
        return null;
    }


    public User findName(String name) {

        for (User user : users) {
            logger.info("name from resource: " + name + "name check: " + user.getName());
           if(user.getName().equals(name)){
               logger.info("return user: " + user.toString());
               return user;
           }
        }
        return null;
    }

    public List<User> DeleteById(int id){
        Iterator<User> iterator = users.iterator();
        while(iterator.hasNext()){
            User user =iterator.next();
                if(user.getId()==id){
                    iterator.remove();
                    return users;
                }
        }
      return null;
    }






}
