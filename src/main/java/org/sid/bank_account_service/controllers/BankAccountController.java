package org.sid.bank_account_service.controllers;

import org.sid.bank_account_service.entities.BankAccount;
import org.sid.bank_account_service.repositories.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BankAccountController {

    private final BankAccountRepository bankAccountRepository;

    public BankAccountController(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    // Retourne tous les comptes bancaires
    @GetMapping("/bankAccount")
    public List<BankAccount> getBankAccounts() {
        return bankAccountRepository.findAll();
    }
}
