package org.kamenchuk.auth.controller;

import org.kamenchuk.auth.feignClient.AuthJwtClient;
import org.kamenchuk.auth.feignClient.dto.LoginCredentials;
import org.kamenchuk.auth.impl.UserServiceImpl;
import org.kamenchuk.security.jwt.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth_module")
public class AuthController {

    private final AuthJwtClient authJwtClient;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authManager;
    private final UserServiceImpl service;

    @Autowired
    public AuthController(
            AuthJwtClient authJwtClient,
            JwtUtil jwtUtil,
            AuthenticationManager authManager, UserServiceImpl service) {
        this.authJwtClient = authJwtClient;
        this.jwtUtil = jwtUtil;
        this.authManager = authManager;
        this.service = service;
    }


    @PostMapping(value = "/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody LoginCredentials body) {

        System.out.println("LoginCredentials in gw: "+body.toString());
        authManager.authenticate(new UsernamePasswordAuthenticationToken(body.getLogin(), body.getPassword()));
        final User user = (User) service.loadUserByUsername(body.getLogin());
        System.out.println("User in gw: "+user.toString());
        final String jwtToken = jwtUtil.generateToken(user);
        return new ResponseEntity<>(jwtToken, HttpStatus.OK);
    }

}
