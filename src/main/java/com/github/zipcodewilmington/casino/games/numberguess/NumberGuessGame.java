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
        int numPlayerGuessed;
        int attempts = 0;

        printRules();
        for (int i = 0; i < 5; i++) { //gives player 5 guesses
            numPlayerGuessed = getIntegerInput("Guess a number");
            attempts++;
//            System.out.println(attempts);
            if (winningNum == numPlayerGuessed) {
                System.out.println("Correct!");
                break;
            } else if (winningNum > numPlayerGuessed) {
                System.out.println("Too small");
            } else if (winningNum < numPlayerGuessed) {
                System.out.println("Too big");
            } if (attempts == 5) {
                System.out.println("Out of tries!");
            }
        }
    }

    @Override
    public void printRules() {
        System.out.println("Welcome to number guess! You have 5 attempts to guess the winning number which is 0-50");
    }

    @Override
    public void playAgain() {
//        int playAgain = getIntegerInput("Would you like to play again?\n1. yes 2. no");
//        if (playAgain == 1) {
//            run();
//        } else {
//
//        }
    }
}