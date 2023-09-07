package org.kamenchuk.rentModule.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.kamenchuk.dto.userDTO.UserCreateRequest;
import org.kamenchuk.dto.userDTO.UserResponse;
import org.kamenchuk.rentModule.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/rent_module/user")
@SecurityRequirement(name = "bearerToken")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/admin/all")
    public List<UserResponse> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping(value = "/admin/findById/{id}")
    public UserResponse findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping(value = "/create")
    public UserResponse create(@RequestBody UserCreateRequest userDto) {
        return userService.create(userDto);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

    @PatchMapping("/updateLogin")
    public UserResponse updateLogin(@RequestParam String newLogin, @RequestParam Long id) {
        return userService.updateLogin(newLogin, id);
    }

    @PostMapping("/admin/changeUserRole/{id}")
    public UserResponse changeUserRole(@PathVariable Long id, @RequestParam String role) {
        return userService.changeUserRole(id, role);
    }

}
