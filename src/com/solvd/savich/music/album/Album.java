package com.solvd.savich.music.album;

import com.solvd.savich.music.artist.Artist;

public class Album {

    private String name;
    private int date;
    private Artist artist;

    public Album(String name, int date, Artist artist){
       this.name = name;
       this.date = date;
       this.artist = artist;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getDate(){
        return date;
    }
    public void setDate(int date){
        this.date = date;
    }

    public Artist getArtist() {
        return artist;
    }
}
