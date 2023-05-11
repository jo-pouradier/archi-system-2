package com.sp.service;

import com.sp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthService {

    @Autowired
    private UserService userService;
    public boolean logUser(String cookie) {
        return true;
    }

    public UUID login(String username, String password) {
        User user = userService.getUser(username);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                return user.getUUID();
            }
        }
        return null;
    }

    public UUID register(String username, String password, String email) {
        return userService.addUser(new User(username, password, email)) ? userService.getUser(username).getUUID() : null;
    }
    public static Integer existUser(String username, String password) {
        return 1;
    }
}
