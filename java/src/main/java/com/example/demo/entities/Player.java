package com.example.demo.entities;

import java.util.LinkedList;

public class Player {
    private PlayerState state;
    LinkedList<Song> currPlaylist;
    int currSong;

    public Player() {
        this.state=new IdleState(this);
        this.currPlaylist=new LinkedList<>();
        this.currSong= 0;
    } 

    public void changeState(PlayerState playerState){
        this.state=playerState;
    }
    
    public void loadPlaylist(Playlist p){
        this.currPlaylist = p.getSongs();
        System.out.println("Playlist "+p.getName()+" is loaded!");
    }

    public void play(){
      state.play();  
    }
    public void next(){
        state.next();
    }
    public void previous(){
        state.previous();
    }
    public void stop(){
        state.stop();
    }

    public void incrementSongIndex() {
        int size = this.currPlaylist.size();
        if(this.currSong==size-1){
            this.currSong=0;
        }else{
            this.currSong++;
        }
    }

    public void decrementSongIndex() {
        int size = this.currPlaylist.size();
        if(this.currSong==0){
            this.currSong=size-1;
        }else{
            this.currSong--;
        }
    }
}
