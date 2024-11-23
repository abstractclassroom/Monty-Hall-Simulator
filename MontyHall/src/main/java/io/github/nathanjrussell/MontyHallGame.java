package io.github.nathanjrussell;
import java.util.Random;

/**
 * Represents a Monty Hall game.
 * The game has three doors, behind one of which is a prize.
 * The player picks a door, and the host reveals a door that does not contain the prize.
 * The player can then choose to switch doors or stay with their initial choice.
 */
public class MontyHallGame {
    private final Random random = new Random();

    private final int prizeDoor;
    private final int playerChoice;
    private final int revealedDoor;
    private final int playerFinalSelection; // The door the player will finally choose
    private final boolean switchDoor;
    private final boolean playerWins;


    /**
     * Simulates a Monty Hall game.
     * @param pickedDoor The door the player will pick (1,2 or 3).
     * @param switchDoor Whether the player will switch doors.
     */
    public MontyHallGame(int pickedDoor, boolean switchDoor) {
        if (pickedDoor < 1 || pickedDoor > 3) {
            throw new IllegalArgumentException("Invalid door selected. Must be between 1 and 3 inclusive.");
        }
        this.prizeDoor = random.nextInt(3) + 1; // The door with the prize
        this.switchDoor = switchDoor;
        this.playerChoice = pickedDoor;
        this.revealedDoor = selectRevealDoor(); // Host reveals a door
        if (switchDoor) {
            // The player initial choice and revealed door are different so the final choice is the only remaining door
            this.playerFinalSelection = 6 - this.playerChoice - this.revealedDoor;
        } else {
            this.playerFinalSelection = this.playerChoice;
        }
        this.playerWins = this.playerFinalSelection == this.prizeDoor;

    }

    /**
     * Selects a door for the host to reveal.
     * @return The door number that the host reveals.
     */
    public int selectRevealDoor() {
        //only one door to reveal if the prize door is not the player's choice
        if (this.playerChoice != this.prizeDoor) {
            return 6 - this.playerChoice - this.prizeDoor;
        }
        //two doors to choose from if the prize door is the player's choice
        int[] availableDoors = new int[2];
        for (int i = 1, j=0; i <=3; i++) {
            if (i != this.playerChoice ) {
                availableDoors[j++] = i; //add the door to the list of available doors
            }
        }
        //randomly select one of the two available doors
        return availableDoors[random.nextInt(2)];
    }

    /**
     * @return The door with the prize.
     */
    public int getPrizeDoor() {
        return prizeDoor;
    }

    /**
     * @return The door the player initially picked.
     */
    public int getPlayerChoice() {
        return playerChoice;
    }

    /**
     * @return The door the player finally picked.
     */
    public int getPlayerFinalSelection() {
        return playerFinalSelection;
    }

    /**
     * @return Whether the player switched doors.
     */
    public boolean didPlayerSwitch() {
        return switchDoor;
    }


    /**
     * @return The number of wins when the player switches doors.
     */
    public int getRevealedDoor() {
        return revealedDoor;
    }

    /**
     * @return Whether the player won the game.
     */
    public boolean didPlayerWin() {
        return playerWins;
    }
}


