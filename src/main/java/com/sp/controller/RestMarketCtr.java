package com.sp.controller;

import com.sp.model.Card;
import com.sp.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@Controller
public class RestMarketCtr {

    @Autowired
    private CardService cardService;

    // get mapping for rest api request with json data and return empty response ok or error
    @GetMapping(value = "/test/{uuid}", produces = "application/json")
    public ResponseEntity<?> post(@PathVariable("uuid") String uuid) {
        Card card = cardService.getCard(UUID.fromString(uuid));
        if(card == null){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("This card don't exist");
        }else {
            return ResponseEntity.ok().body(card);
        }
    }



}
