package com.financial.service.controllers;
import com.financial.service.entities.Card;
import com.financial.service.services.card.CardService;
import io.r2dbc.spi.Parameter;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/cards")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping
    public Flux<Card> getAllCards() {

        //Implement pagination
        return cardService.getAllCards();
    }

    @GetMapping("/{cardId}")
    public Mono<Card> getCardById(@PathVariable Integer cardId) {
        return cardService.getCardById(cardId);
    }

    @GetMapping("/account/{accountId}")
    public Flux<Card> getCardsByAccountId(@PathVariable Integer accountId) {
        return cardService.getCardsByAccountId(accountId);
    }
    @PostMapping
    public Mono<Card> createCard(@Valid @RequestBody Card card) {
        return cardService.createCard(card);
    }


    @DeleteMapping("/{cardId}")
    public Mono<Void> deleteCard(@PathVariable Integer cardId) {
        return cardService.deleteCardById(cardId);
    }
}

