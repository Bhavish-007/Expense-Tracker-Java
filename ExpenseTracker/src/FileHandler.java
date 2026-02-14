import java.io.*;
import java.util.ArrayList;

// Handles saving and loading expenses from CSV file
public class FileHandler {

    private static final String FILE_PATH = "data/expenses.csv";

    // Save all expenses to CSV file
    public static void saveExpenses(ArrayList<Expense> expenses) {

        //System.out.println("Saving to: " + new File(FILE_PATH).getAbsolutePath());

        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {

            for (Expense e : expenses) {
                writer.println(e.toCSV());
            }

        } catch (IOException e) {
            System.out.println("Error saving expenses.");
        }
    }

    // Load expenses from CSV file
    public static ArrayList<Expense> loadExpenses() {

        ArrayList<Expense> expenses = new ArrayList<>();

        File file = new File(FILE_PATH);

        // If file does not exist, return empty list
        if (!file.exists()) {
            return expenses;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",");

                int id = Integer.parseInt(parts[0]);
                String title = parts[1];
                double amount = Double.parseDouble(parts[2]);
                String category = parts[3];
                String date = parts[4];

                Expense expense = new Expense(id, title, amount, category, date);
                expenses.add(expense);
            }

        } catch (IOException e) {
            System.out.println("Error loading expenses.");
        }

        return expenses;
    }
}
