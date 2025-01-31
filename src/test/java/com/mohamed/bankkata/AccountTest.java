package com.mohamed.bankkata;

import com.mohamed.bankkata.repository.TransactionRepository;
import com.mohamed.bankkata.printer.StatementPrinter;
import com.mohamed.bankkata.service.Account;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class AccountTest {
    @Test
    void shouldStoreDepositTransaction() {
        TransactionRepository transactionRepository = mock(TransactionRepository.class);
        StatementPrinter statementPrinter = mock(StatementPrinter.class);
        Account account = new Account(transactionRepository, statementPrinter);

        account.deposit(1000);

        verify(transactionRepository).addTransaction(1000);
    }

    @Test
    void shouldStoreWithdrawalTransaction() {
        TransactionRepository transactionRepository = mock(TransactionRepository.class);
        StatementPrinter statementPrinter = mock(StatementPrinter.class);
        Account account = new Account(transactionRepository, statementPrinter);

        account.withdraw(500);

        verify(transactionRepository).addTransaction(-500);

        System.out.flush();
    }
}
