package com.mohamed.bankkata.repository;

import com.mohamed.bankkata.model.Transaction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TransactionRepository {
    private final List<Transaction> transactions = new ArrayList<>();

    public void addTransaction(int amount) {
        transactions.add(new Transaction(amount, LocalDate.now()));
    }

    public List<Transaction> getAllTransactions() {
        return transactions;
    }
}
