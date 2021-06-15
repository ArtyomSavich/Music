package com.solvd.savich.music.album;

import com.solvd.savich.music.artist.Artist;

import java.util.Set;

public class Album implements Library { //Add overload !

    private String name;
    private int date;
    private Artist artists;
    private Set<Track> uniqueTracks;

        public Album(String name, int date, Artist artists, Set<Track> uniqueTracks) {
        this.name = name;
        this.date = date;
        this.artists = artists;
        this.uniqueTracks = uniqueTracks;
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
        return artists;
    }

    public void addTrack(Track track){
        uniqueTracks.add(track);
     }

    public Set<Track> getOfUniqueTracks(){return uniqueTracks;}



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
    public String toString() {
        return "Album{" +
                "name= '" + name + '\'' +
                ", date=" + date +
                ", artists=" + artists +
                ",\nuniqueTracks=" + uniqueTracks +
                '}';
    }
}
