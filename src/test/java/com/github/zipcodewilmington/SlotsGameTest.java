package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.slots.SlotsGame;
import org.junit.Assert;
import org.junit.Test;

public class SlotsGameTest {
    @Test
    public void pullLeverTest() {
        //Given:
        SlotsGame slots = new SlotsGame();

        //When:
        Assert.assertNull(slots.slotsArray()[0]);

        slots.pullLever();

        //Then:
        Assert.assertNotNull(slots.slotsArray()[0]);

    }

}
