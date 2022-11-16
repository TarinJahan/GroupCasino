package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.horseracing.Horse;
import com.github.zipcodewilmington.casino.games.horseracing.HorseRaces;
import org.junit.Assert;
import org.junit.Test;

public class HorseTesting {
    @Test
    public void testHorse() {
        Horse h1 = new Horse("Steve", 1, 5);

        int expected = 5;
        int actual = h1.getOdds();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testHorseWinner() {
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
}
