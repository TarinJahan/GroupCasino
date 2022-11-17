package com.github.zipcodewilmington.casino.games.cardgames;

public enum RANKS {
    TWO("2", 2),
    THREE("3", 3),
    FOUR("4", 4),
    FIVE("5", 5),
    SIX("6", 6),
    SEVEN("7", 7),
    EIGHT("8", 8),
    NINE("9", 9),
    TEN("T", 10),
    JACK("J", 10),
    QUEEN("Q", 10),
    KING("K", 10),
    ACE("A", 1);

    public final int value;
    public final String num;

    private RANKS(String num, int value) {
        this.num = num;
        this.value = value;
    }
}
