package com.example.demo.entities;

public class IdleState extends PlayerState {
     // if we want to use parents player attribute, then we must not declare our own player attribute here
    Player player;
    IdleState(Player player) {
        super(player);  // sets player variable of parent interface
        this.player=player;  // sets player variable of self. .. no need to do this, if you are not having your player, but using layer attribute of parent class itslef
       
    }
    public void play(){
        int songindex = this.player.currSong;
        if(this.player.currPlaylist == null){
            System.out.println("PLAYLIST NOT LOADED");
        }
        else{
            Song song = this.player.currPlaylist.get(songindex);
        System.out.println(song+ " is playing!");
        //this.player.incrementSongIndex();
        this.player.changeState(new PlayingState(this.player));    
        }
        
    }

    public void next(){
        System.out.println("Can not play next song from Idle state");
    }

    public void previous(){
        System.out.println("Can not play previous song from Idle state");
    }
    public void stop(){
        System.out.println("Can not stop song from Idle state");
    }
}
