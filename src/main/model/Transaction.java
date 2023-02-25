package model;

import java.util.Date;

public class Transaction {
    private String date;
    private String details;
    private double amount;
    private String category;


    // MODIFIES: this
    // EFFECTS: creates a new Transaction object with fields set to given values.
    public Transaction(String date, String detail, double amount, String category) {
        this.date = date;
        this.details = detail;
        this.amount = amount;
        this.category = category;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDetails() {
        return this.details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
