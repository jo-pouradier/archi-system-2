package com.sp.service;

import com.sp.model.OwnerUUID;
import com.sp.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    public Optional<OwnerUUID> getCard(UUID uuid){;
        return cardRepository.findById(uuid);
    }

    public Iterable<OwnerUUID> getCards(){
        return cardRepository.findAll();
    }

    public OwnerUUID saveCard(OwnerUUID card){
        return cardRepository.save(card);
    }

    public void deleteCard(UUID uuid){
        cardRepository.deleteById(uuid);
    }

    public void deleteCard(OwnerUUID card){
        cardRepository.delete(card);
    }

}
