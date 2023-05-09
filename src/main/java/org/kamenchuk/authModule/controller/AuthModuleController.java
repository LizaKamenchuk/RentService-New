package org.kamenchuk.authModule.controller;

import org.kamenchuk.authModule.feignClient.AuthJwtClient;
import org.kamenchuk.authModule.feignClient.dto.LoginCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth_gateway")
public class AuthModuleController {
    private final AuthJwtClient jwtClient;
    public static HttpStatus STATUS = HttpStatus.UNAUTHORIZED;

    @Autowired
    public AuthModuleController(AuthJwtClient jwtClient) {
        this.jwtClient = jwtClient;
    }

    @GetMapping(value = "/authenticate")
    public  ResponseEntity authenticate(@RequestBody LoginCredentials body) {
       ResponseEntity <String> token = jwtClient.createAuthenticationToken(body);
       if(token.getStatusCode().equals(HttpStatus.OK)) STATUS = HttpStatus.OK;
       return token;
    }
}
