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

    @Autowired
    private MarketRepository marketRepository;

    public Transaction createTransaction(Transaction transaction) {
        User from = userService.getUser(transaction.getFromUserUUID());
        Card card = cardService.getCard(transaction.getCardUUID());
        if (from != null && card != null) {
            if(existTransaction(from.getUUID(), card.getUUID()))
                return null;
            if (cardService.getCardsByOwnerUUID(from.getUUID()).contains(card)) {
                transaction.setStatus("pending");
                transaction = marketRepository.save(transaction);
                return transaction;
            }
        }
        return null;
    }

    public Transaction getByFromAndCard(UUID from, UUID card) {
        return marketRepository.findByFromUserUUIDAndCardUUID(from, card);
    }

    public boolean existTransaction(UUID from, UUID card) {
        return getByFromAndCard(from, card) != null;
    }

    public boolean isValidTranscation(Transaction transaction) {
        Transaction valid = marketRepository.findById(transaction.getTranscationUUID()).orElse(null);
        if (valid == null)
            return false;
        if (valid.getFromUserUUID().equals(transaction.getFromUserUUID()) &&
                valid.getCardUUID().equals(transaction.getCardUUID()))
            return true;
        return false;
    }

    public Transaction cancelTransaction(Transaction transaction) {
        if (!isValidTranscation(transaction))
            return null;
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
