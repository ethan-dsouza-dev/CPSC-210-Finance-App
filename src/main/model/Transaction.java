package model;

import java.util.Date;

public class Transaction {
    private String date;
    private String details;
    private double amount;
    private String category;


    /**
     * @EFFECTS: creates a new Transaction object with fields set to given values.
     */
    public Transaction(String date, String detail, double amount, String category) {
        this.date = date;
        this.details = detail;
        this.amount = amount;
        this.category = category;
    }

    public String getDate() {
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
