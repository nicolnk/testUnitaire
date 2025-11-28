package ticketmachine;

/**
 * The TicketMachine class represents a simple ticket vending machine.
 * It allows users to insert money, print tickets, and get refunds.
 */
public class TicketMachine {
    private final int price; // The price of a single ticket
    private int balance; // The current balance inserted by the user
    private int total; // The total amount of money collected by the machine

    /**
     * Constructs a TicketMachine with the specified ticket price.
     *
     * @param ticketCost The cost of a single ticket (must be positive).
     * @throws IllegalArgumentException if the ticket price is not positive.
     */
    public TicketMachine(int ticketCost) {
        if (ticketCost <= 0) {
            throw new IllegalArgumentException("Ticket price must be positive");
        }
        price = ticketCost;
        balance = 0;
        total = 0;
    }

    /**
     * Returns the price of a single ticket.
     *
     * @return The ticket price.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Returns the total amount of money collected by the machine.
     *
     * @return The total amount collected.
     */
    public int getTotal() {
        return total;
    }

    /**
     * Returns the current balance inserted by the user.
     *
     * @return The current balance.
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Inserts money into the machine.
     *
     * @param amount The amount of money to insert (must be positive).
     * @throws IllegalArgumentException if the amount is not positive.
     */
    public void insertMoney(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Montant inséré doit être positif");
        }
        balance = balance + amount;
    }

    /**
     * Refunds the current balance to the user.
     *
     * @return The amount refunded.
     */
    public int refund() {
        System.out.println("Je vous rends : " + balance + " centimes");
        int amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }

    /**
     * Prints a ticket if the user has inserted enough money.
     * Deducts the ticket price from the balance and adds it to the total.
     *
     * @return true if the ticket was printed, false otherwise.
     */
    public boolean printTicket() {
        if (balance < price) {
            return false;
        }
        balance = balance - price;
        total = total + price;
        System.out.println("##################");
        System.out.println("# The BlueJ Line");
        System.out.println("# Ticket");
        System.out.println("# " + price + " cents.");
        System.out.println("##################");
        System.out.println();
        return true;
    }
}
