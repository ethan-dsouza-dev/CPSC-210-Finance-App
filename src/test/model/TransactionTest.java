package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionTest {

    private Transaction t1;
    private LocalDate d1;

    @BeforeEach
    void setup() {
        d1 = LocalDate.parse("2023-05-25");
        t1 = new Transaction(0, d1, "Gym Membership", 40, "Subscription");

    }

    @Test
    void TransactionTest() {
        assertEquals(0, t1.getIndex());
        assertEquals(d1, t1.getDate());
        assertEquals("Gym Membership", t1.getDetails());
        assertEquals(40, t1.getAmount());
        assertEquals("Subscription", t1.getCategory());
    }

}
