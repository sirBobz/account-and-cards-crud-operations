package com.financial.service.repositories;

import com.financial.service.entities.Card;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface CardRepository extends ReactiveCrudRepository<Card, Integer> {

    Flux<Card> findByAccountId(Integer accountId);
}
