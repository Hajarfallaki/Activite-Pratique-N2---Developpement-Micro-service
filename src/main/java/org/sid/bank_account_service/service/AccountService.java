package org.sid.bank_account_service.service;

import org.sid.bank_account_service.dto.BankAccountDTO;
import org.sid.bank_account_service.dto.BankAccountResponseDTO;

public interface AccountService {

    BankAccountResponseDTO addAccount(BankAccountDTO bankAccountDTO);

}
