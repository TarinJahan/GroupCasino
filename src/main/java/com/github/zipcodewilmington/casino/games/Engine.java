package com.github.zipcodewilmington.casino.games;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;

import java.util.List;

public abstract class Engine<PlayerType extends PlayerInterface, GameType extends GameInterface<PlayerType>> implements EngineInterface<PlayerType, GameType> {
    private GameType game;
    private List<PlayerType> players;

    public Engine(GameType game, List<PlayerType> players) {
        this.game = game;
        this.players = players;
    }

    public void start(){}
}
