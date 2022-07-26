package com.rafaelamaral.mscard.repository;

import com.rafaelamaral.mscard.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface CardRepository extends JpaRepository<Card , Long> {

    List<Card> findByIncomeLessThanEqual(BigDecimal incomeBigDecimal);
}
