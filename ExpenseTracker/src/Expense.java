// This class represents ONE expense (like Lunch, Uber, Books, etc.)
public class Expense {

    // Unique ID for each expense (1,2,3...)
    private int id;

    // Title of expense (example: Lunch, Uber)
    private String title;

    // Amount spent (example: 120.50)
    private double amount;

    // Category (Food, Travel, Study...)
    private String category;

    // Date of expense (example: 2026-02-08)
    private String date;

    // Constructor: runs when we create a new Expense object
    // This sets all values at once
    public Expense(int id, String title, double amount, String category, String date) {
        this.id = id;               // assign id
        this.title = title;         // assign title
        this.amount = amount;       // assign amount
        this.category = category;   // assign category
        this.date = date;           // assign date
    }

    // Getter methods (used to READ private variables)

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public String getDate() {
        return date;
    }

    // Converts Expense object into CSV format
    // Example output:
    // 1,Lunch,120,Food,2026-02-08
    public String toCSV() {
        return id + "," + title + "," + amount + "," + category + "," + date;
    }

    // Controls how expense prints in console
    // Example:
    // 1 | Lunch | 120 | Food | 2026-02-08
    @Override
    public String toString() {
        return id + " | " + title + " | " + amount + " | " + category + " | " + date;
    }
}
