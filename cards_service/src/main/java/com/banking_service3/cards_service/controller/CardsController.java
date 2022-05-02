package com.banking_service3.cards_service.controller;

import com.banking_service3.cards_service.model.Cards;
import com.banking_service3.cards_service.model.Customer;
import com.banking_service3.cards_service.repository.CardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardsController {

    @Autowired
    private CardsRepository cardsRepository;

    @PostMapping("/myCards")
    public List<Cards> getCardDetails(@RequestBody Customer customer){

        List<Cards> cards = cardsRepository.findByCustomerId(customer.getCustomerId());

        if(cards != null){
            return cards;
        }else{
            return null;
        }

    }
}
