package com.solvd.savich.music;

import com.solvd.savich.music.album.Album;
import com.solvd.savich.music.album.PlayList;
import com.solvd.savich.music.album.Track;
import com.solvd.savich.music.artist.Artist;
import com.solvd.savich.music.artist.Band;
import com.solvd.savich.music.artist.Singer;
import com.solvd.savich.music.artist.Genre;
import com.solvd.savich.music.instrument.Guitar;
import com.solvd.savich.music.instrument.Instrument;
import com.solvd.savich.music.instrument.Piano;

import java.util.ArrayList;

public class Executor { //Add Polymorphism
    public static void main(String[] args) {


        Artist mikeShinoda = new Singer("Mike Shinoda", Genre.ROCK, 1977);
        Artist bradfordPhillip = new Singer("Bradford Phillip", Genre.ROCK, 1977);
        Artist chesterCharlesBennington = new Singer("Chester Charles Bennington", Genre.ROCK, 1976);
        Artist josephHahn = new Singer("Joseph Hahn", Genre.HIP_HOP, 1977);
        Artist robertGregoryBourdon = new Singer("Robert Gregory Bourdon", Genre.ROCK, 1979);

        ArrayList artist = new ArrayList<>();
        artist.add(mikeShinoda);
        artist.add(bradfordPhillip);
        artist.add(chesterCharlesBennington);
        artist.add(josephHahn);
        artist.add(robertGregoryBourdon);

        Track numb = new Track("Numb");
        Track inTheEnd = new Track("In the End");
        Track papercut = new Track("Papercut");
        Track oneStepCloser = new Track("One Step Closer");
        Track withYou = new Track("With You");
        Track crawling = new Track("Crawling");
        Track runaway = new Track("Runaway");
        Track byMyself = new Track("By Myself");
        Track aPlaceForMyHead = new Track("A Place for My Head");
        Track forgotten = new Track("Forgotten");
        Track cureForTheItch = new Track("Cure for the Itch");
        Track pushingMeAway = new Track("Pushing Me Away");

        Band band = new Band("Linkin Park", Genre.ROCK, 5, artist);

        band.playSong();
        band.playSong(numb);
        band.playSong(inTheEnd);
        band.playSong(papercut);

        System.out.println("--------------");

        ArrayList playList = new ArrayList<>();
        playList.add(numb);
        playList.add(inTheEnd);
        playList.add(papercut);
        playList.add(oneStepCloser);
        playList.add(withYou);
        playList.add(crawling);
        playList.add(runaway);
        playList.add(byMyself);

        PlayList myFavorite = new PlayList("My favorite", playList);

        System.out.println(myFavorite);
        System.out.println("--------------");

        PlayList myMood = new  PlayList("My mood",new ArrayList<>());
        myMood.addTrack(aPlaceForMyHead);
        myMood.addTrack(forgotten);
        myMood.addTrack(cureForTheItch);
        myMood.addTrack(pushingMeAway);

        System.out.println(myMood);
        System.out.println("--------------");

        Album hybridTheory = new Album("Hybrid Theory", 2000,band);

        hybridTheory.reproduce();
        hybridTheory.reproduse(hybridTheory);
        hybridTheory.stop();
        hybridTheory.stop(hybridTheory);
        hybridTheory.pause();
        hybridTheory.pause(hybridTheory);

        System.out.println(hybridTheory);
        System.out.println("--------------");

        Guitar guitar = new Guitar("Guitar",4);
        System.out.println("Name of instrument - " + guitar.getNameOfInstrument());
        System.out.println("Number of string - " + guitar.getNumbersOfString());
        System.out.println("--------------");

        Guitar guitarElectro = new Guitar("Electro guitar",6);
        System.out.println("Name of instrument - " + guitarElectro.getNameOfInstrument());
        System.out.println("Number of string - " + guitarElectro.getNumbersOfString());
        System.out.println("--------------");
        Piano piano = new Piano("Piano", true);




    }

}
