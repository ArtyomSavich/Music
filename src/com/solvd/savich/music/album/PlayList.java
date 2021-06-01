package com.solvd.savich.music.album;

import java.util.ArrayList;
import java.util.Arrays;

public class PlayList implements Library { //Add method addTrack!clea

    private String name;
    private ArrayList<Track> playList;

    public PlayList(String name, ArrayList<Track> playList) {
        this.name = name;
        this.playList = playList;
    }

    public void addTrack (Track track){
        this.playList.add(track);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Track> getPlayList() {
        return playList;
    }

    public void setPlayList(ArrayList<Track> playList) {
        this.playList = playList;
    }

    @Override
    public void reproduce() {
        System.out.println("Reproduce playlist");
    }

    @Override
    public void stop() { System.out.println("Stop playlist"); }

    @Override
    public void pause() { System.out.println("Pause playlist"); }

    @Override
    public String toString(){return name +" "+ Arrays.toString(playList.toArray());}

}
