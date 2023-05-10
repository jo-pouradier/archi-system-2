package com.sp.service;

import com.sp.model.User;
import com.sp.repository.SimpleUUIDAbstractRepository;
import com.sp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private static UserRepository userRepository;
    public static boolean addUser(User user) {
        user.setUUID(UUID.randomUUID());
        userRepository.save(user);
        return true;
    }

    public static boolean remUser(UUID uuid) {
        return false;
    }

    public static User getUser(UUID uuid) {
        return userRepository.findById(uuid).orElse(null);
    }
}
