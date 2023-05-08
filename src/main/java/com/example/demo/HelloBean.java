package com.example.demo;

public class HelloBean {


    //example   hellobean object class
    public   String message;

    //constructor
    public HelloBean(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public String toString(){
        return String.format("Hello [data=%s]",message);
    }
}
