package com.rafaelamaral.mscard.service;


import com.rafaelamaral.mscard.entity.Card;
import com.rafaelamaral.mscard.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;

    @Transactional
    public Card save(Card card){
        return cardRepository.save(card);
    }

    @Transactional(readOnly = true)
    public List<Card> findByIncomeLessThanEquals(Long income){
        var incomeBigDecimal = BigDecimal.valueOf(income);
        return cardRepository.findByIncomeLessThanEqual(incomeBigDecimal);
    }

}
