package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TransactionSummaryTest {

    private TransactionSummary ts1;
    private Transaction t1, t2, t3;
    private LocalDate d1, d2, d3;

    @BeforeEach
    void setup() {
        ts1 = new TransactionSummary();

        d1 = LocalDate.parse("2023-05-25");
        d2 = LocalDate.parse("2023-02-27");
        d3 = LocalDate.parse("2023-07-24");

        t1 = new Transaction(d1, "Tim Horton's", 20, "Food");
        t2 = new Transaction(d2, "ROGER'S", 40, "Phone");
        t3 = new Transaction(d3, "Laundry", 100, "Essentials");
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
        Transaction t1 = new Transaction(d1, "Tim Horton's", 20, "Food");

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

    @Test
    void findGreatestTransactionForMonthNormal() {
        ts1.addTransaction(t1);
        ts1.addTransaction(t3);
        ts1.addTransaction(t2);

        LocalDate now = LocalDate.of(2023, 02, 25);

        assertEquals(t3, ts1.findGreatestTransactionForMonth(now));
    }

    @Test
    void findGreatestTransactionForMonthBoundary() {
        LocalDate d4 = LocalDate.of(2023, 01, 27);
        Transaction t4 = new Transaction(d4, "Banana", 500, "Food");

        ts1.addTransaction(t1);
        ts1.addTransaction(t3);
        ts1.addTransaction(t2);
        ts1.addTransaction(t4);

        LocalDate now = LocalDate.of(2023, 02, 25);

        assertEquals(t4, ts1.findGreatestTransactionForMonth(now));
    }

    @Test
    void findGreatestTransactionForMonthEqual() {
        LocalDate d4 = LocalDate.of(2023, 01, 26);
        Transaction t4 = new Transaction(d4, "Banana", 500, "Food");

        ts1.addTransaction(t1);
        ts1.addTransaction(t3);
        ts1.addTransaction(t2);
        ts1.addTransaction(t4);

        LocalDate now = LocalDate.of(2023, 02, 25);

        assertEquals(t4, ts1.findGreatestTransactionForMonth(now));
    }

    @Test
    void findGreatestTransactionForMonthAbnormal() {
        LocalDate d4 = LocalDate.of(2022, 01, 25);
        Transaction t4 = new Transaction(d4, "Banana", 500, "Food");

        ts1.addTransaction(t1);
        ts1.addTransaction(t3);
        ts1.addTransaction(t2);
        ts1.addTransaction(t4);

        LocalDate now = LocalDate.of(2023, 02, 25);

        assertEquals(t3, ts1.findGreatestTransactionForMonth(now));
    }

    @Test
    void removeTransactionWithDetails() {
        LocalDate d4 = LocalDate.of(2023, 01, 26);
        Transaction t4 = new Transaction(d4, "Banana", 500, "Food");

        ts1.addTransaction(t1);
        ts1.addTransaction(t2);
        ts1.addTransaction(t3);
        ts1.addTransaction(t4);
        ts1.removeTransactionWithDetails("Banana");

        assertTrue(ts1.getTransactionSummary().contains(t1));
        assertTrue(ts1.getTransactionSummary().contains(t2));
        assertTrue(ts1.getTransactionSummary().contains(t3));
        assertFalse(ts1.getTransactionSummary().contains(t4));


    }

}
