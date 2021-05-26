package com.solvd.savich.music;

import com.solvd.savich.music.album.Album;
import com.solvd.savich.music.artist.Artist;
import com.solvd.savich.music.artist.Band;
import com.solvd.savich.music.artist.Singer;
import com.solvd.savich.music.artist.Genre;
import com.solvd.savich.music.instrument.Guitar;
import com.solvd.savich.music.instrument.Instrument;
import com.solvd.savich.music.instrument.Piano;

public class Executor {
    public static void main(String[] args) {
        Artist torBand = new Band("TOR BAND", Genre.ROCK, 2);
        Album album = new Album("LIVE", 2020,torBand);
        System.out.println(album.getArtist());
        System.out.println(album.getDate());
        System.out.println(album.getName());

        Band band = new Band("TOR BAND", Genre.ROCK, 2);
        System.out.println(band.getNumbersOfMembers());

        Singer singer = new Singer("TOR BAND", Genre.ROCK,1980);
        System.out.println("Year of birth artist "+ singer.getName() + " - " + singer.getYearOfBirth());

        Guitar guitar = new Guitar("Guitar",4);
        System.out.println("Name of instrument - " + guitar.getNameOfInstrument());
        System.out.println("Number of string - " + guitar.getNumbersOfString());

        Guitar guitarElectro = new Guitar("Electro guitar",6);
        System.out.println("Name of instrument - " + guitarElectro.getNameOfInstrument());
        System.out.println("Number of string - " + guitarElectro.getNumbersOfString());

        Piano piano = new Piano("Piano", true);
        piano.reproduce();




    }

}
