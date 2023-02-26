package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TransactionSummaryTest {

    private TransactionSummary ts1;
    private Transaction t1, t2, t3;

    @BeforeEach
    void setup() {
        ts1 = new TransactionSummary();
        t1 = new Transaction("2/25/2023", "Tim Horton's", 20, "Food");
        t2 = new Transaction("2/27/2023", "ROGER'S", 40, "Phone");
        t3 = new Transaction("2023-05-25", "Laundry", 100, "Essentials");
    }

    @Test
    void transactionSummaryTest() {
        assertTrue(ts1.getTransactionSummary().isEmpty());
    }

    @Test
    void addTransactionTest() {
        ts1.addTransaction(t1);
        ts1.addTransaction(t2);

        assertTrue(ts1.getTransactionSummary().contains(t1));
        assertTrue(ts1.getTransactionSummary().contains(t2));
        assertTrue(ts1.getTransactionAtIndex(0).equals(t1));
        assertTrue(ts1.getTransactionAtIndex(1).equals(t2));
    }

    @Test
    void removeTransactionTestOne () {
        Transaction t1 = new Transaction("2/25/2023", "Tim Horton's", 20, "Food");

        ts1.addTransaction(t1);

        ts1.removeTransaction(0);
        assertEquals(0, ts1.getTransactionSummary().size());
    }

    @Test
    void removeTransactionTestTwo () {
        ts1.addTransaction(t1);
        ts1.addTransaction(t2);

        ts1.removeTransaction(0);
        assertFalse(ts1.getTransactionSummary().contains(t1));
        assertEquals(t2, ts1.getTransactionAtIndex(0));
    }

    @Test
    void findGreatestTransactionTestFirst() {
        ts1.addTransaction(t3);
        ts1.addTransaction(t1);
        ts1.addTransaction(t2);

        assertEquals(t3, ts1.findGreatestTransaction());
    }

    @Test
    void findGreatestTransactionTestEnd() {
        ts1.addTransaction(t1);
        ts1.addTransaction(t2);

        assertEquals(t2, ts1.findGreatestTransaction());
    }

    @Test
    void findGreatestTransactionTestMiddle() {

        ts1.addTransaction(t1);
        ts1.addTransaction(t3);
        ts1.addTransaction(t2);


        assertEquals(t3, ts1.findGreatestTransaction());
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
        System.out.println("---");

        System.out.println(ts1.findGreatestTransaction());
    }

}
