package com.financial.service.services.account;

import com.financial.service.entities.Account;
import com.financial.service.repositories.AccountRepository;
import com.financial.service.repositories.CardRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final CardRepository cardRepository;

    public AccountService(AccountRepository accountRepository, CardRepository cardRepository) {
        this.accountRepository = accountRepository;
        this.cardRepository = cardRepository;
    }

    public Mono<Account> createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Mono<Account> getAccountById(Integer accountId) {
        return accountRepository.findById(accountId);
    }

    public Mono<Void> deleteAccountById(Integer accountId) {
        // Cascades to the cards associated to the account id
        return accountRepository.deleteById(accountId);
    }

    public Mono<Account> updateAccount(Integer accountId, Account updatedAccount) {
        return accountRepository.findById(accountId)
                .flatMap(existingAccount -> {
                    // Update the fields of the existing account
                    existingAccount.setIban(updatedAccount.getIban());
                    existingAccount.setBicSwift(updatedAccount.getBicSwift());
                    existingAccount.setAccountId(updatedAccount.getAccountId());

                    return accountRepository.save(existingAccount);
                });
    }

    public Flux<Account> getAllAccounts() {
        //Implement pagination
        return accountRepository.findAll();
    }
}
