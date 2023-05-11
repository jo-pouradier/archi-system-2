package com.sp.service;

import com.sp.model.Card;
import com.sp.model.Transaction;
import com.sp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarketService {

    @Autowired
    private CardService cardService;
    
    @Autowired
    private UserService userService;

    public boolean createTransaction(Transaction transaction) {


        return false;
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
