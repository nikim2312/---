package org.example;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс для представления кошелька пользователя.
 * Хранит информацию о доходах, расходах и бюджетах.
 */
public class Wallet {
    private double totalIncome;
    private double totalExpenses;
    private Map<String, Double> categoryBudgets;
    private Map<String, Double> incomeByCategory;
    private Map<String, Double> expensesByCategory;

    public Wallet() {
        this.totalIncome = 0;
        this.totalExpenses = 0;
        this.categoryBudgets = new HashMap<>();
        this.incomeByCategory = new HashMap<>();
        this.expensesByCategory = new HashMap<>();
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public void addIncome(double amount, String category) {
        totalIncome += amount;
        incomeByCategory.put(category, incomeByCategory.getOrDefault(category, 0.0) + amount);
    }

    public double getTotalExpenses() {
        return totalExpenses;
    }

    public void addExpense(double amount, String category) {
        totalExpenses += amount;
        expensesByCategory.put(category, expensesByCategory.getOrDefault(category, 0.0) + amount);
    }

    public void setCategoryBudget(String category, double budget) {
        categoryBudgets.put(category, budget);
    }

    public double getRemainingBudget(String category) {
        return categoryBudgets.getOrDefault(category, 0.0) - expensesByCategory.getOrDefault(category, 0.0);
    }

    public Map<String, Double> getCategoryBudgets() {
        return categoryBudgets;
    }

    public Map<String, Double> getIncomeByCategory() {
        return incomeByCategory;
    }

    public Map<String, Double> getExpensesByCategory() {
        return expensesByCategory;
    }
}
