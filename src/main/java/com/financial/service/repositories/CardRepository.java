package com.financial.service.repositories;

import com.financial.service.entities.Card;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface CardRepository extends ReactiveCrudRepository<Card, Integer> {

    Flux<Card> findByAccountId(Integer accountId);
}
