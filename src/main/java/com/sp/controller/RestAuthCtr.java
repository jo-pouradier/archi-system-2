package com.sp.controller;

import com.sp.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class RestAuthCtr {

    @Autowired
    private AuthService authService;

    @PostMapping(value = "/login-form", produces = "text/html")
    public UUID login(@RequestParam("username") String username, @RequestParam("password") String password) {
        return authService.login(username, password); // on renvoie l'uuid ou null;
    }

    @PostMapping(value = "/register-form", produces = "text/html")
    public UUID register(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("email") String email) {
        return authService.register(username, password, email); // on renvoie l'uuid ou null;
    }


    // @GetMapping("/write-spring-cookie")
    // @GetMapping("/read-spring-cookie")


}
