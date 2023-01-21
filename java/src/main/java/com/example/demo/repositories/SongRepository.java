package com.example.demo.repositories;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.demo.entities.Song;
public class SongRepository implements ISongRepository{
    private final Map<Long,Song> SongMap;
    private Long autoIncrement = 1L;

    public SongRepository(){
        SongMap = new HashMap<Long,Song>();
    }

    @Override
    public Song saveSong(Song song) {
        Song g = new Song(song.getName(),song.getArtist(), song.getAlbum(),song.getGenre(),autoIncrement);
        SongMap.put(autoIncrement,g);
        ++autoIncrement;
        return g;
    }
    @Override
    public boolean existsById(Long id) {
        return SongMap.containsKey(id);
    }

    @Override
    public Optional<Song> findById(Long id) {
        return Optional.ofNullable(SongMap.get(id));
    }

    @Override
    public List<Song> findAll() {
        return SongMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        SongMap.remove(id);
    }

    @Override
    public long count() {
        return SongMap.size();
    }
    
}
