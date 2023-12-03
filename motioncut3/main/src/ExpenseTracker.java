import java.util.ArrayList;
import java.util.Scanner;

class Expense {
    String description;
    double amount;

    public Expense(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }
}

public class ExpenseTracker {
    private ArrayList<Expense> expenses;

    public ExpenseTracker() {
        expenses = new ArrayList<>();
    }

    public void addExpense(String description, double amount) {
        Expense newExpense = new Expense(description, amount);
        expenses.add(newExpense);
        System.out.println("Expense added successfully!");
    }

    public void viewAllExpenses() {
        System.out.println("All Expenses:");
        for (Expense expense : expenses) {
            System.out.println("Description: " + expense.description + ", Amount: " + expense.amount);
        }
    }

    public double getTotalExpenditure() {
        double total = 0;
        for (Expense expense : expenses) {
            total += expense.amount;
        }
        return total;
    }

    public static void main(String[] args) {
        ExpenseTracker tracker = new ExpenseTracker();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\nExpense Tracker Menu:");
                System.out.println("1. Add Expense");
                System.out.println("2. View All Expenses");
                System.out.println("3. Get Total Expenditure");
                System.out.println("4. Exit");

                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter expense description: ");
                        String description = scanner.next();
                        System.out.print("Enter expense amount: ");
                        double amount = scanner.nextDouble();
                        tracker.addExpense(description, amount);
                        break;
                    case 2:
                        tracker.viewAllExpenses();
                        break;
                    case 3:
                        System.out.println("Total Expenditure: " + tracker.getTotalExpenditure());
                        break;
                    case 4:
                        System.out.println("Exiting Expense Tracker. Goodbye!");
                        System.exit(0);
                        scanner.close();
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid option.");
                e.printStackTrace(); 
                scanner.nextLine();
                 // Clear the buffer
            }
        }
    }
}
