import java.util.*;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ExpenseManager manager = new ExpenseManager();

        // Load saved expenses when program starts
        manager.getAllExpenses().addAll(FileHandler.loadExpenses());

        int choice =-1;

        do {
            System.out.println("\n===== EXPENSE TRACKER =====");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Delete Expense");
            System.out.println("4. Analytics");
            System.out.println("5. Search Expense");
            System.out.println("6. Sort Expenses");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
            System.out.println("Please enter a valid number.");
            continue;
            }

            switch (choice) {

                case 1:
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter amount: ");
                    double amount;

                    try {
                        amount = Double.parseDouble(sc.nextLine());
                    } catch (Exception e) {
                        System.out.println("Invalid amount.");
                        continue;
                    }


                    System.out.print("Enter category: ");
                    String category = sc.nextLine();

                    String date = LocalDate.now().toString();

                    int id = manager.getAllExpenses().size() + 1;

                    Expense expense = new Expense(id, title, amount, category, date);
                    manager.addExpense(expense);

                    FileHandler.saveExpenses(manager.getAllExpenses());

                    System.out.println("Expense added.");
                    break;

                case 2:
                    System.out.println("\nID | Title | Amount | Category | Date");

                    for (Expense e : manager.getAllExpenses()) {
                        System.out.println(e);
                    }
                    break;

                case 3:
                    System.out.print("Enter ID to delete: ");
                    int deleteId = sc.nextInt();

                    if (manager.deleteExpense(deleteId)) {
                        FileHandler.saveExpenses(manager.getAllExpenses());
                        System.out.println("Expense deleted.");
                    } else {
                        System.out.println("Expense not found.");
                    }
                    break;
                
                case 4:
                    System.out.println("Total spent: " + Analytics.getTotal(manager.getAllExpenses()));
                    Analytics.categoryTotals(manager.getAllExpenses());
                    break;
                
                case 5:
                    System.out.print("Enter keyword (title or category): ");
                    String keyword = sc.nextLine().toLowerCase();

                    boolean found = false;

                    System.out.println("\nSearch Results:");

                    for (Expense e : manager.getAllExpenses()) {
                        if (e.getTitle().toLowerCase().contains(keyword) ||
                            e.getCategory().toLowerCase().contains(keyword)) {

                            System.out.println(e);
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("No matching expenses found.");
                    }

                    break;
                
                case 6:
                    System.out.println("1. Sort by Amount");
                    System.out.println("2. Sort by Date");
                    System.out.print("Choose option: ");

                    int sortChoice;

                    try {
                        sortChoice = Integer.parseInt(sc.nextLine());
                    } catch (Exception e) {
                        System.out.println("Invalid choice.");
                        break;
                    }

                    if (sortChoice == 1) {
                        manager.getAllExpenses().sort((a, b) -> Double.compare(a.getAmount(), b.getAmount()));
                        System.out.println("Sorted by Amount.");
                    } 
                    else if (sortChoice == 2) {
                        manager.getAllExpenses().sort((a, b) -> a.getDate().compareTo(b.getDate()));
                        System.out.println("Sorted by Date.");
                    } 
                    else {
                        System.out.println("Invalid option.");
                        break;
                    }

                    for (Expense e : manager.getAllExpenses()) {
                        System.out.println(e);
                    }

                    break;

                    
                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        sc.close();
    }
}
