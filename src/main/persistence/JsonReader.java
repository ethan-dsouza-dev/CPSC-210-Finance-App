package persistence;

import model.TransactionSummary;
import model.Transaction;


import org.json.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.stream.Stream;

// Adapted from JSONSerializationDemo  application found on Edx

// Represents a reader that reads workroom from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads transactionSummary from file and returns it;
    // throws IOException if an error occurs reading data from file
    public TransactionSummary read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseTransactionSummary(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines( Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses TransactionSummary from JSON object and returns it
    private TransactionSummary parseTransactionSummary(JSONObject jsonObject) {
        TransactionSummary ts = new TransactionSummary();
        addTransactions(ts, jsonObject);
        return ts;
    }

    // MODIFIES: ts
    // EFFECTS: parses Transactions from JSON object and adds them to transactionSummary
    private void addTransactions(TransactionSummary ts, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("transactions");
        for (Object json : jsonArray) {
            JSONObject nextTransaction = (JSONObject) json;
            addTransaction(ts, nextTransaction);
        }
    }

    // MODIFIES: ts
    // EFFECTS: parses Transaction from JSON object and adds it to transactionSummary
    private void addTransaction(TransactionSummary ts, JSONObject jsonObject) {
        LocalDate date = LocalDate.parse(jsonObject.getString("date"));
        String details = jsonObject.getString("details");
        double amount = jsonObject.getDouble("amount");
        String category = jsonObject.getString("category");

        Transaction transaction = new Transaction(date, details, amount, category);
        ts.addTransaction(transaction);
    }
}
