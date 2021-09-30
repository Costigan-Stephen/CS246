package team8;

import java.util.ArrayList;
import java.util.List;
class VacationCalculator {

    public static void main(String[] args) {

        VacationCalculator vc = new VacationCalculator();

        // Calculate some vacation costs...
        float japanCost     = vc.calculateVacationCost(Destination.Japan, 5);
        float mexicoCost    = vc.calculateVacationCost(Destination.Mexico, 5);
        float europeCost    = vc.calculateVacationCost(Destination.Europe, 5);

        // Print the cost...
        System.out.format(String.format("Total cost for trip to Japan:  $%.2f%n", japanCost));
        System.out.format(String.format("Total cost for trip to Mexico: $%.2f%n", mexicoCost));
        System.out.format(String.format("Total cost for trip to Europe: $%.2f%n", europeCost));
    }

    /**
     * Calculates the total cost for vacationing at a given location for
     * a specific number of nights.
     *
     * @param  dest the destination of the vacation
     * @return      the total cost of the vacation
     */
    public float calculateVacationCost(Destination dest, int nights)
    {
        List<Expense> expenses = new ArrayList<Expense>();
        Cruise  c = new Cruise(dest);
        Dining  d = new Dining(dest, nights);
        Lodging l = new Lodging(dest, nights);
        expenses.add(c);
        expenses.add(d);
        expenses.add(l);
        return tallyExpenses(expenses);
    }

    /**
     * An internal method used by VacationCalculator to loop through
     * a List of items that implement the Expense interface and
     * determine their cost
     *
     * @param  expenses A list of items that implement the Expense interface
     * @return          the total cost calculated by the items
     */
    float tallyExpenses(List<Expense> expenses)
    {
        float total = 0.0f;
        for (Expense ex: expenses){
            total += ex.getCost();
        }
        return total;
    }
}
