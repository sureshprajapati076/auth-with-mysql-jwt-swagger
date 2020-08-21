package com.example.jwtdemo.service.impl;

import com.example.jwtdemo.model.Credential;
import com.example.jwtdemo.model.UpdatePasswordDto;
import com.example.jwtdemo.repository.CredentialRepository;
import com.example.jwtdemo.service.CredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service

public class CredentialServiceImpl implements CredentialService {
    @Autowired
    CredentialRepository credentialRepository;
    @Autowired
    private PasswordEncoder bcryptEncoder;



    @Override
    public List<Credential> getAllCredentials() {
        return credentialRepository.findAll();
    }

    @Override
    public Credential findByUserName(String username) {
        return credentialRepository.findByUsername(username);
    }

    @Override
    public Credential updateCredential(UpdatePasswordDto updatePasswordDto) {
        Credential credential=credentialRepository.findByUsername(updatePasswordDto.getUsername());
        credential.setPassword(bcryptEncoder.encode(updatePasswordDto.getNewPassword()));
        return credentialRepository.save(credential);
    }
}
