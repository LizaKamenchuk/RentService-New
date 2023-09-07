package org.kamenchuk.rentModule.service;

import org.kamenchuk.dto.userDTO.UserCreateRequest;
import org.kamenchuk.dto.userDTO.UserResponse;
import org.kamenchuk.rentModule.feinClient.FeignUserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final FeignUserClient feignUserClient;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(FeignUserClient feignUserClient, PasswordEncoder passwordEncoder) {
        this.feignUserClient = feignUserClient;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UserResponse> getAllUser() {
        return feignUserClient.getAllUser();
    }

    public UserResponse findById(Long id) {
        return feignUserClient.findById(id);
    }

    public UserResponse create(UserCreateRequest userDto) {
        return feignUserClient.create(encodeRawPassword(userDto));
    }

    public void delete(Long id) {
        feignUserClient.delete(id);
    }

    public UserResponse updateLogin(String newLogin, Long id) {
        return feignUserClient.updateLogin(newLogin, id);
    }

    public UserResponse changeUserRole(Long id, String role) {
        return feignUserClient.changeUserRole(id, role);
    }

    private UserCreateRequest encodeRawPassword(UserCreateRequest userDto) {
        String encodedPassword = passwordEncoder.encode(userDto.getPassword());
        userDto.setPassword(encodedPassword);
        return userDto;
    }
}
