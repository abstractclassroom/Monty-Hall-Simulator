package io.github.nathanjrussell;

import java.util.Random;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int noSwitchWins = 0;
        int switchWins = 0;
        int simulations = 100000; //number of simulations for each strategy (switching and not switching)
        int wins = 0;

        for (int i = 0; i < simulations; i++) {
            int initialPick = new Random().nextInt(3)+1;
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

        System.out.println("Stick strategy wins: " + noSwitchWins);
        System.out.println("Switch strategy wins: " + switchWins);
        System.out.printf("Stick win rate: %.2f%%\n", (100.0 * noSwitchWins / simulations));
        System.out.printf("Switch win rate: %.2f%%\n", (100.0 * switchWins / simulations));
        System.out.println("Total wins: " + wins);
        System.out.printf("Total win rate: %.2f%%\n", (100.0 * wins / (2*simulations)));
//        Random random = new Random();
//        int numGames = 100000;
//        int numWinsSwitching = 0;
//        int numWinsStaying = 0;
//
//        for (int i = 0; i < numGames; i++) {
//            boolean switchDoor = random.nextBoolean();
//            int pickedDoor = random.nextInt(3);
//            MontyHallGame game = new MontyHallGame(pickedDoor, switchDoor);
//            if (game.didPlayerWin()) {
//                if (switchDoor) {
//                    numWinsSwitching++;
//                } else {
//                    numWinsStaying++;
//                }
//            }
//        }
//
//        System.out.println("Wins when switching (proportion): " + numWinsSwitching + " (" + (double) numWinsSwitching / numGames + ")");
//        System.out.println("Wins when staying (proportion): " + numWinsStaying + " (" + (double) numWinsStaying / numGames + ")");
    }
}