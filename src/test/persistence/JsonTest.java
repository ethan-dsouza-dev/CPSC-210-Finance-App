package persistence;

import model.Transaction;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkTransaction(LocalDate date, String details, double amount, String category, Transaction t) {
        assertEquals(date, t.getDate());
        assertEquals(details, t.getDetails());
        assertEquals(amount, t.getAmount());
        assertEquals(category, t.getCategory());
    }
}
