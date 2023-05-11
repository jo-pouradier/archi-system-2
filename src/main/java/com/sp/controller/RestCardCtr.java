package com.sp.controller;

import com.sp.model.Card;
import com.sp.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("card")
public class RestCardCtr {

    @Autowired
    private CardService cardService;

    @GetMapping(value = "/getCards", produces = "application/json")
    public List<Card> getCards() {
        List<Card> cards = cardService.getCards();
        System.out.println(Arrays.toString(cards.toArray()));
        return cards;
    }
    @GetMapping(value = "/card/{uuid}", produces = "application/json")
    public Card getCard(@PathVariable("uuid") String uuid) {
        return cardService.getCard(UUID.fromString(uuid));
    }


//    @GetMapping (value = "/", produces = "text/html")
//    public ModelAndView getAddCardHtml(Model model) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("html/cardList.html");
//        return modelAndView;
//    }

    @PostMapping (value = "/addCard", produces = "application/json")
    public Card addCard(@RequestBody Card card){
        cardService.saveCard(card);
        return card;
    }
}
