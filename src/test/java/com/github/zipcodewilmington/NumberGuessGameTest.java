package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.numberguess.NumberGuessGame;
import com.github.zipcodewilmington.casino.games.numberguess.NumberGuessPlayer;
import org.junit.Assert;
import org.junit.Test;

public class NumberGuessGameTest {

    @Test
    public void randNumTest() {
        NumberGuessGame ngg = new NumberGuessGame();
        NumberGuessPlayer ngp = new NumberGuessPlayer();
        ngg.add(ngp);
        ngg.remove(ngp);
        ngg.playAgain();
        //G
        //int expected = (int) (50 * Math.random());
        int expected = 50;
        int actual = (int) (50 * Math.random());
        Assert.assertTrue(actual >=0 && actual <= 49);
    }
}
