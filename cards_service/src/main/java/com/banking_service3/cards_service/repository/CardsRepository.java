package com.banking_service3.cards_service.repository;

import com.banking_service3.cards_service.model.Cards;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardsRepository extends JpaRepository<Cards, Long> {

    List<Cards> findByCustomerId(int customerId);
}
