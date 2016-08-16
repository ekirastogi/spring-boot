package com.ekiras.controller;

import com.ekiras.domain.User;
import com.ekiras.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ekansh
 * @since 14/8/16
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired private UserService userService;

    @RequestMapping("/list")
    public ResponseEntity list(){
        ResponseEntity<Iterable> entity = new ResponseEntity<Iterable>(userService.list(), HttpStatus.OK);
        return entity;
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ResponseEntity<User> save(@RequestBody User user){
        ResponseEntity<User> entity = new ResponseEntity<User>(userService.save(user),HttpStatus.OK);
        return entity;
    }


}
