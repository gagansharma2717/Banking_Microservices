package com.banking_service3.cards_service.controller;

import java.util.List;

import com.banking_service3.cards_service.config.CardsServiceConfig;
import com.banking_service3.cards_service.model.Cards;
import com.banking_service3.cards_service.model.Customer;
import com.banking_service3.cards_service.model.Properties;
import com.banking_service3.cards_service.repository.CardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;


@RestController
public class CardsController {

    @Autowired
    private CardsRepository cardsRepository;

    @Autowired
    CardsServiceConfig cardsConfig;

    @PostMapping("/myCards")
    public List<Cards> getCardDetails(@RequestHeader("yeezybank-correlation-id") String correlationid, @RequestBody Customer customer) {
        List<Cards> cards = cardsRepository.findByCustomerId(customer.getCustomerId());
        if(cards != null) {
            return cards;
        } else {
            return null;
        }

    }

    @GetMapping("/cards/properties")
    public String getPropertyDetails() throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties properties = new Properties(cardsConfig.getMsg(), cardsConfig.getBuildVersion(),
                cardsConfig.getMailDetails(), cardsConfig.getActiveBranches());
        String jsonStr = ow.writeValueAsString(properties);
        return jsonStr;
    }
}
