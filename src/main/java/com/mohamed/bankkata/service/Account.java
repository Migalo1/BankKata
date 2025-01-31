package com.mohamed.bankkata.service;


import com.mohamed.bankkata.model.Transaction;
import com.mohamed.bankkata.repository.TransactionRepository;
import com.mohamed.bankkata.printer.StatementPrinter;

import java.util.List;

public class Account {
    private final TransactionRepository transactionRepository;
    private final StatementPrinter statementPrinter;

    public Account(TransactionRepository transactionRepository, StatementPrinter statementPrinter) {
        this.transactionRepository = transactionRepository;
        this.statementPrinter = statementPrinter;
    }

    public void deposit(int amount) {
        transactionRepository.addTransaction(amount);
    }

    public void withdraw(int amount) {
        transactionRepository.addTransaction(-amount);
    }

    public void printStatement() {
        List<Transaction> transactions = transactionRepository.getAllTransactions();
        statementPrinter.print(transactions);
    }
}
