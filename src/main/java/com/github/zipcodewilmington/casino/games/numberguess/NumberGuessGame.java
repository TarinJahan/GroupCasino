package com.github.zipcodewilmington.casino.games.numberguess;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.IOConsole;

/**
 * Created by leon on 7/21/2020.
 */
public class NumberGuessGame extends IOConsole implements GameInterface{
    public NumberGuessGame() {}

    public void main(String[] args) {
    }

    @Override
    public void add(PlayerInterface player) {

    }

    @Override
    public void remove(PlayerInterface player) {

    }

    @Override
    public void run() {
        int winningNum = (int) (50 * Math.random());
        int numOfGuesses = 0;
        int numPlayerGuessed;

        for (int i = 0; i < 50; i++) {
            numPlayerGuessed = getIntegerInput("Guess a number");
            if (winningNum == numPlayerGuessed) {
                System.out.println("Correct!");
                break;
            } else if (winningNum > numPlayerGuessed) {
                System.out.println("Too small, guess again");
                numOfGuesses++;
            } else if (winningNum < numPlayerGuessed) {
                System.out.println("Too big, guess again");
                numOfGuesses++;
            } else if (numOfGuesses == 5) {
                System.out.println("Out of tries");
            }
        }

    }
}