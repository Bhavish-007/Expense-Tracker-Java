import java.util.ArrayList;

// This class manages all Expense objects
public class ExpenseManager {

    // List that stores all expenses while program is running
    private ArrayList<Expense> expenses = new ArrayList<>();

    // Add a new expense to the list
    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    // Return all expenses (used for displaying)
    public ArrayList<Expense> getAllExpenses() {
        return expenses;
    }

    // Delete expense by ID
    // Returns true if deleted, false if not found
    public boolean deleteExpense(int id) {
        for (int i = 0; i < expenses.size(); i++) {
            if (expenses.get(i).getId() == id) {
                expenses.remove(i);
                return true;
            }
        }
        return false;
    }
}
