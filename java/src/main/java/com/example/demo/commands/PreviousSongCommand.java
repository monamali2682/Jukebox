package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Player;



public class PreviousSongCommand implements ICommand{

    private final Player player;

    public PreviousSongCommand(Player player) {
        this.player = player;
    }

    @Override
    public void invoke(List<String> tokens) { 
        player.previous();
    }
    
}
