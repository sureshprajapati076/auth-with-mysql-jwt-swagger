package com.example.jwtdemo.service;

import com.example.jwtdemo.model.Credential;
import com.example.jwtdemo.model.UpdatePasswordDto;
import com.example.jwtdemo.model.User;

import java.util.List;

public interface CredentialService {

    List<Credential> getAllCredentials();
    Credential findByUserName(String username);
    Credential updateCredential(UpdatePasswordDto updatePasswordDto);
}
