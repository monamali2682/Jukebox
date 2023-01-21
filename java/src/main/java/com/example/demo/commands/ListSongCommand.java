package com.example.demo.commands;

import java.util.List;

//import com.example.demo.entities.Greeting;
import com.example.demo.entities.Song;
//import com.example.demo.services.GreetingService;
import com.example.demo.services.SongService;

public class ListSongCommand implements ICommand{

    private final SongService songservice; 

    public ListSongCommand(SongService songservice) {
        this.songservice = songservice;
    }

    @Override
    public void invoke(List<String> tokens) {

        List<Song> songs= songservice.getAllSongs();
        StringBuilder output = new StringBuilder("[");
        for(Song song : songs){
            output.append(song);
            output.append(", ");
        }
        output.deleteCharAt(output.length()-1);
        output.deleteCharAt(output.length()-1);
        output.append("]");

        System.out.println(output);
    }
    
}
