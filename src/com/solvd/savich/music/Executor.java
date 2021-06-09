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

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Executor { //Create switch and scanner
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String nameType, name;
        Genre genre;
        int earthOfBirth,  numbersOfMembers;

        System.out.println("Please enter number, what a new type of Artist you want to create: 1 - Singer, 2 - Band ?");
        nameType = scanner.nextLine();
            switch (nameType) {
              case "1":
                System.out.println("Please enter name");
                name = scanner.nextLine();
                System.out.println("Please enter number of name genre: 0 - POPULAR, 1 - HIP_HOP , 2 - ROCK, 3 - ELECTRONIC_MUSIC");
                genre = Genre.values()[Integer.parseInt(scanner.nextLine())];
                System.out.println("Please enter integer earthOfBirth");
                earthOfBirth = Integer.parseInt(scanner.nextLine());
                Artist singer = new Singer(name, genre, earthOfBirth);
                System.out.println("You created a new Singer - " + singer);
                break;
              case "2":
                System.out.println("Please enter name");
                name = scanner.nextLine();
                System.out.println("Please enter number of name genre: 0 - POPULAR, 1 - HIP_HOP , 2 - ROCK, 3 - ELECTRONIC_MUSIC");
                genre = Genre.values()[Integer.parseInt(scanner.nextLine())];
                System.out.println("Please enter integer number of members the Band");
                numbersOfMembers = Integer.parseInt(scanner.nextLine());

                ArrayList<Singer> members = new ArrayList<>();

                for (int i = 0; i < numbersOfMembers; i++) {
                    System.out.println("Please enter name of Singer ");
                    String nameOfSinger = scanner.nextLine();
                    System.out.println("Please enter number of name genre: 0 - POPULAR, 1 - HIP_HOP , 2 - ROCK, 3 - ELECTRONIC_MUSIC");
                    Genre genreOfSinger = Genre.values()[Integer.parseInt(scanner.nextLine())];
                    System.out.println("Please enter year Of Birth Singer");
                    int yearOfBirthSinger = Integer.parseInt(scanner.nextLine());
                    members.add(new Singer(nameOfSinger, genreOfSinger, yearOfBirthSinger));
                }
                Artist band = new Band(name, genre, numbersOfMembers, members);
                System.out.println(band);
                break;
            default:
                System.out.println("Incorrect type of Artist!");
                break;
        }

        System.out.println("-----------------");

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

        Artist band = new Band("Linkin Park", Genre.ROCK, 5, artist);

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

        PlayList myMood = new PlayList("My mood", new ArrayList<>());
        myMood.addTrack(aPlaceForMyHead);
        myMood.addTrack(forgotten);
        myMood.addTrack(cureForTheItch);
        myMood.addTrack(pushingMeAway);

        System.out.println(myMood);
        System.out.println("--------------");

        Album hybridTheory = new Album("Hybrid Theory", 2000, band);

        hybridTheory.reproduce();
        hybridTheory.reproduse(hybridTheory);
        hybridTheory.stop();
        hybridTheory.stop(hybridTheory);
        hybridTheory.pause();
        hybridTheory.pause(hybridTheory);

        System.out.println(hybridTheory);
        System.out.println("--------------");

        Guitar guitar = new Guitar("Guitar", 4);
        System.out.println("Name of instrument - " + guitar.getNameOfInstrument());
        System.out.println("Number of string - " + guitar.getNumbersOfString());
        System.out.println("--------------");

        Guitar guitarElectro = new Guitar("Electro guitar", 6);
        System.out.println("Name of instrument - " + guitarElectro.getNameOfInstrument());
        System.out.println("Number of string - " + guitarElectro.getNumbersOfString());
        System.out.println("--------------");
        Piano piano = new Piano("Piano", true);


    }
/*
    private static void enterNameType() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter number, what a new type of Artist you want to create: 1 - Singer, 2 - Band ?");
                if (!scanner.hasNextInt()){
            System.out.println("You enter incorrect number of Singer!");
            enterNameType();
        } else {
           int nameType = scanner.nextInt();

        }
    }
*/
  /*  private static void myMain() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите кол-во интервалов: ");
        if (!sc.hasNextInt()) {
            System.out.println("Повторите попытку!");
            myMain();
        } else {
            int n = sc.nextInt();
        }
    */

}


