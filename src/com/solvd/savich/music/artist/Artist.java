package com.solvd.savich.music.artist;

import com.solvd.savich.music.album.Track;

public abstract class Artist /*implements Comparable<Artist>*/{

    private String name;
    private Genre genre;

    public Artist(String name, Genre genre){
        this.name = name;
        this.genre = genre;
    }
    public Artist(){

    }
    public Artist(String name){
        this.name = name;
    }

    public abstract void playSong();

    public abstract void playSong(Track track);

    public String getName() {

        return name;
    }
    public Genre getGenre(){
        return genre;
    }

   /* @Override
    public int compareTo(Artist o) {
        return this.getName().compareTo(o.getName());
    }*/
    @Override
    public String toString() {
        return (" Artist name = '" + name + '\'' + ", genre = " + genre);
    }
}
