package com.sp.service;

import com.sp.model.User;
import com.sp.repository.SimpleUUIDAbstractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private static SimpleUUIDAbstractRepository simpleUUIDAbstractRepository;
    public static boolean addUser(User user) {
        return false;
    }

    public static boolean remUser(UUID uuid) {
        return false;
    }

    public static boolean getUser(UUID uuid) {
        return simpleUUIDAbstractRepository.existsById(uuid);
    }
}
