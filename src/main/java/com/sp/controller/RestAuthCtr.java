package com.sp.controller;

import com.sp.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
public class RestAuthCtr {

    @PostMapping(value = "/login-form", produces = "text/html")
    public ResponseEntity login(@RequestBody Map<String,String> data) {
         return new ResponseEntity(AuthService.login(data.get("username"),data.get("password")), HttpStatus.OK); // on renvoie l'uuid ou null;
    }

    @PostMapping(value = "/register-form", produces = "text/html")
    public UUID register(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("email") String email) {
        return AuthService.register(username, password, email); // on renvoie l'uuid ou null;
    }

}
