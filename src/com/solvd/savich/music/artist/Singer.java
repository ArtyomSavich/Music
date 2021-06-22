package com.solvd.savich.music.artist;

import com.solvd.savich.music.album.Track;
import com.solvd.savich.music.instrument.Instrument;
import exceptions.MyExceptions;

import java.util.List;

public class Singer extends Artist { //Add Overload method playSong

    private int yearOfBirth;
    List<Singer> singers;
    public Singer(){

    }
    public Singer(String name){
        super(name);
}

    public Singer(String name, Genre genre, int yearOfBirth) {
        super(name, genre);
        this.yearOfBirth = yearOfBirth;
    }
    public int getYearOfBirth() {
        return yearOfBirth;
    }

    @Override
    public void playSong() {
        System.out.println("Year of birth "+ getYearOfBirth()+ "/ Singer "+ getName());
    }

    @Override
    public void playSong(Track track) {
        System.out.println("Singer playing "+ track.getName());
    }

    @Override
    public void playInstruments(Instrument instrument) {
        System.out.println("Singer "+ getName() + " play on " + instrument);
    }

    @Override
    public String toString() {
        return "Artist name = '" + getName() + '\'' + ", genre = " + getGenre() + ", year of birth - " + yearOfBirth;
    }
}

