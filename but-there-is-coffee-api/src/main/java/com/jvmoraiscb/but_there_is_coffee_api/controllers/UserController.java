package com.jvmoraiscb.but_there_is_coffee_api.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/user")
public class UserController {
    @PostMapping()
    public void registerUser(@RequestBody String email, List<UUID> userGroupsIds){
        //TODO
    }

    @GetMapping(path = "availableGroups")
    public void getAvailableGroups(){
        //TODO
    }

    @GetMapping(path = "userGroups")
    public void getUserGroups(){
        //TODO
    }

    @DeleteMapping(path = "userGroups")
    public void deleteUserGroups(@RequestBody List<UUID> userGroupsIds){
        //TODO
    }

}
