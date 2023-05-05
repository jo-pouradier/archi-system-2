package com.sp.controller;

import com.sp.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RestAuthCtr {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String index(Model model) {
        String cookie = readCookie("user-id");
        if(AuthService.logUser(cookie)){
            model.addAttribute("message", "Welcome to the home page!");
            model.addAttribute("messageLocal", "Welcome to the home page!");
            return "index";
        } else {
            return "login";
        }
    }

   // @GetMapping("/read-spring-cookie")
    public String readCookie(
            @CookieValue(name = "user-id", defaultValue = "0") String userId) {
        return userId;
    }

}
