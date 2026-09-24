package com.mongpro.mongo_project.services;

import com.mongpro.mongo_project.entities.User;
import com.mongpro.mongo_project.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class UserService {
    @Autowired
    public UserRepo repo;
    @Autowired
    public PasswordEncoder passwordEncoder;

    public void create (User user){
        user.setPass(passwordEncoder.encode(user.getPass()));
        repo.save(user);
    }

    public List<User> get(){
        return repo.findAll();
    }

    public User findbyname(String name){
        return repo.findByUsername(name);
    }

    public void deleteuser(User user){
        repo.delete(user);
    }

    @Transactional
    public void updateUser(User user, String name){
        User old= findbyname(name);
        old.setUsername(user.getUsername());
        old.setPass(passwordEncoder.encode(user.getPass()));
        repo.save(old);
    }

//    @Scheduled(fixedRate = 5000)
//    public void check(){
//        System.out.println("Scheduled job");
//    }



}
