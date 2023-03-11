package persistence;

import model.TransactionSummary;
import model.Transaction;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            TransactionSummary ts = new TransactionSummary();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("Expected an IOException to be thrown");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmpty() {
        try {
            TransactionSummary ts = new TransactionSummary();
            JsonWriter writer = new JsonWriter("./data/testWriterEmpty.json");
            writer.open();
            writer.write(ts);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmpty.json");
            ts = reader.read();
            assertEquals(ts, new TransactionSummary());
            assertEquals(0, ts.getNumberTransactions());
        } catch (IOException e) {
            fail("Unexpected IOException was thrown");
        }
    }

    @Test
    void testWriterGeneral() {
        try {
            TransactionSummary ts = new TransactionSummary();
            Transaction t1 = new Transaction(LocalDate.parse("2023-03-07"), "Health and Dental", 277,
                    "Health");
            Transaction t2 = new Transaction(LocalDate.parse("2023-03-07"), "Mouse", 50,
                    "Tech");

            ts.addTransaction(t1);
            ts.addTransaction(t2);

            JsonWriter writer = new JsonWriter("./data/testWriterNormal.json");
            writer.open();
            writer.write(ts);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterNormal.json");
            ts = reader.read();

            List<Transaction> transactions = ts.getTransactionSummary();
            assertEquals(2, transactions.size());
            assertEquals(t1, transactions.get(0));
            assertEquals(t2, transactions.get(1));

        } catch (IOException e) {
            fail("Unexpected IOException was thrown");
        }
    }
}