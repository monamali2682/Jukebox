package com.example.demo.commands;

import java.util.List;

import com.example.demo.entities.Song;
import com.example.demo.services.SongService;


public class AddSongCommand implements ICommand{

    private final SongService songservice; 

    public AddSongCommand(SongService songservice) {
        this.songservice = songservice;
    }

    @Override
    public void invoke(List<String> tokens) {
        String name = tokens.get(1);
        String artist = tokens.get(2);
        String album = tokens.get(3);
        String genre = tokens.get(4);

        Song song = songservice.addSong(name, artist,album, genre);
        System.out.println(song);
        //Song [id=1]
    }
    
}
