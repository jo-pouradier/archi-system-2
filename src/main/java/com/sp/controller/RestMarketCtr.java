package com.sp.controller;

import com.sp.model.Card;
import com.sp.model.Transaction;
import com.sp.service.CardService;
import com.sp.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("market")
public class RestMarketCtr {

    /*
    Créer une transaction
    Annuler une transaction
    Accepter une transaction
     */


    @Autowired
    private MarketService market;

    @PostMapping(value = "/createTransaction", produces = "application/json")
    public ResponseEntity createTransaction(@RequestBody Transaction transaction){
        boolean allow = market.createTransaction(transaction);
        return new ResponseEntity(HttpStatus.OK);
    }



}
