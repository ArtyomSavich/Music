package com.solvd.savich.music.artist;

import com.solvd.savich.music.album.Track;
import com.solvd.savich.music.exceptions.MyExceptions;
import com.solvd.savich.music.instrument.Instrument;

public class Band extends Artist {


    private String band_name;
    private int band_numbersOfMembers;

    public Band(int artist_id, Genre genre, String band_name, int band_numbersOfMembers) {
        super(artist_id, genre);
        this.band_name = band_name;
        this.band_numbersOfMembers = band_numbersOfMembers;
    }

    @Override
    public void playSong() {
        System.out.println("Band with name " + getBand_name() + " play a song");
    }

    @Override
    public String toString() {
        return "\n" + " - " + band_name + " - " + band_numbersOfMembers;
    }

    @Override
    public void playSong(Track track) {
        System.out.println("Band playing " + track.getName());
    }

    @Override
    public void playInstruments(Instrument instrument) throws MyExceptions {
        throw new MyExceptions("Band " + getBand_name() + " can not play on " + instrument);
    }


    public int getBand_numbersOfMembers() {
        return band_numbersOfMembers;
    }

    public void setBand_numbersOfMembers(int band_numbersOfMembers) {
        this.band_numbersOfMembers = band_numbersOfMembers;
    }

    public String getBand_name() {
        return band_name;
    }

    public void setBand_name(String band_name) {
        this.band_name = band_name;
    }
}



