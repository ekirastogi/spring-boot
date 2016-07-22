package com.ekiras.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ekansh
 * @since 18/7/16
 */
@RestController
@RequestMapping("")
public class HomeController {

    @RequestMapping({"","/home"})
    public Object home(){

        return "Hello !! You are on PUBLIC PAGE";
    }

    @RequestMapping("/admin")
    public Object admin(){

        return "Hello !! You are on ADMIN PAGE";
    }


    @RequestMapping("/user")
    public Object user(){

        return "Hello !! You are on USER PAGE";
    }

}
