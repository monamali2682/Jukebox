package com.example.demo.commands;

import java.util.List;

//import com.example.demo.entities.Greeting;
import com.example.demo.entities.Playlist;
//import com.example.demo.services.GreetingService;
import com.example.demo.services.PlaylistService;

public class DeletePlaylistCommand implements ICommand{

    private final PlaylistService playlistService; 

    public DeletePlaylistCommand(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @Override
    public void invoke(List<String> tokens) {
        String name = tokens.get(1);
        try {
            Playlist p = playlistService.deletePlaylist(name);
            System.out.println("Playlist "+p.getName()+" is deleted!");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
