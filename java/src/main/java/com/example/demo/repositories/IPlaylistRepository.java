package com.example.demo.repositories;
import java.util.List;
import java.util.Optional;

import com.example.demo.entities.Playlist;

public interface IPlaylistRepository {
    Playlist savePlaylist(Playlist playlist);
    void modifyPlaylist(String string, Playlist pModified);
    boolean existsById(Long id);
    Optional<Playlist> findById(Long id);
    List<Playlist> findAll();
    void deleteById(Long id);
    long count();
    Optional<Playlist> findByName(String playlistName);
    void deleteByName(String name);
}
