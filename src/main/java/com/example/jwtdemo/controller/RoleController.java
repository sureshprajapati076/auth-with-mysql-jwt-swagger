package com.example.jwtdemo.controller;

import com.example.jwtdemo.model.Credential;
import com.example.jwtdemo.model.Role;
import com.example.jwtdemo.service.CredentialService;
import com.example.jwtdemo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    RoleService roleService;

    @PostMapping("/add")
    public Role addRole(@RequestBody Role role){
        return roleService.addRole(role);
    }
    @GetMapping("/all")
    public List<Role> addRoles(){
        return roleService.getAllRoles();
    }
}
