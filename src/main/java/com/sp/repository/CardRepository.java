package com.sp.repository;

import com.sp.model.Card;
import org.springframework.data.repository.CrudRepository;

import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

public class CardRepository extends SimpleUUIDAbstractRepository<Card> {

}
