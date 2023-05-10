package com.sp.controller;

import com.sp.model.Card;
import com.sp.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("card")
public class RestCardCtr {

    @Autowired
    private CardService cardService;

    @GetMapping(value = "/", produces = "application/json")
    public List<Card> getCards() {
        List<Card> cards = cardService.getCards();
        System.out.println(Arrays.toString(cards.toArray()));
        return cards;
    }
    @GetMapping(value = "/card={uuid}", produces = "application/json")
    public Card getCard(@PathVariable("uuid") String uuid) {
        Card card = cardService.getCard(UUID.fromString(uuid));
        return card;
    }
    @GetMapping(value = "/user={uuid}", produces = "application/json")
    public List<Card> getUserCards(@PathVariable("uuid") String uuid) {
        List<Card> card = cardService.getCardsByOwnerUUID(UUID.fromString(uuid));
        return card;
    }
}
