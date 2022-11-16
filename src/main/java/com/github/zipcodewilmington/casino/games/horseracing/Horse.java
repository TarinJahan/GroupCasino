package com.github.zipcodewilmington.casino.games.horseracing;

public class Horse {
    String name;
    int number;
    int odds;

    public Horse(String name, int num, int odd) {
        this.name = name;
        this.number = num;
        this.odds = odd;
    }

    public int getOdds () {
        return this.odds;
    }
}
