package org.example;

import java.util.Scanner;

/**
 * Точка входа в программу, интерфейс для взаимодействия с пользователем.
 */
public class Main {
    private static FinanceApp app = new FinanceApp();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Регистрация");
            System.out.println("2. Войти");
            System.out.println("3. Выход");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    register();
                    break;
                case "2":
                    login();
                    break;
                case "3":
                    System.out.println("Выход из программы...");
                    app.saveData();
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    private static void register() {
        System.out.println("Введите имя пользователя:");
        String username = scanner.nextLine();
        System.out.println("Введите пароль:");
        String password = scanner.nextLine();
        app.registerUser(username, password);
    }

    private static void login() {
        System.out.println("Введите имя пользователя:");
        String username = scanner.nextLine();
        System.out.println("Введите пароль:");
        String password = scanner.nextLine();
        if (app.loginUser(username, password)) {
            userMenu();
        }
    }

    private static void userMenu() {
        while (true) {
            System.out.println("1. Добавить доход");
            System.out.println("2. Добавить расход");
            System.out.println("3. Установить бюджет");
            System.out.println("4. Показать информацию");
            System.out.println("5. Выйти");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addIncome();
                    break;
                case "2":
                    addExpense();
                    break;
                case "3":
                    setBudget();
                    break;
                case "4":
                    app.printSummary();
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    private static void addIncome() {
        System.out.println("Введите сумму дохода:");
        double amount = Double.parseDouble(scanner.nextLine());
        System.out.println("Введите категорию дохода:");
        String category = scanner.nextLine();
        app.addIncome(amount, category);
    }

    private static void addExpense() {
        System.out.println("Введите сумму расхода:");
        double amount = Double.parseDouble(scanner.nextLine());
        System.out.println("Введите категорию расхода:");
        String category = scanner.nextLine();
        app.addExpense(amount, category);
    }

    private static void setBudget() {
        System.out.println("Введите категорию:");
        String category = scanner.nextLine();
        System.out.println("Введите бюджет:");
        double budget = Double.parseDouble(scanner.nextLine());
        app.setCategoryBudget(category, budget);
    }
}
