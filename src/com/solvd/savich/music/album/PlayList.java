package com.solvd.savich.music.album;

import java.util.ArrayList;

public class PlayList implements Collection {

    private String name;
    private ArrayList<Track> playList;

    public PlayList(String name, ArrayList<Track> playList) {
        this.name = name;
        this.playList = playList;
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
        System.out.println("Воспроизведение плейлиста");
    }
}
