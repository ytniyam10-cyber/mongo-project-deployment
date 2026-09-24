package com.mongpro.mongo_project.controllers;

import com.mongpro.mongo_project.entities.User;
import com.mongpro.mongo_project.repo.UserRepo;
import com.mongpro.mongo_project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    public UserService service;
    @Autowired
    public UserRepo repo;
    @Autowired
    public PasswordEncoder passwordEncoder;


    @GetMapping("/find")
    public User find(){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String name= authentication.getName();
        return service.findbyname(name);
    }

    @PutMapping("/update")
    public void update (@RequestBody User user){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String oldname= authentication.getName();
        User userindb = repo.findByUsername(oldname);
        if(user.getUsername()!=null)userindb.setUsername(user.getUsername());
        if(user.getPass()!=null)userindb.setPass(passwordEncoder.encode(user.getPass()));
        repo.save(userindb);

    }
    @DeleteMapping("/delete")
    public void deleali(){
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        String oldname= authentication.getName();
        User userindb = repo.findByUsername(oldname);
        service.deleteuser(userindb);
    }





}
