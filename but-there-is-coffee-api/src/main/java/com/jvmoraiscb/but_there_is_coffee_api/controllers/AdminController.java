package com.jvmoraiscb.but_there_is_coffee_api.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/admin")
public class AdminController {
    @PostMapping()
    public void registerAdmin(@RequestBody String email, String password, List<UUID> adminGroupsIds){
        //TODO
    }

    @PutMapping
    public void updateAdmin(@RequestBody String email, String newEmail, String password, String newPassword){
        //TODO
    }

    @DeleteMapping
    public void deleteAdmin(@RequestBody String email, String password, String adminId){
        //TODO
    }

}
