package main.java;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ChainblockImplTest {
    private Chainblock chainblock;
    private List<Transaction> transactions;

    @Before
    public void prepare() {
        this.chainblock = new ChainblockImpl();
        this.transactions = new ArrayList<>();
    }

    @Test
    public void testContainsTrue() {
        Transaction transaction = new TransactionImpl(0, TransactionStatus.SUCCESSFUL, "Gosho", "Pesho", 20.00);
    }
}