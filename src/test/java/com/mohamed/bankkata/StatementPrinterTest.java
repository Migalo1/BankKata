package com.mohamed.bankkata;

import com.mohamed.bankkata.printer.StatementPrinter;
import com.mohamed.bankkata.model.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class StatementPrinterTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private StatementPrinter statementPrinter;

    @BeforeEach
    void setUp() {
        statementPrinter = new StatementPrinter();
        System.setOut(new PrintStream(outContent, true));
    }

    @Test
    void shouldPrintStatementCorrectly() {
        // Given (Transactions)
        List<Transaction> transactions = Arrays.asList(
                new Transaction(1000, LocalDate.of(2012, 1, 10)),
                new Transaction(2000, LocalDate.of(2012, 1, 13)),
                new Transaction(-500, LocalDate.of(2012, 1, 14))
        );


        statementPrinter.print(transactions);


        String output = outContent.toString().trim();
        System.out.println("=== Sortie réelle ===");
        System.out.println(output);
        System.out.println("=====================");


        String normalizedOutput = output.replaceAll("\\s+", " ");
        System.out.println("=== Sortie normalisée ===");
        System.out.println(normalizedOutput);
        System.out.println("=========================");

        assertTrue(normalizedOutput.contains("Date | Amount | Balance"));


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        String date1 = LocalDate.of(2012, 1, 10).format(formatter);
        String date2 = LocalDate.of(2012, 1, 13).format(formatter);
        String date3 = LocalDate.of(2012, 1, 14).format(formatter);

        assertTrue(normalizedOutput.contains((date1 + " | 1000 | 1000").replaceAll("\\s+", " ")));
        assertTrue(normalizedOutput.contains((date2 + " | 2000 | 3000").replaceAll("\\s+", " ")));
        assertTrue(normalizedOutput.contains((date3 + " | -500 | 2500").replaceAll("\\s+", " ")));

        System.out.flush();
    }
}