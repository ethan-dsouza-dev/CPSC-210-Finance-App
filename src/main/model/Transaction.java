package model;

import java.time.LocalDate;
import java.util.Date;

public class Transaction {
    private int index;
    private LocalDate date;
    private String details;
    private double amount;
    private String category;


    /**
     * @EFFECTS: creates a new Transaction object with fields set to given values.
     */
    public Transaction(int index, LocalDate date, String detail, double amount, String category) {
        this.index = index;
        this.date = date;
        this.details = detail;
        this.amount = amount;
        this.category = category;
    }

    public int getIndex() {
        return this.index;
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
