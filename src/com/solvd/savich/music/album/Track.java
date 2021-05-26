package com.solvd.savich.music.album;

public class Track implements Collection{

    private String name;

    public Track(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void reproduce() {
        System.out.println("Воспроизведение трека");
    }
}
