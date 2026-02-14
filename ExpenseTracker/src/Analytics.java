import java.util.ArrayList;

// Handles calculations and analytics
public class Analytics {

    // Total amount spent
    public static double getTotal(ArrayList<Expense> expenses) {
        double total = 0;

        for (Expense e : expenses) {
            total += e.getAmount();
        }

        return total;
    }

    // Category wise total
    public static void categoryTotals(ArrayList<Expense> expenses) {

        System.out.println("\nCategory Analytics:");

        ArrayList<String> categories = new ArrayList<>();

        // Collect unique categories
        for (Expense e : expenses) {
            if (!categories.contains(e.getCategory())) {
                categories.add(e.getCategory());
            }
        }

        // Calculate totals per category
        for (String cat : categories) {
            double sum = 0;

            for (Expense e : expenses) {
                if (e.getCategory().equals(cat)) {
                    sum += e.getAmount();
                }
            }

            System.out.println(cat + ": " + sum);
        }
    }
}
