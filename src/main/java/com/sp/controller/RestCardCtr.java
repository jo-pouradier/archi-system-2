package com.sp.controller;

import com.sp.service.CardService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestCardCtr {

    private final CardService cardService;

    RestCardCtr(CardService cardService) {
        this.cardService = cardService;
    }



}
