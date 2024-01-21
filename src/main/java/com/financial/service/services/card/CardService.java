package com.financial.service.services.card;

import com.financial.service.entities.Card;
import com.financial.service.repositories.AccountRepository;
import com.financial.service.repositories.CardRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CardService {

    private final CardRepository cardRepository;
    private final AccountRepository accountRepository;

    public CardService(CardRepository cardRepository, AccountRepository accountRepository) {
        this.cardRepository = cardRepository;
        this.accountRepository = accountRepository;
    }

    public Mono<Card> createCard(Card card) {
        return accountRepository.existsById(card.getAccountId())
                .flatMap(exists -> {
                    if (exists) {
                        return cardRepository.save(card);

                    } else {
                        // Handle the case when the associated account does not exist - Return a good message.
                        return Mono.error(new IllegalArgumentException("Account does not exist"));
                    }
                });
    }
    public Mono<Card> getCardById(Integer cardId) {
        return cardRepository.findById(cardId);
    }

    public Flux<Card> getAllCards() {
        //Implement pagination
        return cardRepository.findAll();
    }
    public Flux<Card> getCardsByAccountId(Integer accountId) {
        return cardRepository.findByAccountId(accountId);
    }

    public Mono<Void> deleteCardById(Integer cardId) {
        return cardRepository.deleteById(cardId);
    }
}

