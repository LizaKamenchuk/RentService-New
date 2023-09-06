package org.kamenchuk.auth.feignClient;

import org.kamenchuk.auth.feignClient.dto.AuthUser;
import org.kamenchuk.auth.feignClient.dto.LoginCredentials;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "authJwtClient", url = "localhost:8080/rent_module/user")
public interface AuthJwtClient {

    @GetMapping (value = "/loadUser", consumes = {MediaType.APPLICATION_JSON_VALUE})
    AuthUser loadUserDetails(@RequestParam String login);
    @PostMapping(path = "/login", produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<String> createAuthenticationToken(@RequestBody LoginCredentials body);

}
