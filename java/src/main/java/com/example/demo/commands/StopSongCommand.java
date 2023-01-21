package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Player;



public class StopSongCommand implements ICommand{

    private final Player player;

    public StopSongCommand(Player player) {
        this.player = player;
    }

    @Override
    public void invoke(List<String> tokens) { 
        player.stop();
    }
    
}
