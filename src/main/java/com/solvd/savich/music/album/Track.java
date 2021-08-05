package com.solvd.savich.music.album;

public class Track implements Library { // Override toString

    private int track_id;
    private String name;

    public Track(int track_id, String name){
        this.track_id = track_id;
        this.name = name;
    }
    public Track(int track_id){
        this.track_id = track_id;
    }
    public Track(String name){
        this.name = name;
    }
    public Track(){}

    public int getTrack_id() {
        return track_id;
    }

    public void setTrack_id(int track_id) {
        this.track_id = track_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){return "\n"+track_id +" - "+ name;}

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