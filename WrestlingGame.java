import java.util.Random;
import java.util.Scanner;

public class WrestlingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Create two wrestlers
        Wrestler player = new Wrestler("Player", 100);
        Wrestler opponent = new Wrestler("Opponent", 100);

        System.out.println("Welcome to the Wrestling Game!");

        while (player.isAlive() && opponent.isAlive()) {
            // Display the current status
            System.out.println("Player: " + player.health + " health");
            System.out.println("Opponent: " + opponent.health + " health");

            // Prompt the user to choose an action
            System.out.println("Choose an action:");
            System.out.println("1. Punch");
            System.out.println("2. Kick");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    int playerPunch = random.nextInt(10) + 1; // Random damage between 1 and 10
                    opponent.takeDamage(playerPunch);
                    System.out.println("You punched the opponent for " + playerPunch + " damage!");
                    break;
                case 2:
                    int playerKick = random.nextInt(15) + 1; // Random damage between 1 and 15
                    opponent.takeDamage(playerKick);
                    System.out.println("You kicked the opponent for " + playerKick + " damage!");
                    break;
                case 3:
                    System.out.println("Exiting the game. Thanks for playing!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }

            // Opponent's turn
            int opponentDamage = random.nextInt(10) + 1;
            player.takeDamage(opponentDamage);
            System.out.println("Opponent punched you for " + opponentDamage + " damage!");

            // Check if anyone is defeated
            if (!player.isAlive()) {
                System.out.println("You were defeated! Game over.");
            } else if (!opponent.isAlive()) {
                System.out.println("Congratulations! You defeated the opponent!");
            }
        }

        // Close the scanner
        scanner.close();
    }
}