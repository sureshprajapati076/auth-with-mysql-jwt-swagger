package com.example.jwtdemo.service;

import com.example.jwtdemo.model.Role;

import java.util.List;

public interface RoleService {
    Role addRole(Role role);
    List<Role> getAllRoles();
}
