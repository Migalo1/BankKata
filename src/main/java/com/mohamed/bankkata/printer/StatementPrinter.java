package com.mohamed.bankkata.printer;

import com.mohamed.bankkata.model.Transaction;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class StatementPrinter {
    private static final String HEADER = "Date       | Amount  | Balance";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public void print(List<Transaction> transactions) {
        System.out.println(HEADER);
        int balance = 0;


        for (Transaction transaction : transactions) {
            balance += transaction.getAmount();
            String date = transaction.getDate().format(DATE_FORMATTER);
            String amount = String.format("%-7d", transaction.getAmount());
            String balanceStr = String.format("%-7d", balance);

            System.out.println(date + " | " + amount + " | " + balanceStr);
        }
    }
    public static void main(String[] args) {
        StatementPrinter printer = new StatementPrinter();
        List<Transaction> transactions = Arrays.asList(
                new Transaction(1000, LocalDate.of(2012, 1, 10)),
                new Transaction(2000, LocalDate.of(2012, 1, 13)),
                new Transaction(-500, LocalDate.of(2012, 1, 14))
        );
        printer.print(transactions);
    }

}