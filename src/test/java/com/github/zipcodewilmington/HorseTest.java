package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.games.horseracing.Horse;
import com.github.zipcodewilmington.casino.games.horseracing.HorseBetter;
import com.github.zipcodewilmington.casino.games.horseracing.HorseRaces;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class HorseTest {
    @Test
    public void testHorse() {
        Horse h1 = new Horse("Steve", 1, 5);

        int expected = 5;
        int actual = h1.getOdds();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPickWinner() {
        HorseRaces hr = new HorseRaces();
        int[] horses = new int[9];

        for (int i=0; i<1000; i++) {
            horses[hr.pickWinner()]++;
        }

        for (int j=1; j<9; j++) {
            Assert.assertTrue(horses[j]>0);
            if (horses[j]==0) System.out.println("Horse"+j+"is never picked");
        }
    }

    @Test
    public void testStable() {
        HorseRaces hr = new HorseRaces();
        hr.buildStable();

        Assert.assertTrue(hr.getStableSize()>0);
    }

    @Test
    public void testWhoWon() {
        HorseRaces hr = new HorseRaces();
        hr.buildStable();
        double expected = 80.0;
        double actual = hr.whoWon();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testHorseBetter() {
        CasinoAccount ca = new CasinoAccount("star", "man");
        HorseBetter hb = new HorseBetter();

        hb.addAccount(ca);
        CasinoAccount ca1 = hb.getArcadeAccount();

        hb.transferMoney(50);

        Assertions.assertEquals(ca.getAccountName(), ca1.getAccountName());
    }
}

