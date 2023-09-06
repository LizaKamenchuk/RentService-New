package org.kamenchuk.rentModule.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.kamenchuk.dto.userDTO.UserCreateRequest;
import org.kamenchuk.dto.userDTO.UserResponse;
import org.kamenchuk.rentModule.feinClient.FeignUserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/rent_module/user")
@SecurityRequirement(name = "bearerToken")
public class UserController {
    private final FeignUserClient feignUserClient;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(FeignUserClient feignUserClient, PasswordEncoder passwordEncoder) {
        this.feignUserClient = feignUserClient;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping(value = "/admin/all")
    public List<UserResponse> getAllUser() {
        return feignUserClient.getAllUser();
    }

    @GetMapping(value = "/admin/findById/{id}")
    public UserResponse findById(@PathVariable Long id) {
        return feignUserClient.findById(id);
    }

    @PostMapping(value = "/create")
    public UserResponse create(@RequestBody UserCreateRequest userDto) {
        return feignUserClient.create(encodeRawPassword(userDto));
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable Long id) {
        feignUserClient.delete(id);
    }

    @PatchMapping("/updateLogin")
    public UserResponse updateLogin(@RequestParam String newLogin, @RequestParam Long id) {
        return feignUserClient.updateLogin(newLogin, id);
    }

    @PostMapping("/admin/changeUserRole/{id}")
    public UserResponse changeUserRole(@PathVariable Long id, @RequestParam String role) {
        return feignUserClient.changeUserRole(id, role);
    }

    private UserCreateRequest encodeRawPassword(UserCreateRequest userDto) {
        String encodedPassword = passwordEncoder.encode(userDto.getPassword());
        userDto.setPassword(encodedPassword);
        return userDto;
    }

}
