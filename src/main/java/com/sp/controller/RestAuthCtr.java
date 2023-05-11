package com.sp.controller;

import com.sp.service.AuthService;
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
    public UUID login(@RequestBody Map<String,String> data) {
        return authService.login(data.get("email"), data.get("password")); // on renvoie l'uuid ou null;
    }

    @PostMapping(value = "/register-form")
    public UUID register(@RequestBody Map<String,String> data) {
        return authService.register(data.get("username"), data.get("password"), data.get("email")); // on renvoie l'uuid ou null;
    }


    // @GetMapping("/write-spring-cookie")
    // @GetMapping("/read-spring-cookie")


}
