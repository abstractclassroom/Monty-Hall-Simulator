package io.github.nathanjrussell;

import java.util.Random;
public class Main {
    public static void main(String[] args) {
        int noSwitchWins = 0;
        int switchWins = 0;
        int simulations = 100000; //number of simulations for each strategy (switching and not switching)
        int wins = 0;

        for (int i = 0; i < simulations; i++) {
            int initialPick = new Random().nextInt(3) + 1; //randomly select a door 1,2 or 3
            MontyHallGame noSwitchGame = new MontyHallGame(initialPick, false);
            MontyHallGame switchGame = new MontyHallGame(initialPick, true);

            if (noSwitchGame.didPlayerWin()) {
                noSwitchWins++;
                wins++;
            }
            if (switchGame.didPlayerWin()) {
                switchWins++;
                wins++;
            }
        }

        //add blue header
        System.out.print("\u001B[34m");
        System.out.println("Monty Hall Simulation Results");
        System.out.println("------------------------------");


        //results in orange
        System.out.print("\u001B[33m");
        System.out.println("There were a total of " + simulations + " no switch simulations.");
        System.out.println("There were a total of " + simulations + " switch simulations.");
        System.out.println("There were a total of " + (2 * simulations) + " total simulations.");
        System.out.println("No Switch strategy wins: " + noSwitchWins);
        System.out.println("Switch strategy wins: " + switchWins);
        System.out.println("Total wins: " + wins);

        System.out.print("\u001B[34m");
        System.out.println("\nBelow are the win rates for each strategy and the total win rate:");
        System.out.println("-----------------------------------------------------------------");
        System.out.print("\u001B[33m");
        System.out.printf("No switch win rate: %.2f%%\n", (100.0 * noSwitchWins / simulations));
        System.out.printf("Switch win rate: %.2f%%\n", (100.0 * switchWins / simulations));
        System.out.printf("Total win rate: %.2f%%\n", (100.0 * wins / (2 * simulations)));
        System.out.print("\u001B[0m");

    }
}