package com.financial.service.controllers;

import com.financial.service.entities.Account;
import com.financial.service.services.account.AccountService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public Flux<Account> getAllAccounts() {
        //Implement pagination
        return accountService.getAllAccounts();
    }

    @PostMapping
    public Mono<Account> createAccount(@Valid @RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @GetMapping("/{accountId}")
    public Mono<Account> getAccountById(@PathVariable Integer accountId) {
        return accountService.getAccountById(accountId);
    }

    @PutMapping("/{accountId}")
    public Mono<Account> updateAccount(@PathVariable Integer accountId, @RequestBody Account updatedAccount) {
        return accountService.updateAccount(accountId, updatedAccount);
    }

    @DeleteMapping("/{accountId}")
    public Mono<Void> deleteAccount(@PathVariable Integer accountId) {
        return accountService.deleteAccountById(accountId);
    }
}

