import java.util.Scanner;

public class p5 {
    public static void main(String[] args) {
        VendingState state = VendingState.IDLE;
        int stock = 2;          // number of items available
        int balance = 0;        // coins inserted so far
        int itemCost = 10;      // cost of one item
        Scanner sc = new Scanner(System.in);

        while (state != VendingState.OUT_OF_STOCK) {
            switch (state) {

                case IDLE:
                    System.out.println("\nWelcome! Press Enter to start.");
                    sc.nextLine();
                    state = VendingState.ACCEPTING_MONEY;
                    break;

                case ACCEPTING_MONEY:
                    System.out.println("Insert coins. Balance: " + balance + " / " + itemCost);
                    System.out.print("Enter coin value: ");
                    balance += sc.nextInt();
                    sc.nextLine();
                    if (balance >= itemCost) {
                        state = VendingState.DISPENSING;
                    } else {
                        System.out.println("Need " + (itemCost - balance) + " more cents.");
                    }
                    break;

                case DISPENSING:
                    System.out.println("Dispensing item...");
                    balance -= itemCost;
                    stock--;
                    System.out.println("Remaining stock: " + stock);
                    if (stock == 0) {
                        state = VendingState.OUT_OF_STOCK;
                    } else {
                        state = VendingState.IDLE;
                    }
                    break;
            }
        }

// Runs once the while condition becomes false (state == OUT_OF_STOCK)
        System.out.println("Machine is out of stock. Goodbye!");

    }

    enum VendingState {
        IDLE,
        ACCEPTING_MONEY,
        DISPENSING,
        OUT_OF_STOCK;
    }
}
