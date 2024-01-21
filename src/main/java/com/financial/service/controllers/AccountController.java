package com.financial.service.controllers;
import com.financial.service.entities.Account;
import com.financial.service.services.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public Mono<Account> createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @GetMapping("/{accountId}")
    public Mono<Account> getAccountById(@PathVariable Integer accountId) {
        return accountService.getAccountById(accountId);
    }

    @DeleteMapping("/{accountId}")
    public Mono<Void> deleteAccount(@PathVariable Integer accountId) {
        return accountService.deleteAccountById(accountId);
    }
}

