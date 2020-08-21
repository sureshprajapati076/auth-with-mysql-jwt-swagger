package com.example.jwtdemo.service.impl;

import java.util.Collection;


import com.example.jwtdemo.model.Credential;
import com.example.jwtdemo.model.User;
import com.example.jwtdemo.service.CredentialService;
import com.example.jwtdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    CredentialService credentialService;

    @Autowired
    UserService userService;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Credential credential = credentialService.findByUserName(username);

        if (credential == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        return new org.springframework.security.core.userdetails.User(credential.getUsername(), credential.getPassword(),
                getAuthorities(credential));

    }

    private static Collection<? extends GrantedAuthority> getAuthorities(Credential credential) {

        String[] userRoles = credential.getRoles().stream().map((role) -> role.getName()).toArray(String[]::new);


        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);

        return authorities;


    }

    public User save(User user) {

        user.getCredential().setPassword(bcryptEncoder.encode(user.getCredential().getPassword()));


        return userService.addUser(user);

    }

}