package persistence;

import model.Transaction;
import model.TransactionSummary;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/doesNotExist.json");
        try {
            TransactionSummary ts = reader.read();
            fail("Expected IOException to be thrown");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmpty() {
        JsonReader reader = new JsonReader("./data/testReaderEmpty.json");
        try {
            TransactionSummary ts = reader.read();
            assertEquals(0, ts.getNumberTransactions());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderNormal() {
        JsonReader reader = new JsonReader("./data/testReaderNormal.json");
        try {
            TransactionSummary ts = reader.read();
            List<Transaction> transactions = ts.getTransactionSummary();

            Transaction t1 = transactions.get(0);
            Transaction t2 = transactions.get(1);

            assertEquals(2, ts.getNumberTransactions());
            checkTransaction(LocalDate.parse("2023-03-08"), "Golf" , 123, "leisure", t1);
            checkTransaction(LocalDate.parse("2023-02-15"), "Milk" , 100, "Essentials", t2);
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}