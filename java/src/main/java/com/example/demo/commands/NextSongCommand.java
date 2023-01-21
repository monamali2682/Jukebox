package com.example.demo.commands;

import java.util.List;

//import com.example.demo.entities.Greeting;
import com.example.demo.entities.Player;
//import com.example.demo.services.GreetingService;

public class NextSongCommand implements ICommand{

    private final Player player;

    public NextSongCommand(Player player) {
        this.player = player;
    }

    @Override
    public void invoke(List<String> tokens) { 
        player.next();
    }

}
