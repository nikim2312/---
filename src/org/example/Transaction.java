package org.example;

/**
 * Класс для представления транзакции.
 * Может быть как доходом, так и расходом.
 */
public class Transaction {
    private String category;
    private double amount;

    public Transaction(String category, double amount) {
        this.category = category;
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }
}
