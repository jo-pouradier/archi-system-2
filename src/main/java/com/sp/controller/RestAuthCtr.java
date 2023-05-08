package com.sp.controller;

import com.sp.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RestAuthCtr {

    @GetMapping(value = {"/login"}, produces = "text/html")
    public String login(Model model) {
        String cookie = readCookie("user-id");
        if(AuthService.logUser(cookie)){
            model.addAttribute("message", "Welcome to the home page!");
            model.addAttribute("messageLocal", "Welcome to the home page!");
            return "html/login";
        } else {
            return "index";
        }
    }

   // @GetMapping("/read-spring-cookie")
    public String readCookie(
            @CookieValue(name = "user-id", defaultValue = "0") String userId) {
        return userId;
    }

}
