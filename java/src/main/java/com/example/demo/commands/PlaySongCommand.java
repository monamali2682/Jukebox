package com.example.demo.commands;

import java.util.List;

//import com.example.demo.entities.Greeting;
import com.example.demo.entities.Player;
// import com.example.demo.entities.Song;
// import com.example.demo.services.GreetingService;
// import com.example.demo.services.PlayerService;
// import com.example.demo.services.PlaylistService;

public class PlaySongCommand implements ICommand{

    private final Player player;

    public PlaySongCommand(Player player) {
        this.player = player;
    }

    @Override
    public void invoke(List<String> tokens) {
        player.play();
    }
}
