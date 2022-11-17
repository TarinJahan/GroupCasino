package com.github.zipcodewilmington.casino.games.wordguess;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.Random;


public class WordGuessGame extends IOConsole implements GameInterface {

    Random rand = new Random();

    public void main(String[] args) {
    }

    String[] wordBank = {"hello", "world", "sodas"};
    int wordGenerator = rand.nextInt(wordBank.length);
    String chosenWord;
    String playerGuess;

    public static Integer numOfCharsGuessedCorrect(String chosenWord, String playerGuess) {
        int correctCount = 0;

        for (int i = 0; i < chosenWord.length(); i++) {
            if (chosenWord.charAt(i) == playerGuess.charAt(i)) {
                correctCount++;
            }
        }
        return correctCount;
    }


    @Override
    public void add(PlayerInterface player) {

    }

    @Override
    public void remove(PlayerInterface player) {

    }

    @Override
    public void run() {
        //print rules
        printRules();
        //ask player to make guess
        for (int i = 0; i < 5; i++) {
            if (playerGuess.equals(chosenWord)) {
                System.out.println("Correct, you win!");
                break;
            } else if (!playerGuess.equals(chosenWord)) {
                System.out.println(numOfCharsGuessedCorrect(chosenWord, playerGuess)); //num of chars correct guessed
            }
        }
        //check guess against chosen word
        //return num of correct chars
        //guess again if not complete match
        //or correct match and return win
        System.out.println("Out of attempts!");

    }

    @Override
    public void printRules() {
        System.out.println("Welcome to word guess!\nYou will try to guess a 5-lettered word\n" +
                "and have a total of 5 attempts");
    }

    @Override
    public void playAgain() {

    }
}
