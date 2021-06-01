package com.solvd.savich.music.album;

import com.solvd.savich.music.artist.Artist;

import java.util.ArrayList;
import java.util.Arrays;

public class Album implements Library { //Add overload

    private String name;
    private int date;
    private Artist artist;

        public Album(String name, int date, Artist artist) {
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

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public Artist getArtist() {
        return artist;
    }

    @Override
    public void reproduce() {
        System.out.println("Reproduce album");
    }

    public void reproduse(Album album){ System.out.println("Reproduse album - " + album.getName()); }

    @Override
    public void stop() {
        System.out.println("Stop album");
    }

    public void stop(Album album) {
        System.out.println("Stop album - " + album.getName());
    }

    @Override
    public void pause() {
        System.out.println("Pause album");
    }

    public void pause(Album album) {
        System.out.println("Pause album - " + album.getName());
    }

    @Override
    public String toString(){return name + artist.toString();}

}
