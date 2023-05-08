package com.sp.controller;

import com.sp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class RestUserCtr {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/addUser", produces = "text/html")
    public String getAddUserHtml(Model model) {
        return "html/addUser";
    }
}
