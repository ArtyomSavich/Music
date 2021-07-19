package com.solvd.savich.music.album;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class PlayList implements Library { //Add method addTrack!clea

    private String name;
    private List<Track> playList;


    public PlayList(String name, List<Track> playList) {
        this.name = name;
        this.playList = playList;
    }

    public void setTrack (Track track){
        this.playList.add(track);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Track> getPlayList() {
        return playList;
    }

    public void setPlayList(ArrayList<Track> playList) {
        this.playList = playList;
    }

    public void removeTrackFromPlayLists (int index){
        playList.remove(index);
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

