package com.example.demo.commands;

import java.util.List;

//import com.example.demo.entities.Greeting;
import com.example.demo.entities.Playlist;
import com.example.demo.entities.Song;
//import com.example.demo.services.GreetingService;
import com.example.demo.services.PlaylistService;

public class AddSongToPlaylistCommand implements ICommand{
    
    private final PlaylistService playlistService; 

    public AddSongToPlaylistCommand(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @Override
    public void invoke(List<String> tokens) {
        String name = tokens.get(1);
        Long songid = Long.parseLong(tokens.get(2)) ;
        Playlist p = playlistService.addSong(name, songid);
        StringBuilder songs = new StringBuilder("[");
        for(Song song: p.getSongs()){
            songs.append("Song [id=");
            songs.append(song.getId());
            songs.append("], ");
        }
        songs.deleteCharAt(songs.length()-1);
        songs.deleteCharAt(songs.length()-1);
        songs.append("]");

        System.out.println("Playlist " + p.getName() +" is revised with " + songs.toString());
        ///Playlist PLAYLIST_2 is revised with [Song [id=1], Song [id=3], Song [id=5], Song [id=7], Song [id=9], Song [id=8]]
    }

}
