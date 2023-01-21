package com.example.demo.commands;

//import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.example.demo.entities.Playlist;

import com.example.demo.services.PlaylistService;

public class CreatePlaylistCommand implements ICommand{
    
    private final PlaylistService playlistService; 

    public CreatePlaylistCommand(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @Override
    public void invoke(List<String> tokens) {
        String name = tokens.get(1);
        LinkedList<Long> songIds=new LinkedList<>();
        int size = tokens.size();
        for(int i=2;i<size;i++){
            songIds.add(Long.parseLong(tokens.get(i)));
        }
        try {
            Playlist p = playlistService.createPlaylistbyId(name,songIds);
            System.out.println(p);
            //Playlist [id=1]
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
