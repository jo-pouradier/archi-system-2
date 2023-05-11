package com.sp.service;

import com.sp.model.Card;
import com.sp.model.User;
import com.sp.repository.SimpleUUIDAbstractRepository;
import com.sp.repository.UserRepository;
import com.sp.tools.CardFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
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

    public static User getUser(String username) {
        return userRepository.findByName(username);
    }

    public static boolean existUser(String username, String password) {
        User user = userRepository.findByName(username);
        if (user != null) {
            return user.getPassword().equals(password);
        }
        return false;
    }
}
