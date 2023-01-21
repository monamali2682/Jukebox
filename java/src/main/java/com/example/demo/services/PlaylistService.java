package com.example.demo.services;

import java.util.LinkedList;
import java.util.List;
import com.example.demo.entities.Playlist;
import com.example.demo.entities.Song;
import com.example.demo.repositories.IPlaylistRepository;
import com.example.demo.repositories.ISongRepository;

public class PlaylistService {
    private final IPlaylistRepository playlistRepository;
    private final ISongRepository songRepository;

    public PlaylistService(IPlaylistRepository playlistRepository, ISongRepository songRepository) {
        this.playlistRepository = playlistRepository;
        this.songRepository = songRepository;
    }
    
    // public Playlist createPlaylist(String name, LinkedList<Song> songs){
    //     Playlist g = new Playlist(name,songs);
    //     return playlistRepository.savePlaylist(g);
    // }

    public Playlist createPlaylistbyId(String name, LinkedList<Long> songIds){
        LinkedList<Song> songs= new LinkedList<>();
        for(long songid:songIds){
            Song song = songRepository.findById(songid).orElseThrow(() -> new RuntimeException("Song with id: " + songid + " not found!"));
            songs.add(song);
        }
        Playlist g = new Playlist(name,songs);
        return playlistRepository.savePlaylist(g);
    }

    // String addSong(Long playlistId,  Long songId);
    public Playlist addSong(String playlistName, Long songid){
        Playlist p = playlistRepository.findByName(playlistName).orElseThrow(() -> new RuntimeException("Playlist with name: " + playlistName + " not found!"));
        LinkedList<Song> songslist = p.getSongs();
        Song song = songRepository.findById(songid).orElseThrow(() -> new RuntimeException("Song with id: " + songid + " not found!"));
        songslist.add(song);
        Playlist pModified = new Playlist(p.getName(), songslist);
        playlistRepository.modifyPlaylist(p.getName(),pModified);
        return pModified;
    }

    //String removeSong(Long playlistId,  Long songId);
    public Playlist deleteSong(String playlistName, Long songid){
        
        Playlist p = playlistRepository.findByName(playlistName).orElseThrow(() -> new RuntimeException("Playlist with name: " + playlistName + " not found!"));
        LinkedList<Song> songslist = p.getSongs();
        Song song = songRepository.findById(songid).orElseThrow(() -> new RuntimeException("Song with id: " + songid + " not found!"));
        songslist.remove(song);
        Playlist pModified = new Playlist(p.getName(), songslist);
        playlistRepository.modifyPlaylist(p.getName(),pModified);
        return pModified;
    }
    //String deletePlaylist(Long playlistId);
    public Playlist deletePlaylist(String name){
        Playlist p = playlistRepository.findByName(name).orElseThrow(() -> new RuntimeException("Playlist with name: " + name + " not found!"));
        playlistRepository.deleteByName(name);
        return p;
    }

    public List<Playlist> getAllPlaylists(){
        return playlistRepository.findAll();
    }

    public Playlist getPlaylist(String name) {
        return playlistRepository.findByName(name).orElseThrow(() -> new RuntimeException("Playlist with name: " + name + " not found!"));
    }
}
