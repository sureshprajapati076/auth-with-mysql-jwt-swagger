package com.example.jwtdemo.controller;

import com.example.jwtdemo.model.Credential;
import com.example.jwtdemo.model.User;
import com.example.jwtdemo.service.CredentialService;
import com.example.jwtdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;


    @GetMapping("/all")
    public List<User> allUsers(){
        return userService.getAllUsers();
    }

}
