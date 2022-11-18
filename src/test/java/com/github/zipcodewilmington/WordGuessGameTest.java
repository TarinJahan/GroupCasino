package com.github.zipcodewilmington;
import com.github.zipcodewilmington.casino.games.wordguess.WordGuessGame;
import org.junit.Assert;
import org.junit.Test;

public class WordGuessGameTest {
    @Test
    public void numOfCharsGuessedCorrectTest() {
        String word = "hello";
        String guessed = "cello";
        int expected = 4;
        int actual = WordGuessGame.numOfCharsGuessedCorrect(word, guessed);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void numOfCharsGuessedCorrectTest2() {
        String word = "hello";
        String guessed = "break";
        int expected = 0;
        int actual = WordGuessGame.numOfCharsGuessedCorrect(word, guessed);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void numOfCharsGuessedCorrectTest3() {
        String word = "hello";
        String guessed = "beaks";
        int expected = 1;
        int actual = WordGuessGame.numOfCharsGuessedCorrect(word, guessed);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void numOfCharsGuessedCorrectTest4() {
        String word = "hello";
        String guessed = "hello";
        int expected = 5;
        int actual = WordGuessGame.numOfCharsGuessedCorrect(word, guessed);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void validPlayerGuessTest() {
        String input = "hi";
        boolean actual = WordGuessGame.validPlayerGuess(input);
        Assert.assertFalse(actual);
    }

    @Test
    public void validPlayerGuessTest2() {
        String input = "theworldisround";
        boolean actual = WordGuessGame.validPlayerGuess(input);
        Assert.assertFalse(actual);
    }

    @Test
    public void validPlayerGuessTest3() {
        String input = "";
        boolean actual = WordGuessGame.validPlayerGuess(input);
        Assert.assertFalse(actual);
    }

    @Test
    public void validPlayerGuessTest4() {
        String input = "hello";
        boolean actual = WordGuessGame.validPlayerGuess(input);
        Assert.assertTrue(actual);
    }

}
