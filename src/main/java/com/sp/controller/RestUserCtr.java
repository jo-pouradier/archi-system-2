package com.sp.controller;

import com.sp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestUserCtr {

    @Autowired
    private UserService userService;
}
