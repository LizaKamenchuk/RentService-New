package org.kamenchuk.auth.impl;

import org.kamenchuk.auth.feignClient.AuthJwtClient;
import org.kamenchuk.auth.feignClient.dto.AuthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

@Service
@CrossOrigin
public class UserServiceImpl implements UserDetailsService {
    private final AuthJwtClient client;

    @Autowired
    public UserServiceImpl(AuthJwtClient client) {
        this.client = client;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        AuthUser authUser = client.loadUserDetails(login);
        return User.builder()
                .password(authUser.getPassword())
                .username(authUser.getUsername())
                .authorities(authUser.getAuthorities())
                .build();
    }
}
