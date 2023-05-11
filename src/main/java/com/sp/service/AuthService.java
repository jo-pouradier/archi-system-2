package com.sp.service;

import com.sp.model.User;

import java.util.UUID;

public class AuthService {

    UserService userService;
    public static boolean logUser(String cookie) {
        return true;
    }

    public static UUID login(String username, String password) {
        User user = UserService.getUser(username);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                return user.getUUID();
            }
        }
        return null;
    }

    public static UUID register(String username, String password, String email) {
        return UserService.addUser(new User(username, password, email)) ? UserService.getUser(username).getUUID() : null;
    }
}
