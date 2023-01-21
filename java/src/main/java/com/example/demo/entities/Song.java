package com.example.demo.entities;

//import java.util.List;

public class Song {
    private Long id;
    private String name;
    private String genre;
    private String album;
    private String artist;
    
    public Song(String name, String artist,String album,String genre,Long id) {
        this.id = id;
        this.name = name;
        this.album=album;
        this.genre = genre;
        this.artist = artist;
    }

    public Song(String name, String artist,String album,String genre) {
        this.name = name;
        this.album=album;
        this.genre = genre;
        this.artist = artist;
    }

    
    //     this.name= name;
    // }

    

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public String getAlbum() {
        return album;
    }

    public String getArtist() {
        return artist;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        Song other = (Song) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Song [id=" + id + "]";
    }

}
