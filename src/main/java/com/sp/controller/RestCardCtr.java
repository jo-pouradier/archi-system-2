package com.sp.controller;

import com.sp.model.Card;
import com.sp.service.CardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("card")
public class RestCardCtr {

    private final CardService cardService;

    RestCardCtr(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping(value = "/", produces = "application/json")
    public List<Card> getCards() {
        List<Card> cards = cardService.getCards();
        System.out.println(Arrays.toString(cards.toArray()));
        return cards;
    }
    @GetMapping(value = "/{uuid}", produces = "application/json")
    public Card getCard(@PathVariable("uuid") String uuid) {
        return cardService.getCard(UUID.fromString(uuid));
    }



}
