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

    /**
     *
     * @MODIFIES: this
     * @EFFECTS: sets the date field to newDate.
     */
    public void setDate(String newDate) {
        this.date = newDate;
    }

    public String getDetails() {
        return this.details;
    }

    /**
     *
     * @MODIFIES: this
     * @EFFECTS: sets the details field to newDetails.
     */
    public void setDetails(String newDetails) {
        this.details = newDetails;
    }

    public double getAmount() {
        return this.amount;
    }

    /**
     *
     * @MODIFIES: this
     * @EFFECTS: sets the amount field to newAmount.
     */
    public void setAmount(double newAmount) {
        this.amount = newAmount;
    }

    public String getCategory() {
        return this.category;
    }

    /**
     *
     * @MODIFIES: this
     * @EFFECTS: sets the category field to newCategory.
     */
    public void setCategory(String newCategory) {
        this.category = newCategory;
    }
}
