package com.example.demo.entities;

import java.util.LinkedList;
//import java.util.List;

public class Playlist {
    private Long id;
    private String name;
    private LinkedList<Song> songs;
    
    public Playlist(String name, LinkedList<Song> songids,Long id) {
        this.id = id;
        this.name = name;
        this.songs = songids;
    }

    public Playlist(String name, LinkedList<Song> songs) {
        this.name = name;
        this.songs = songs;
    }

    public Playlist(String name) {
        this(name,null);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedList<Song> getSongs() {
        return songs;
    }

    // public void setSongIds(LinkedList<Long> songids) {
    //     this.songIds = songids;
    // }

    public String getMessage() {
        return name;
    }   

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Playlist other = (Playlist) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Playlist [id=" + id + "]";
    }
     //Playlist [id=1]
}
