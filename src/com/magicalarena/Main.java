package com.magicalarena;

import java.util.Scanner;

/**
 * The Main class to run the Magical Arena game.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get player details from user input
        int health1 = getInput(scanner, "Enter health for Player 1:");
        int strength1 = getInput(scanner, "Enter strength for Player 1:");
        int attack1 = getInput(scanner, "Enter attack for Player 1:");

        int health2 = getInput(scanner, "Enter health for Player 2:");
        int strength2 = getInput(scanner, "Enter strength for Player 2:");
        int attack2 = getInput(scanner, "Enter attack for Player 2:");

        // Create players and arena
        Player player1 = new Player(health1, strength1, attack1, "Player 1");
        Player player2 = new Player(health2, strength2, attack2, "Player 2");

        Arena arena = new Arena(player1, player2);
        arena.fight();

        scanner.close();
    }

    private static int getInput(Scanner scanner, String prompt) {
        int value;
        while (true) {
            System.out.println(prompt);
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                if (value > 0) {
                    break;
                } else {
                    System.out.println("Input must be a positive integer. Please try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a positive integer.");
                scanner.next(); // clear the invalid input
            }
        }
        return value;
    }
}
