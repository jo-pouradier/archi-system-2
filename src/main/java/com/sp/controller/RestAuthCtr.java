package com.sp.controller;

import com.sp.service.AuthService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class RestAuthCtr {

        @PostMapping(value = "/login-form", produces = "text/html")
        public UUID login(@RequestParam("username") String username, @RequestParam("password") String password) {
             return AuthService.login(username, password); // on renvoie l'uuid ou null;
        }

    @PostMapping(value = "/register-form", produces = "text/html")
    public UUID register(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("email") String email) {
        return AuthService.register(username, password, email); // on renvoie l'uuid ou null;
    }





        // @GetMapping("/write-spring-cookie")
        // @GetMapping("/read-spring-cookie")


}
