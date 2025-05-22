package com.jvmoraiscb.but_there_is_coffee_api.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/user")
public class UserController {
    @PostMapping()
    public void registerUser(){
        //TODO
    }

    @GetMapping(path = "availableGroups")
    public void getAvailableGroups(){
        //TODO
    }

    @GetMapping(path = "groups")
    public void getUserGroups(){
        //TODO
    }

    @DeleteMapping(path = "groups")
    public void deleteUserGroups(){
        //TODO
    }

}
