package com.sp.service;

import com.sp.model.Card;
import com.sp.model.Transaction;
import com.sp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MarketService {

    @Autowired
    private CardService cardService;

    @Autowired
    private UserService userService;

    public Transaction createTransaction(Transaction transaction) {
        User from = userService.getUser(transaction.getFromUserUUID());
        Card card = cardService.getCard(transaction.getCardUUID());
        if (from != null && card != null) {
            if (cardService.getCardsByOwnerUUID(from.getUUID()).contains(card)) {
                transaction.setTranscationUUID(UUID.randomUUID());
                transaction.setStatus("pending");
                return transaction;
            }
        }
        return null;
    }

    public Transaction acceptTransaction(){
        return null;
    }

//    private final UserService userService;
//    private Card card;
//    public MarketService(UserService userService) {
//        this.userService = userService;
//    }

//    public boolean tradeCard(User from, User to, Card card){
//        if (userService.getUser(from.getUUID()) && userService.getUser(to.getUUID())){
//            if (from.getCardList().contains(card)){
//                from.getCardList().remove(card);
//                to.getCardList().add(card);
//                return true;
//            }
//        }
//        return false;
//    }
}
