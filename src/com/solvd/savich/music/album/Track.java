package com.solvd.savich.music.album;

public class Track implements Library { // Override toString

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
    public String toString(){return name;}

    @Override
    public void reproduce() {
        System.out.println("Reproduce track");
    }

    @Override
    public void stop() {
        System.out.println("Stop track");
    }

    @Override
    public void pause() {
        System.out.println("Pause track");
    }

}