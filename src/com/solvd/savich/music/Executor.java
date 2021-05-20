package com.solvd.savich.music;

import com.solvd.savich.music.album.Album;
import com.solvd.savich.music.artist.Artist;
import com.solvd.savich.music.artist.Band;
import com.solvd.savich.music.artist.Singer;
import com.solvd.savich.music.genre.Genre;
import com.solvd.savich.music.instrument.Guitar;
import com.solvd.savich.music.instrument.Instrument;

import java.security.Signature;

public class Executor {
    public static void main(String[] args) {
        Artist torBand = new Band("TOR BAND", Genre.ROCK, 2);
        Album album = new Album("ЖЫВЕ", 2020,torBand);
        System.out.println(album.getArtist());
        System.out.println(album.getDate());
        System.out.println(album.getName());
        Band band = new Band("TOR BAND", Genre.ROCK, 2);
        System.out.println(band.getNumbersOfMembers());
        Singer singer = new Singer("TOR BAND", Genre.ROCK,1980);
        System.out.println(singer.getYearOfBirth());
        Guitar guitar = new Guitar("Guitar",7);
        System.out.println(guitar.getNumbersOfString());
        System.out.println(guitar.getNameOfInstrument());
        Instrument guitar1 = new Guitar("Electro guitar",7);
        System.out.println(guitar1.toString());



    }

}
