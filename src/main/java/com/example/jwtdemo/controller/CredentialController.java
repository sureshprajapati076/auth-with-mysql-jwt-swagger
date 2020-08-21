package com.example.jwtdemo.controller;

import com.example.jwtdemo.config.JwtTokenUtil;
import com.example.jwtdemo.model.Credential;
import com.example.jwtdemo.model.UpdatePasswordDto;
import com.example.jwtdemo.service.CredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/credentials")
public class CredentialController {

    @Autowired
    CredentialService credentialService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private AuthenticationManager authenticationManager;




    @PutMapping(path="/update")
    public ResponseEntity<?> updateUser(@RequestBody UpdatePasswordDto updatePasswordDto, HttpServletRequest request) {
        if (request.getHeader("Authorization") != null) {
            String username = jwtTokenUtil.getUsernameFromToken(request.getHeader("Authorization").substring(7));
            updatePasswordDto.setUsername(username);
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, updatePasswordDto.getCurrentPassword()));
            return ResponseEntity.ok(credentialService.updateCredential(updatePasswordDto));
        }
        return  new ResponseEntity<>("Authorization Header Not Valid/Found",HttpStatus.UNAUTHORIZED);
    }
    @GetMapping("/all")
    public List<Credential> allCredentials(){
        return credentialService.getAllCredentials();
    }


}
