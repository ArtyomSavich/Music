package com.solvd.savich.music.artist;

import com.solvd.savich.music.album.Track;

public abstract class Artist {

    private String name;
    private Genre genre;

    public Artist(String name, Genre genre){
        this.name = name;
        this.genre = genre;
    }

    public abstract void playSong();

    public abstract void playSong(Track track);

    public String getName() {

        return name;
    }

    @Override
    public String toString() {
        return ("Artist "+"name = '" + name + '\'' + ", genre=" + genre );
    }
}
