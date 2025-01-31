package com.mohamed.bankkata;



import com.mohamed.bankkata.repository.TransactionRepository;
import com.mohamed.bankkata.model.Transaction;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class TransactionRepositoryTest {
    @Test
    void shouldStoreTransaction() {
        TransactionRepository repository = new TransactionRepository();

        repository.addTransaction(1000);

        List<Transaction> transactions = repository.getAllTransactions();
        assertEquals(1, transactions.size());
        assertEquals(1000, transactions.get(0).getAmount());

        System.out.flush();
    }
}
