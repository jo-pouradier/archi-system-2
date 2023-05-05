package com.sp.service;

import com.sp.model.Card;
import com.sp.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    public Card getCard(UUID uuid){
        return cardRepository.findById(uuid).get();
    }

    public List<Card> getCards() {
        Stream.iterate(0, i -> i + 1).limit(5).forEach(i -> {
            Card card = Card.builder()
                    .withName("Card " + i)
                    .withFamily("Family " + i)
                    .withDescription("Description " + i)
                    .build();
            cardRepository.save(card);
        });
        List<Card> cards = new ArrayList<Card>();
        cardRepository.findAll().iterator().forEachRemaining(cards::add);
        return cards;
    }

    public Card saveCard(Card card){
        return cardRepository.save(card);
    }

    public void deleteCard(UUID uuid){
        cardRepository.deleteById(uuid);
    }

    public void deleteCard(Card card){
        cardRepository.delete(card);
    }

}
