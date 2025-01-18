package org.example;

import java.util.HashMap;
import java.util.Map;

/**
 * Основной класс приложения для управления личными финансами.
 * Управляет пользователями, кошельками и операциями с доходами/расходами.
 */
public class FinanceApp {
    private Map<String, User> users;
    private User currentUser;

    public FinanceApp() {
        this.users = new HashMap<>();
        this.currentUser = null;
    }

    public void registerUser(String username, String password) {
        if (!users.containsKey(username)) {
            users.put(username, new User(username, password));
            System.out.println("Пользователь зарегистрирован!");
        } else {
            System.out.println("Пользователь с таким именем уже существует.");
        }
    }

    public boolean loginUser(String username, String password) {
        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            currentUser = user;
            System.out.println("Авторизация успешна!");
            return true;
        } else {
            System.out.println("Неверное имя пользователя или пароль.");
            return false;
        }
    }

    public void addIncome(double amount, String category) {
        if (currentUser != null) {
            currentUser.getWallet().addIncome(amount, category);
            System.out.println("Доход добавлен.");
        } else {
            System.out.println("Пожалуйста, авторизуйтесь.");
        }
    }

    public void addExpense(double amount, String category) {
        if (currentUser != null) {
            currentUser.getWallet().addExpense(amount, category);
            System.out.println("Расход добавлен.");
        } else {
            System.out.println("Пожалуйста, авторизуйтесь.");
        }
    }

    public void setCategoryBudget(String category, double budget) {
        if (currentUser != null) {
            currentUser.getWallet().setCategoryBudget(category, budget);
            System.out.println("Бюджет для категории установлен.");
        } else {
            System.out.println("Пожалуйста, авторизуйтесь.");
        }
    }

    public void printSummary() {
        if (currentUser != null) {
            Wallet wallet = currentUser.getWallet();
            System.out.println("Общий доход: " + wallet.getTotalIncome());
            System.out.println("Общие расходы: " + wallet.getTotalExpenses());

            System.out.println("Доходы по категориям:");
            for (Map.Entry<String, Double> entry : wallet.getIncomeByCategory().entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

            System.out.println("Расходы по категориям:");
            for (Map.Entry<String, Double> entry : wallet.getExpensesByCategory().entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

            System.out.println("Бюджет по категориям:");
            for (Map.Entry<String, Double> entry : wallet.getCategoryBudgets().entrySet()) {
                double remainingBudget = wallet.getRemainingBudget(entry.getKey());
                System.out.println(entry.getKey() + ": " + entry.getValue() + ", Оставшийся бюджет: " + remainingBudget);
            }
        } else {
            System.out.println("Пожалуйста, авторизуйтесь.");
        }
    }

    public void saveData() {
        // Логика сохранения данных (например, в файл).
    }

    public void loadData() {
        // Логика загрузки данных из файла.
    }
}
