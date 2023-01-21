package com.example.demo.commands;

public enum CommandKeyword {

    // Register Command Keywords
    ADD_SONG("ADD_SONG"),
    CREATE_PLAYLIST ("CREATE_PLAYLIST"),
    ADD_SONG_TO_PLAYLIST ("ADD_SONG_TO_PLAYLIST"),
    DELETE_SONG_FROM_PLAYLIST ("DELETE_SONG_FROM_PLAYLIST"),
    DELETE_PLAYLIST ("DELETE_PLAYLIST"),
    PLAY_SONG ("PLAY_SONG"),
    NEXT_SONG ("NEXT_SONG"),
    PREVIOUS_SONG ("PREVIOUS_SONG"),
    STOP_SONG ("STOP_SONG"),
    LIST_SONGS ("LIST_SONGS"), 
    LOAD_PLAYLIST("LOAD_PLAYLIST");
  
    private final String name;
    private CommandKeyword(String name){
        this.name = name;
    }

    public String getName() {
        return name;
     } 
}
