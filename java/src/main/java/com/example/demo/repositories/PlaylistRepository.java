package com.example.demo.repositories;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.demo.entities.Playlist;

public class PlaylistRepository implements IPlaylistRepository{
    private final Map<String,Playlist> playlistMap;
    private Long autoIncrement = 1L;

    public PlaylistRepository(){
        playlistMap = new HashMap<String,Playlist>();
    }

    @Override
    public Playlist savePlaylist(Playlist playlist) {
        Playlist g = new Playlist(playlist.getName(),playlist.getSongs(),autoIncrement);
        playlistMap.put(playlist.getName(),g);
        ++autoIncrement;
        return g;
    }


    @Override
    public void modifyPlaylist(String playlistname, Playlist p) {
        playlistMap.put(playlistname,p);
    }

    @Override
    public boolean existsById(Long id) {
        //return playlistMap.containsKey(id);
        return false;
    }

    @Override
    public Optional<Playlist> findByName(String name) {
        return Optional.ofNullable(playlistMap.get(name));
    }

    @Override
    public List<Playlist> findAll() {
        return playlistMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        //playlistMap.remove(id);
    }


    public void deleteByName(String name) {
        playlistMap.remove(name);
    }

    @Override
    public long count() {
        return playlistMap.size();
    }

    @Override
    public Optional<Playlist> findById(Long id) {
        
        return null;
    }
    
}
