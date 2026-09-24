package com.mongpro.mongo_project.services;

import com.mongpro.mongo_project.entities.User;
import com.mongpro.mongo_project.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerDetailsService implements UserDetailsService {
    @Autowired
    public UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if(user!=null){
            return org.springframework.security.core.userdetails.User.withUsername(user.getUsername())
                    .password(user.getPass())
                    .roles(user.getRoles().toArray(new String[0]))
                    .build();
        }
        throw new UsernameNotFoundException(
                "User not found: " + username
        );

    }
}
