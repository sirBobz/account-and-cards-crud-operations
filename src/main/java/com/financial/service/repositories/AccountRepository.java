package com.financial.service.repositories;

import com.financial.service.entities.Account;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface AccountRepository extends ReactiveCrudRepository<Account, Integer> {
}
