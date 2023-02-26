package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionTest {

    private Transaction t1;

    @BeforeEach
    void setup() {
        t1 = new Transaction("2023-05-25", "Gym Membership", 40, "Subscription");
    }

    @Test
    void TransactionTest() {
        assertEquals("2023-05-25", t1.getDate());
        assertEquals("Gym Membership", t1.getDetails());
        assertEquals(40, t1.getAmount());
        assertEquals("Subscription", t1.getCategory());
    }

}
