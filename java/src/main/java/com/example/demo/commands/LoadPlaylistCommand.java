package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Player;
//import com.example.demo.entities.Greeting;
import com.example.demo.entities.Playlist;
// import com.example.demo.repositories.PlaylistRepository;
// import com.example.demo.services.GreetingService;

import com.example.demo.services.PlaylistService;

public class LoadPlaylistCommand implements ICommand{

    private final Player player; 
    private final PlaylistService playlistService;

    public LoadPlaylistCommand(Player player, PlaylistService playlistService) {
        this.player = player;
        this.playlistService = playlistService;
    }


    @Override
    public void invoke(List<String> tokens) {
        String name = tokens.get(1);
        Playlist p = playlistService.getPlaylist(name);
        player.loadPlaylist(p);
    }
    
}
