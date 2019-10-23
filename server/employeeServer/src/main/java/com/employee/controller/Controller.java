package com.employee.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.stereotype.Controller
public class Controller {
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "Hello world";
    }
}
