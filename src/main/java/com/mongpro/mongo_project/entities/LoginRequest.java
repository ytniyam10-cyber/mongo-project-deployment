package com.mongpro.mongo_project.entities;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String pass;
}
