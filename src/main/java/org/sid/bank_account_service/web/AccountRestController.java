package org.sid.bank_account_service.web;

import org.sid.bank_account_service.entities.BankAccount;
import org.sid.bank_account_service.repositories.BankAccountRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountRestController {

    private final BankAccountRepository bankAccountRepository;

    public AccountRestController(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    // ------------------ GET all accounts ------------------
    @GetMapping("/bankAccount")
    public List<BankAccount> getAllAccounts() {
        return bankAccountRepository.findAll();
    }

    // ------------------ GET one account ------------------
    @GetMapping("/bankAccount/{id}")
    public BankAccount getAccountById(@PathVariable String id) {
        return bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        String.format("Bank account with id %s not found", id)
                ));
    }

    // ------------------ CREATE (POST) ------------------
    @PostMapping("/bankAccount")
    public ResponseEntity<BankAccount> createAccount(@RequestBody BankAccount bankAccount) {
        if (bankAccount.getCreatedAt() == null) {
            bankAccount.setCreatedAt(new Date());
        }
        BankAccount saved = bankAccountRepository.save(bankAccount);

        // Construire l'URI de la ressource créée : /api/bankAccount/{id}
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();

        return ResponseEntity.created(location).body(saved);
    }

    // ------------------ UPDATE (PUT) ------------------
    @PutMapping("/bankAccount/{id}")
    public BankAccount update(@PathVariable String id, @RequestBody BankAccount bankAccount) {
        BankAccount account = bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        String.format("Bank account with id %s not found", id)
                ));

        if (bankAccount.getBalance() != null)
            account.setBalance(bankAccount.getBalance());

        if (bankAccount.getType() != null)
            account.setType(bankAccount.getType());

        if (bankAccount.getCurrency() != null)
            account.setCurrency(bankAccount.getCurrency());

        return bankAccountRepository.save(account);
    }

    // ------------------ DELETE ------------------
    @DeleteMapping("/bankAccount/{id}")
    public void delete(@PathVariable String id) {
        bankAccountRepository.deleteById(id);
    }
}
