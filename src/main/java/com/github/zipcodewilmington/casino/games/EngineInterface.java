package com.github.zipcodewilmington.casino.games;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;

public interface EngineInterface<PlayerType, GameType> {
    void start();
    GameInterface getGame();
    Iterable<PlayerInterface> getPlayers();
}
