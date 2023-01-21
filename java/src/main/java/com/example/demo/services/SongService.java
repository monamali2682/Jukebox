package com.example.demo.services;

import java.util.List;
import com.example.demo.entities.Song;
import com.example.demo.repositories.ISongRepository;

public class SongService {
    private final ISongRepository SongRepository;

    public SongService(ISongRepository SongRepository) {
        this.SongRepository = SongRepository;
    }
    
    public Song addSong(String name, String artist, String album,String genre){
        Song g = new Song(name,artist,album,genre);
        return SongRepository.saveSong(g);
    }

    public List<Song> getAllSongs(){
        return SongRepository.findAll();
    }

    public Song getSong(Long id) {
        return SongRepository.findById(id).orElseThrow(() -> new RuntimeException("Song with id: " + id + " not found!"));
    }
}
