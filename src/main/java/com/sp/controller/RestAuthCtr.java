package com.sp.controller;

import com.sp.model.AbstractCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RestAuthCtr {

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {
        if(readCookie())
        ResponseCookie springCookie = ResponseCookie.from("user-id", "c2FtLnNtaXRoQGV4YW1wbGUuY29t")
                .httpOnly(true)
                .secure(true)
                .path("/")
                .maxAge(60)
                .domain("example.com")
                .build();
        ResponseEntity
                .ok()
                .header(HttpHeaders.SET_COOKIE, springCookie.toString())
                .build();
        return "index";
    }

    @GetMapping("/read-spring-cookie")
    public String readCookie(
            @CookieValue(name = "user-id", defaultValue = "0") String userId) {
        return userId;
    }
}
