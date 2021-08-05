package com.solvd.savich.music.artist;

import com.solvd.savich.music.album.Track;
import com.solvd.savich.music.instrument.Instrument;
import com.solvd.savich.music.exceptions.MyExceptions;

public abstract class Artist {
    private int artist_id;
    private Genre genre;



    public Artist(){

    }

    public Artist(int artist_id, Genre genre){
        this.artist_id = artist_id;
        this.genre = genre;
    }


    public abstract void playSong();

    public abstract void playSong(Track track);




    public abstract void playInstruments(Instrument instrument) throws MyExceptions;

   /* @Override
    public int compareTo(Artist o) {
        return this.getName().compareTo(o.getName());
    }*/
    @Override
    public String toString() {
        return "\n"+ " artist_id = '" + artist_id + '\'' + ", genre = " + genre;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(int artist_id) {
        this.artist_id = artist_id;
    }
}
