package com.financial.service.services.card;

import com.financial.service.entities.Card;
import com.financial.service.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;

    public Mono<Card> createCard(Card card) {
        return cardRepository.save(card);
    }

    public Mono<Card> getCardById(Integer cardId) {
        return cardRepository.findById(cardId);
    }

    public Flux<Card> getAllCards() {
        return cardRepository.findAll();
    }

    public Flux<Card> getCardsByAccountId(Integer accountId) {
        return cardRepository.findByAccountId(accountId);
    }

    public Mono<Void> deleteCardById(Integer cardId) {
        return cardRepository.deleteById(cardId);
    }
}

