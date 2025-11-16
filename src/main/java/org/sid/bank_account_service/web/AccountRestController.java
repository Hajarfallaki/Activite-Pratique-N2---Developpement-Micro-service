package org.sid.bank_account_service.web;

import org.sid.bank_account_service.Mappers.AccountMapper;
import org.sid.bank_account_service.dto.BankAccountDTO;
import org.sid.bank_account_service.dto.BankAccountResponseDTO;
import org.sid.bank_account_service.entities.BankAccount;
import org.sid.bank_account_service.repositories.BankAccountRepository;
import org.sid.bank_account_service.service.AccountService;
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
    private final AccountService accountService;
    private  AccountMapper accountMapper;

    public AccountRestController(BankAccountRepository bankAccountRepository,
                                 AccountService accountService) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountService = accountService;
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

    // ------------------ CREATE (POST) - Utilise DTO ------------------
    @PostMapping("/bankAccount")
    public ResponseEntity<BankAccountResponseDTO> createAccount(@RequestBody BankAccountDTO bankAccountDTO) {
        // Appel au service qui gère la logique métier
        BankAccountResponseDTO savedAccount = accountService.addAccount(bankAccountDTO);

        // Construire l'URI de la ressource créée : /api/bankAccount/{id}
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedAccount.getId())
                .toUri();

        return ResponseEntity.created(location).body(savedAccount);
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