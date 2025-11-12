package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.client.UserClient;
import com.example.demo.client.UserDto;

@Service
public class UserService {

    private final UserClient userClient;

    public UserService(UserClient userClient) {
        this.userClient = userClient;
    }

    public UserDto getUser(Long id) {
        return userClient.getUserById(id);
    }
}
