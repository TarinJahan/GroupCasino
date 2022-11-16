package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.numberguess.NumberGuessGame;
import org.junit.Assert;
import org.junit.Test;

public class NumberGuessGameTest {

    @Test
    public void randNumTest() {
        //G
        //int expected = (int) (50 * Math.random());
        int expected = 50;
        int actual = (int) (50 * Math.random());
        Assert.assertTrue(actual >=0 && actual <= 49);
    }

}
