package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Another Example of Controller forw eb

@Configuration
@RestController
public class DemoController {


    @GetMapping(path="/hello-world")
    public String helloworld(){
        return "Hello world";
    }

    @GetMapping(path="/hello-world-bean")
    public HelloBean hellobean(){
        return new HelloBean("HELLO BEAAN!!!");
    }

    @GetMapping(path="/hello-world/path-variable/{asd}")
    public HelloBean helloBeanPathVariable(@PathVariable String asd){
        return new HelloBean(String.format("Hello world,%s",asd));
    }





    //
////    @RequestMapping(method= RequestMethod.GET,path = "/demo")
//      @GetMapping(path = "/GET")
//    public String hello(){
//        return "Hello TEST12!";
//    }
//
//    @GetMapping(path="/hellobean")
//    public HelloBean helloBean(){
//        return new HelloBean("111MESSAGE FROM CONTROLER:!!!! ");
//    }
//
//
//
//    @Autowired
//    private UserDaoService service;
//    @GetMapping("/users")
//    public List<User> retrieveAllUsers(){
//        return service.findAll();
//    }







}
