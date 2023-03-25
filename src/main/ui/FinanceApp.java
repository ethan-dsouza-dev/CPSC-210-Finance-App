package ui;

import model.Transaction;
import model.TransactionSummary;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

// Finance Tracker Application
public class FinanceApp {

    private Scanner scanner;
    private TransactionSummary transactionSummary;

    private static final String JSON_STORE = "./data/summary.json";
    private TransactionSummary summary;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    /**
     * @EFFECTS: creates a new instance of a FinanceApp
     */
    public FinanceApp() {
        transactionSummary = new TransactionSummary();
        scanner = new Scanner(System.in);
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        //runMenu();
        GUI runGui = new GUI();
    }

    /**
     * @MODIFIES: this
     * @EFFECTS: processes choice selected by user
     */
    private void runMenu() {
        boolean quit = false;
        String choice;

        while (!quit) {
            displayMenu();
            choice = scanner.nextLine();
            choice = choice.toUpperCase();

            if (choice.equals("Q")) {
                quit = true;
            } else {
                doChoice(choice);
            }
        }

        System.out.println("\nClosing Transaction Summary");
    }

    /**
     * @EFFECTS: displays the menu
     */
    public void displayMenu() {
        System.out.println("--------------------------");
        System.out.println("Choose an option:\n");
        System.out.println("\tA - Add a Transaction");
        System.out.println("\tB - View Transaction Summary");
        System.out.println("\tC - Remove Transaction");
        System.out.println("\tD - Find largest expense");
        System.out.println("\tE - Save Transaction Summary");
        System.out.println("\tF - Load Transaction Summary");

        System.out.println("\tQ - Quit");

        System.out.println("--------------------------");

    }

    /**
     * @MODIFIES: this
     * @EFFECTS: processes user input, performs the task selected by user
     */
    public void doChoice(String choice) {
        if (choice.equals("A")) {
            addTransaction();
        } else if (choice.equals("B")) {
            displayTransactionSummary();
            pauseMenu();
        } else if (choice.equals("C")) {
            removeTransaction();
            pauseMenu();
        } else if (choice.equals("D")) {
            displayGreatestExpense();
            pauseMenu();
        } else if (choice.equals("E")) {
            saveTransactionSummary();
            pauseMenu();
        } else if (choice.equals("F")) {
            loadTransactionSummary();
            pauseMenu();
        } else {
            System.out.println("Selection not valid...");
            pauseMenu();
        }
    }

    /**
     * @EFFECTS: waits for user-input
     */
    private void pauseMenu() {
        System.out.println("Press any key to go to menu.");
        scanner.nextLine();
    }


    /**
     * @MODIFIES: this
     * @EFFECTS: adds a transaction to the transaction summary
     */
    public void addTransaction() {
        ArrayList<Transaction> summary = transactionSummary.getTransactionSummary();

        try {
            transactionSummary.addTransaction(collectTransactionData());
            System.out.println("Added Transaction");
        } catch (DateTimeParseException e) {
            System.out.println("Invalid Date");
        }

    }

    /**
     * @EFFECTS: collects data from the user about the transaction and creates a
     * new Transaction object with those details.
     */
    public Transaction collectTransactionData() {
        System.out.println("Enter Date ");

        System.out.println("Enter the year: ");
        String year = scanner.nextLine();

        System.out.println("Enter the month:");
        String month = scanner.nextLine();

        System.out.println("Enter the day: ");
        String day = scanner.nextLine();

        String transactionDate = year + '-' + month + '-' + day;
        LocalDate date = LocalDate.parse(transactionDate);

        System.out.println("\nEnter Details: ");
        String transactionDetail = scanner.nextLine();

        System.out.println("\nEnter Amount: ");
        double transactionAmount = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("\nEnter Category: ");
        String transactionCategory = scanner.nextLine();

        Transaction newTransaction = new Transaction(date, transactionDetail, transactionAmount,
                transactionCategory);
        return newTransaction;
    }

    /**
     * @EFFECTS: displays all trasactions in the transaction summary
     */
    public void displayTransactionSummary() {
        System.out.println("----------------------------------\n");
        System.out.println("Index, Date, Details, Amount, Category\n");

        ArrayList<Transaction> summary = transactionSummary.getTransactionSummary();

        for (int i = 0; i < summary.size(); i++) {
            Transaction transaction = summary.get(i);
            displayTransaction(transaction, i);
        }

        System.out.println("----------------------------------\n");

    }

    /**
     * @EFFECTS: displays parameters of a Transaction object to the console.
     */
    private void displayTransaction(Transaction transaction, int index) {
        System.out.print(index + "\t");
        System.out.print(transaction.getDate() + "\t");
        System.out.print(transaction.getDetails() + "\t");
        System.out.print(transaction.getAmount() + "\t");
        System.out.print(transaction.getCategory() + "\n");
    }

    /**
     * @REQUIRES: index must not be out of range.
     * @MODIFIES: this
     * @EFFECTS: asks the user which for the index at which the transaction should be deleted.
     */
    public void removeTransaction() {
        displayTransactionSummary();
        System.out.println("Enter the Index of the transaction to be removed: ");
        int index = scanner.nextInt();
        transactionSummary.removeTransaction(index);
        System.out.println("Removed Transaction");
        System.out.println("Here is your new transaction summary:");
        displayTransactionSummary();
    }

    /**
     * @EFFECTS: prints to the console the expense with the highest amount in transactionSummary.
     */
    public void displayGreatestExpense() {
        Transaction highestExpense = null;
        System.out.println("Your greatest expense is shown below: ");
        highestExpense = transactionSummary.findGreatestTransactionForMonth(LocalDate.now());
        System.out.println("Index, Date, Details, Amount, Category\n");
        displayTransaction(highestExpense, 0);
    }

    /**
     * @MODIFIES: this
     * @EFFECTS: saves transactionSummary to json file.
     */
    public void saveTransactionSummary() {
        try {
            jsonWriter.open();
            jsonWriter.write(transactionSummary);
            jsonWriter.close();
            System.out.println("Saved to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads transactionSummary from file
    public void loadTransactionSummary() {
        try {
            transactionSummary = jsonReader.read();
            System.out.println("Loaded transaction summary" + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }


}
