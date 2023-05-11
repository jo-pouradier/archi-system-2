package com.sp.service;

import com.sp.model.Card;
import com.sp.model.Transaction;
import com.sp.model.User;
import com.sp.repository.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class MarketService {

    @Autowired
    private MarketRepository market;

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

    public Transaction cancelTransaction(Transaction transaction) {
        User from = userService.getUser(transaction.getFromUserUUID());
        Card card = cardService.getCard(transaction.getCardUUID());
        if (from != null && card != null) {
            if (cardService.getCardsByOwnerUUID(from.getUUID()).contains(card)) {
                transaction.setStatus("canceled");
                return transaction;
            }
        }
        return null;
    }

    public List<Transaction> getTransactions() {
        List<Transaction> transactions = new ArrayList<Transaction>();
        market.findAll().iterator().forEachRemaining(transactions::add);
        return transactions;
    }
}
