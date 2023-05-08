package com.sp.service;

import com.sp.model.User;
import com.sp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private static SimpleUUIDAbstractRepository simpleUUIDAbstractRepository;
    public User addUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(UUID uuid) {
        userRepository.deleteById(uuid);
    }
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public User getUser(UUID uuid) {
        return userRepository.findById(uuid).orElse(null);
    }
}
