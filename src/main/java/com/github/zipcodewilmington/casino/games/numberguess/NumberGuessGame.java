package com.github.zipcodewilmington.casino.games.numberguess;

import com.github.zipcodewilmington.utils.IOConsole;

/**
 * Created by leon on 7/21/2020.
 */
public class NumberGuessGame extends IOConsole {

    public void main(String[] args) {

        int winningNum = (int) (50 * Math.random());
        int numOfGuesses = 0;
        int numPlayerGuessed;

        for (int i = 0; i < 50; i++) {
            numPlayerGuessed = getIntegerInput("", args);
            if (winningNum == numPlayerGuessed) {
                System.out.println("Correct!");
                numOfGuesses++;
                break;
            } else if (winningNum > numPlayerGuessed) {
                System.out.println("Too small, guess again");
                numOfGuesses++;
            } else if (winningNum < numPlayerGuessed) {
                System.out.println("Too big, guess again");
                numOfGuesses++;
            } else if (numOfGuesses == 3) {
                System.out.println("Out of tries");
            }
        }

    }

}