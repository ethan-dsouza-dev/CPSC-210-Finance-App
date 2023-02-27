package model;

import java.time.LocalDate;

public class Transaction {
    private LocalDate date;
    private String details;
    private double amount;
    private String category;


    /**
     * @REQUIRES: date to be in the format "yyyy-mm-dd"
     * @EFFECTS: creates a new Transaction object with fields set to given values.
     */
    public Transaction(LocalDate date, String detail, double amount, String category) {
        this.date = date;
        this.details = detail;
        this.amount = amount;
        this.category = category;
    }

    public LocalDate getDate() {
        return this.date;
    }


    public String getDetails() {
        return this.details;
    }


    public double getAmount() {
        return this.amount;
    }


    public String getCategory() {
        return this.category;
    }

}
