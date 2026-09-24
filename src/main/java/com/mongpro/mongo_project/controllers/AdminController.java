package com.mongpro.mongo_project.controllers;

import com.mongpro.mongo_project.entities.User;
import com.mongpro.mongo_project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    public UserService userService;

    @GetMapping("/view-all")
    public ResponseEntity<List<User>> showall(){
        List<User> users = userService.get();
        if(!users.isEmpty())return new ResponseEntity<>(users, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
