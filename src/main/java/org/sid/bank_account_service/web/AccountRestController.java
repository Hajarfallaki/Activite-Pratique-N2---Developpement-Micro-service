package org.sid.bank_account_service.web;


import org.sid.bank_account_service.entities.BankAccount;
import org.sid.bank_account_service.repositories.BankAccountRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // << important pour exposer le REST
@RequestMapping("/api") // optionnel, pour préfixer tes routes
public class AccountRestController {

    private final BankAccountRepository bankAccountRepository;

    public AccountRestController(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @GetMapping("/bankAccount")
    public List<BankAccount> getAllAccounts() {
        return bankAccountRepository.findAll();
    }

    @GetMapping("/bankAccount/{id}")
    public BankAccount getAccountById(@PathVariable String id) {
        return bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        String.format("Bank account with id %s not found", id)
                ));
    }
}
