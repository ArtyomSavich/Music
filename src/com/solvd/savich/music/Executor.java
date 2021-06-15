package com.solvd.savich.music;

import com.solvd.savich.music.album.Album;
import com.solvd.savich.music.album.PlayList;
import com.solvd.savich.music.album.Track;
import com.solvd.savich.music.artist.Artist;
import com.solvd.savich.music.artist.Band;
import com.solvd.savich.music.artist.Singer;
import com.solvd.savich.music.artist.Genre;


import java.util.*;

public class Executor {

    public enum Docs {EMPTY, NAME, WRONG_INPUT, NOT_A_NUMBER, MATCH, WRONG_TYPE, MEMBERS, GENRE, DATE_OF_BIRTH;}

    public static void main(String[] args) {
        Map<Artist, List<Album>> artistListMap = initArtists();

        Executor ex = new Executor();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter 1 if you want to create Artist or 2 if you want to see all artists and 3 if you want exit");
            int option = Integer.parseInt(getValidStringFromConsole(scanner));
            switch (option) {
            case 1:
                List<Artist> artistFromConsole = ex.getArtistsFromConsole();
                for (Artist artist: artistFromConsole) {
                    artistListMap.put(artist, new ArrayList<>());
                }
                break;
            case 2:
                ex.printAllArtists(artistListMap);
                break;
            case 3:
                /*ex.deleteSomeArtist(artistListMap, artistListMap.keySet());*/ //??????
                break;
            case 4:
                return;
            }
        }
    }

    private void printAllArtists(Map<Artist, List<Album>> allArtists) {

        for (Artist artist: allArtists.keySet()) {
            System.out.println(artist.getName());
            System.out.println(allArtists.get(artist));
        }
    }

    private void deleteSomeArtist(Map<Artist, List<Album>> allArtists, Artist someArtist){
        allArtists.remove(someArtist);
    }

    public void printDoc(Docs errorCode) {
        switch (errorCode) {
            case NAME:
                System.out.println("Please enter name");
                break;
            case WRONG_INPUT:
                System.out.println("Check the input");
                break;
            case NOT_A_NUMBER:
                System.out.println("That not a number!, Try again");
                break;
            case MATCH:
                System.out.println("Input doesn't match number. Try again.");
                break;
            case WRONG_TYPE:
                System.out.println("Incorrect type of Artist!");
                break;
            case GENRE:
                System.out.println("Please enter number of name genre: 0 - POPULAR, 1 - HIP_HOP , 2 - ROCK, 3 - ELECTRONIC_MUSIC");
                break;
            case DATE_OF_BIRTH:
                System.out.println("input date");
                break;
            default:
                System.out.println("Please enter number, what a new type of Artist you want to create: 1 - Singer, 2 - Band ?");
                break;
        }
    }

    public List<Artist> getArtistsFromConsole() {
        ArrayList<Artist> artists = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String name;
        Genre genre;
        int dateOfBirth, nameType;

        printDoc(Docs.EMPTY);
        do {
            while (!scanner.hasNextInt()) {
                printDoc(Docs.NOT_A_NUMBER);
                scanner.next();
            }
            nameType = Integer.parseInt(getValidStringFromConsole(scanner));
            if (nameType < 1 || nameType > 2)
                printDoc(Docs.MATCH);
        } while (nameType < 1 || nameType > 2);


        printDoc(Docs.NAME);
        name = getValidStringFromConsole(scanner);
        printDoc(Docs.GENRE);
        genre = Genre.values()[Integer.parseInt(getValidStringFromConsole(scanner))];
        printDoc(Docs.DATE_OF_BIRTH);
        dateOfBirth = Integer.parseInt(getValidStringFromConsole(scanner));
        System.out.println("You selected option - " + nameType);
        switch (nameType) {
            case 1:
                Artist singer = new Singer(name, genre, dateOfBirth);
                artists.add(singer);
                break;
            case 2:
                printDoc(Docs.MEMBERS);
                int num = Integer.parseInt(getValidStringFromConsole(scanner));
                ArrayList<Singer> members = fillMembers(num, scanner);
                Artist band = new Band(name, genre, num, members);
                artists.add(band);
                break;
            default:
                printDoc(Docs.WRONG_TYPE);
                break;
        }
        return artists;
    }
    public static String getValidStringFromConsole(Scanner scanner){
        while (true){
           String string = scanner.nextLine();
           if(string !=null && !string.isEmpty()){
              return string;
           }
            System.out.println("WRONG!!! Try Again, Please enter string not NULL and not empty!");
        }
    }

    public ArrayList<Singer> fillMembers(int numbersOfMembers, Scanner scanner) {

        ArrayList<Singer> members = new ArrayList<>();

        for (int i = 0; i < numbersOfMembers; i++) {
            System.out.println("Please enter name of Singer ");
            String nameOfSinger = getValidStringFromConsole(scanner);
            System.out.println("Please enter number of name genre: 0 - POPULAR, 1 - HIP_HOP , 2 - ROCK, 3 - ELECTRONIC_MUSIC");
            Genre genreOfSinger = Genre.values()[Integer.parseInt(getValidStringFromConsole(scanner))];
            System.out.println("Please enter year Of Birth Singer");
            int yearOfBirthSinger = Integer.parseInt(getValidStringFromConsole(scanner));
            members.add(new Singer(nameOfSinger, genreOfSinger, yearOfBirthSinger));
        }
        return members;
    }
    public List<Singer> getSingerFromBase(){
        Singer mikeShinoda = new Singer("Mike Shinoda", Genre.ROCK, 1977);
        Singer bradfordPhillip = new Singer("Bradford Phillip", Genre.ROCK, 1977);
        Singer chesterCharlesBennington = new Singer("Chester Charles Bennington", Genre.ROCK, 1976);
        Singer josephHahn = new Singer("Joseph Hahn", Genre.HIP_HOP, 1977);
        Singer robertGregoryBourdon = new Singer("Robert Gregory Bourdon", Genre.ROCK, 1979);

        ArrayList<Singer> artists = new ArrayList<>();
        artists.add(mikeShinoda);
        artists.add(bradfordPhillip);
        artists.add(chesterCharlesBennington);
        artists.add(josephHahn);
        artists.add(robertGregoryBourdon);
        return artists;
    }

    public List<PlayList> getMyFavoritePlayList(){
        List<String> trackNames = List.of("Numb","In the End","Papercut","One Step Closer","With You","Crawling",
                "Runaway","By Myself", "A Place for My Head", "Forgotten", "Cure for the Itch","Pushing Me Away");
        PlayList myFavorite = new PlayList("My favorite list", new LinkedList<>());
                for (String trackName: trackNames){
                    myFavorite.setTrack(new Track(trackName));
                }
        return List.of(myFavorite);

    }

    public static Map<Artist, List<Album>> initArtists() {

    Map<Artist, List <Album>> artistToAlbums = new HashMap<>();

    Singer mikeShinoda = new Singer("Mike Shinoda", Genre.ROCK, 1977);
    Singer bradfordPhillip = new Singer("Bradford Phillip", Genre.ROCK, 1977);
    Singer chesterCharlesBennington = new Singer("Chester Charles Bennington", Genre.ROCK, 1976);
    Singer josephHahn = new Singer("Joseph Hahn", Genre.HIP_HOP, 1977);
    Singer robertGregoryBourdon = new Singer("Robert Gregory Bourdon", Genre.ROCK, 1979);
    Singer liamPaulParisHowlett = new Singer("Liam Paul Paris Howlett", Genre.ELECTRONIC_MUSIC, 1971);
    Singer  maximReality = new Singer(" Maxim Reality", Genre.ROCK, 1970);
    Artist eminem = new Singer("Marshall Bruce Mathers", Genre.HIP_HOP, 1972);

    List<Singer> artistsLinkinPark = new ArrayList<>();
    artistsLinkinPark.add(mikeShinoda);
    artistsLinkinPark.add(bradfordPhillip);
    artistsLinkinPark.add(chesterCharlesBennington);
    artistsLinkinPark.add(josephHahn);
    artistsLinkinPark.add(robertGregoryBourdon);

    List<Singer> artistsProdigy = new ArrayList<>();
    artistsProdigy.add(liamPaulParisHowlett);
    artistsProdigy.add(maximReality);

    Artist linkinPark = new Band("Linkin Park", Genre.ROCK, 5, artistsLinkinPark);
    Artist prodigy = new Band("Prodigy", Genre.ELECTRONIC_MUSIC, 2, artistsProdigy);


    List<String> trackNamesOfLinkinPark = List.of("Numb","In the End","Papercut","One Step Closer","With You","Crawling",
            "Runaway","By Myself", "A Place for My Head", "Forgotten", "Cure for the Itch","Pushing Me Away");
    List<String> trackNamesOfLinkinPark2 = List.of("Foreword","Don't Stay","Somewhere I Belong","One Step Closer","Hit the Floor");

    Album hybridTheory = new Album("Hybrid Theory", 2000, linkinPark, new HashSet<>());
    for (String trackName: trackNamesOfLinkinPark){
        hybridTheory.addTrack(new Track(trackName));
    }
    Album meteora = new Album("Meteora", 2003, linkinPark, new HashSet<>());
    for (String trackName: trackNamesOfLinkinPark2) {
        meteora.addTrack(new Track(trackName));
    }
    Album expiriense = new Album("Expiriense", 1990, prodigy, new HashSet<>());
    List<String> trackNamesOfProdigy = List.of("Jericho","Music Reach","Wind It Up","Your Love","Hyperspeed",
    	"Charly", "Ruff in the Jungle Bizness","Death of the Prodigy Dancers");
    for (String trackName:trackNamesOfProdigy)
          {expiriense.addTrack(new Track(trackName)); }

    Album theSlimShadyLp = new Album("The Slim Shady LP", 1999, eminem, new HashSet<>());
    List<String> trackNamesOfEminem = List.of("Public Service Announcement", "My Name Is", "Brain Damage", "If I Had");
        for (String trackName: trackNamesOfEminem) {
            theSlimShadyLp.addTrack(new Track(trackName));
        }

    artistToAlbums.put(linkinPark, List.of(hybridTheory, meteora));
    artistToAlbums.put(prodigy, List.of(expiriense));
    artistToAlbums.put(eminem, List.of(theSlimShadyLp));
    return artistToAlbums;

    }


}











    /*   List<String> artistsNames = List.of("Linkin Park","TOR","Prodigy");
    List<Artist> artists = new ArrayList<>();
    for (String artist: artistsNames) {
        artists.add(new Band(artist));
    }
    Album hybridTheory = new Album("Hybrid Theory", 2000, artists.get(0), new HashSet<>());
    ArrayList<Album> lpAlbums = new ArrayList<>();
    lpAlbums.add(hybridTheory);
    artistsToAlbums.put(artists.get(0), lpAlbums);
    // создать артиста
    // альбом
    // треки
    // добавить в мэп ARTISTSTOALBUMS*/






        /*

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

        Artist linkinPark = new Band("Linkin Park", Genre.ROCK, 5, artists);

        linkinPark.playSong();
        linkinPark.playSong(numb);
        linkinPark.playSong(inTheEnd);
        linkinPark.playSong(papercut);

        System.out.println(" *  *  * ");




        PlayList myFavorite = new PlayList("My favorite list", new LinkedList<>());
        myFavorite.setTrack(numb);
        myFavorite.setTrack(inTheEnd);
        myFavorite.setTrack(papercut);
        myFavorite.setTrack(oneStepCloser);
        myFavorite.setTrack(withYou);
        myFavorite.setTrack(crawling);
        myFavorite.setTrack(runaway);
        myFavorite.setTrack(byMyself);

        System.out.println(myFavorite.getName());
        System.out.println("--------------");
        for (Track track: myFavorite.getPlayList()) {
            System.out.println(track.getName());
        }
        System.out.println(" *  *  * ");

        PlayList myMood = new PlayList("My mood list", new LinkedList<>());
        myMood.setTrack(aPlaceForMyHead);
        myMood.setTrack(forgotten);
        myMood.setTrack(cureForTheItch);
        myMood.setTrack(pushingMeAway);

        System.out.println(myMood.getName());
        System.out.println("--------------");
        for (Track track: myMood.getPlayList()) {
            System.out.println(track.getName());
        }
        System.out.println(" *  *  * ");

        PlayList number1 = new PlayList("Number 1", new LinkedList<>());
        number1.setTrack(forgotten);
        number1.setTrack(crawling);
        number1.setTrack(withYou);
        number1.setTrack(numb);
        number1.setTrack(oneStepCloser);
        System.out.println(number1.getName());
        System.out.println("--------------");
        for (Track track: number1.getPlayList()) {
            System.out.println(track.getName());
        }

        System.out.println(" *  *  * ");


        Album hybridTheory = new Album("Hybrid Theory", 2000, linkinPark, new HashSet<>());
        hybridTheory.setOfUniqueTracks(numb);
        hybridTheory.setOfUniqueTracks(inTheEnd);
        hybridTheory.setOfUniqueTracks(papercut);
        hybridTheory.setOfUniqueTracks(oneStepCloser);
        hybridTheory.setOfUniqueTracks(withYou);
        hybridTheory.setOfUniqueTracks(crawling);
        hybridTheory.setOfUniqueTracks(runaway);
        hybridTheory.setOfUniqueTracks(byMyself);
        hybridTheory.setOfUniqueTracks(aPlaceForMyHead);
        hybridTheory.setOfUniqueTracks(forgotten);
        hybridTheory.setOfUniqueTracks(cureForTheItch);
        hybridTheory.setOfUniqueTracks(pushingMeAway);

        System.out.println("Album " + hybridTheory.getName());
        System.out.println(hybridTheory.getDate());
        System.out.println("--------------");
        for (Track uniqueTrack: hybridTheory.getOfUniqueTracks()) {
            System.out.println(uniqueTrack.getName());
        }
        System.out.println(" *  *  * ");





        hybridTheory.reproduce();
        hybridTheory.reproduse(hybridTheory);
        hybridTheory.stop();
        hybridTheory.stop(hybridTheory);
        hybridTheory.pause();
        hybridTheory.pause(hybridTheory);

        System.out.println(hybridTheory);
        System.out.println(" *  *  * ");

        Guitar guitar = new Guitar("Guitar", 4);
        System.out.println("Name of instrument - " + guitar.getNameOfInstrument());
        System.out.println("Number of string - " + guitar.getNumbersOfString());
        System.out.println(" *  *  * ");

        Guitar guitarElectro = new Guitar("Electro guitar", 6);
        System.out.println("Name of instrument - " + guitarElectro.getNameOfInstrument());
        System.out.println("Number of string - " + guitarElectro.getNumbersOfString());
        System.out.println(" *  *  * ");
        Piano piano = new Piano("Piano", true);*/




