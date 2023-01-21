package com.example.demo.entities;

public class PlayingState extends PlayerState {
    Player player;
    PlayingState(Player player) {
        super(player);
        this.player=player;
    }
    public void play(){
        int songindex = this.player.currSong;
        Song song = this.player.currPlaylist.get(songindex);
        System.out.println(song+ " is paused!");
        //this.player.incrementSongIndex();
        this.player.changeState(new PausedState(this.player));    
    }

    public void next(){
        this.player.incrementSongIndex();
        int songindex = this.player.currSong;
        Song song = this.player.currPlaylist.get(songindex);
        System.out.println(song+ " is playing!");
        //this.player.changeState(new PausedState(this.player));    
    }

    public void previous(){
        this.player.decrementSongIndex();
        int songindex = this.player.currSong;
        Song song = this.player.currPlaylist.get(songindex);
        System.out.println(song+ " is playing!");
    }
    public void stop(){
        int songindex = this.player.currSong;
        Song song = this.player.currPlaylist.get(songindex);
        System.out.println(song+ " is stopped!");
        //this.player.incrementSongIndex();
        this.player.changeState(new IdleState(this.player)); 
    }
    
}
