package com.ekiras.controller;

import com.ekiras.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ekansh
 * @since 8/8/16
 */
@RestController
@RequestMapping("/")
public class DemoController {

    @Autowired private UserService userService;

    @RequestMapping("/get")
    public Object test(){

        System.out.println("########  called");
        return "Hello World";
    }

    @RequestMapping("/getById/{id}")
    public Object getById(@PathVariable("id")long id){
        return userService.getById(id);
    }

    @RequestMapping("/getByName/{name}")
    public Object getByName(@PathVariable("name")String name){
        return userService.getByName(name);
    }
    @RequestMapping("/getByEmail/{email}")
    public Object getByEmail(@PathVariable("email")String email){
        return userService.getByEmail(email);
    }


}
