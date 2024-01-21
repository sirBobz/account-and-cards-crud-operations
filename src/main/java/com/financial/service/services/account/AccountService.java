package com.financial.service.services.account;

import com.financial.service.entities.Account;
import com.financial.service.repositories.AccountRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Mono<Account> createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Mono<Account> getAccountById(Integer accountId) {
        return accountRepository.findById(accountId);
    }

    public Mono<Void> deleteAccountById(Integer accountId) {
        return accountRepository.deleteById(accountId);
    }
}
