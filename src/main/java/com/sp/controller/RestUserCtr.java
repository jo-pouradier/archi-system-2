package com.sp.controller;

import com.sp.model.Card;
import com.sp.model.User;
import com.sp.service.CardService;
import com.sp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("user")
public class RestUserCtr {

    @Autowired
    private UserService userService;
    @Autowired
    private CardService cardService;
    @GetMapping(value = "/user={uuid}", produces = "application/json")
    public ResponseEntity<?> getUser(@PathVariable("uuid") String uuid) {
        User user = userService.getUser(UUID.fromString(uuid));
        if(user == null){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("This user don't exist.");
        }else {
            return ResponseEntity.ok().body(user);
        }
    }

    @GetMapping(value = "/card={uuid}", produces = "application/json")
    public ResponseEntity<?> getUserByCard(@PathVariable("uuid") String uuid) {
        Card card = cardService.getCard(UUID.fromString(uuid));
        if(card == null){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("This card don't exist.");
        }else {
            User user = userService.getUser(card.getOwnerUUID());
            return ResponseEntity.ok().body(user);
        }
    }

    @PostMapping(value = "/create", produces = "application/json")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        userService.addUser(user);
        return ResponseEntity.ok().body(user);
    }
}
