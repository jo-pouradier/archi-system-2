package com.sp.controller;

import com.sp.model.User;
import com.sp.model.UserDTO;
import com.sp.model.UserRegisterDTO;
import com.sp.service.AuthService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
public class RestAuthCtr {

    @Autowired
    private AuthService authService;

    @PostMapping(value = "/login-form")
    public ResponseEntity<?> login(@RequestBody Map<String,String> data) {
        User user = authService.login(data.get("email"), data.get("password"));
        if (user == null) {
            return new ResponseEntity<String>("Null",HttpStatus.FORBIDDEN); // on renvoie l'uuid ou null;
        }
        return new ResponseEntity<User>(user,HttpStatus.OK); // on renvoie l'uuid ou null;
    }

    @PostMapping(value = "/register-form")
    public UserDTO register(@RequestBody UserRegisterDTO data) {
        User user = authService.register(data.getUsername(),data.getPassword(), data.getEmail()); // on renvoie l'uuid ou null;
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }



    // @GetMapping("/write-spring-cookie")
    // @GetMapping("/read-spring-cookie")


}

