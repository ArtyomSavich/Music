package com.solvd.savich.music.menu;

import com.solvd.savich.music.album.Album;
import com.solvd.savich.music.album.PlayList;
import com.solvd.savich.music.album.Track;
import com.solvd.savich.music.artist.Artist;
import com.solvd.savich.music.artist.Band;
import com.solvd.savich.music.artist.Genre;
import com.solvd.savich.music.artist.Singer;
import com.solvd.savich.music.instrument.Guitar;
import com.solvd.savich.music.instrument.Instrument;
import com.solvd.savich.music.instrument.Piano;
import com.solvd.savich.music.exceptions.MyExceptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Menu {

    public enum Docs {EMPTY, NAME, WRONG_INPUT, NOT_A_NUMBER, MATCH, WRONG_TYPE, MEMBERS, GENRE, DATE_OF_BIRTH;}

    public void showMenu() throws MyExceptions {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        Map<Artist, List<Album>> artistListMap = initArtists();

        while (count < 5) {
            System.out.println("Please enter\n 1 If you want to create Artist\n" +
                            " 2 If you want to see all artists\n" +
                            " 3 To sorting Artist\n 4 Some Artist play the instrument\n 5 Exit");
            int option;
            try {
                option = getOption(scanner);
            } catch (MyExceptions myExceptions) {
                System.out.println(myExceptions.getMessage());
                continue;
            } catch (NumberFormatException n){
                System.out.println("You enter not a number!!!");
                continue;
            }
            switch (option) {
                case 1:
                    List<Artist> artistFromConsole = getArtistsFromConsole();
                    for (Artist artist : artistFromConsole) {
                        artistListMap.put(artist, new ArrayList<>());
                    }
                    break;
                case 2:
                    printAllArtists(artistListMap);
                    break;
                case 3:
                    System.out.println("After sorting ");
                    Map<Artist, List<Album>> artistSorted = sortByComparator(artistListMap);
                    printAllArtists(artistSorted);
                    break;
                case 4:
                    Guitar guitar = new Guitar("Guitar", 5);
                    Piano piano = new Piano("Piano",true);
                    for (Artist artist : artistListMap.keySet()) {
                      playTheInstrument(artist, guitar);
                      playTheInstrument(artist, piano);
                    }
                    break;
                case 5:
                    return;
            }
            count++;
        }
    }
    public int getOption(Scanner scanner) throws MyExceptions{
        int option;
        option = Integer.parseInt(getValidStringFromConsole(scanner));
        if (option >= 1 && option <= 5){
            return option;

        } else {
            throw new MyExceptions("You entered something WRONG!!");
        }

    }
    private static Map<Artist, List<Album>> sortByComparator(Map<Artist, List<Album>> artistListMap) {
        List<Map.Entry<Artist, List<Album>>> list = new ArrayList<>(artistListMap.entrySet());
        list.sort(new Comparator<Map.Entry<Artist, List<Album>>>() {
            @Override
            public int compare(Map.Entry<Artist, List<Album>> o1, Map.Entry<Artist, List<Album>> o2) {
                return o1.getKey().getName().compareTo(o2.getKey().getName());
            }
        });
        Map<Artist, List<Album>> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Artist, List<Album>> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }


    private void printAllArtists(Map<Artist, List<Album>> allArtists) {

        for (Artist artist : allArtists.keySet()) {
            System.out.println(artist.getName());
            System.out.println(allArtists.get(artist));
        }
    }

    private void deleteSomeArtist(Map<Artist, List<Album>> allArtists, Artist someArtist) {
        allArtists.remove(someArtist);
    }

    public void printDoc(Menu.Docs errorCode) {
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
                System.out.println("input date of Birth");
                break;
            case MEMBERS:
                System.out.println("Please enter number of members");
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

        printDoc(Menu.Docs.EMPTY);
        do {
            while (!scanner.hasNextInt()) {
                printDoc(Menu.Docs.NOT_A_NUMBER);
                scanner.next();
            }
            nameType = Integer.parseInt(getValidStringFromConsole(scanner));
            if (nameType < 1 || nameType > 2)
                printDoc(Menu.Docs.MATCH);
        } while (nameType < 1 || nameType > 2);

        printDoc(Menu.Docs.NAME);
        name = getValidStringFromConsole(scanner);
        printDoc(Menu.Docs.GENRE);
        genre = Genre.values()[Integer.parseInt(getValidStringFromConsole(scanner))];
        printDoc(Menu.Docs.DATE_OF_BIRTH);
        dateOfBirth = Integer.parseInt(getValidStringFromConsole(scanner));
        System.out.println("You selected option - " + nameType);
        switch (nameType) {
            case 1:
                Artist singer = new Singer(name, genre, dateOfBirth);
                artists.add(singer);
                break;
            case 2:
                printDoc(Menu.Docs.MEMBERS);
                int num = Integer.parseInt(getValidStringFromConsole(scanner));
                ArrayList<Singer> members = fillMembers(num, scanner);
                Artist band = new Band(name, genre, num, members);
                artists.add(band);
                break;
            default:
                printDoc(Menu.Docs.WRONG_TYPE);
                break;
        }
        return artists;
    }

    public static String getValidStringFromConsole(Scanner scanner) {
        while (true) {
            String string = scanner.nextLine();
            if (string != null && !string.isEmpty()) {
                return string;

            } else if(string == null){
                System.out.println("WRONG!!! Try Again, Please enter string not NULL and not empty!");
            }
        }
    }

    public static String inputValidString() throws MyExceptions{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        try {
            s = reader.readLine();
        } catch (IOException e){
            System.out.println(e.getMessage());
        } finally {
            try{
                reader.close();
            } catch (IOException e){
                System.out.println(e.getMessage());
            }

        } if ("".equals(s)){
            throw new MyExceptions("String can not be empty!");
        }
        return s;
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

    public List<Singer> getSingerFromBase() {
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

    public List<PlayList> getMyFavoritePlayList() {
        List<String> trackNames = List.of("Numb", "In the End", "Papercut", "One Step Closer", "With You", "Crawling",
                "Runaway", "By Myself", "A Place for My Head", "Forgotten", "Cure for the Itch", "Pushing Me Away");
        PlayList myFavorite = new PlayList("My favorite list", new LinkedList<>());
        for (String trackName : trackNames) {
            myFavorite.setTrack(new Track(trackName));
        }
        return List.of(myFavorite);

    }


    public static Map<Artist, List<Album>> initArtists() {

        Map<Artist, List<Album>> artistToAlbums = new HashMap<>();

        Singer mikeShinoda = new Singer("Mike Shinoda", Genre.ROCK, 1977);
        Singer bradfordPhillip = new Singer("Bradford Phillip", Genre.ROCK, 1977);
        Singer chesterCharlesBennington = new Singer("Chester Charles Bennington", Genre.ROCK, 1976);
        Singer josephHahn = new Singer("Joseph Hahn", Genre.HIP_HOP, 1977);
        Singer robertGregoryBourdon = new Singer("Robert Gregory Bourdon", Genre.ROCK, 1979);
        Singer liamPaulParisHowlett = new Singer("Liam Paul Paris Howlett", Genre.ELECTRONIC_MUSIC, 1971);
        Singer maximReality = new Singer(" Maxim Reality", Genre.ROCK, 1970);
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


        List<String> trackNamesOfLinkinPark = Arrays.asList("Numb", "In the End", "Papercut", "One Step Closer", "With You", "Crawling",
                "Runaway", "By Myself", "A Place for My Head", "Forgotten", "Cure for the Itch", "Pushing Me Away");

        List<String> trackNamesOfLinkinPark2 = Arrays.asList("Foreword", "Don't Stay", "Somewhere I Belong", "One Step Closer", "Hit the Floor");
        Collections.sort(trackNamesOfLinkinPark2);

        Album hybridTheory = new Album("Hybrid Theory", 2000, linkinPark, new HashSet<>());
        for (String trackName : trackNamesOfLinkinPark) {
            hybridTheory.addTrack(new Track(trackName));
        }
        Album meteora = new Album("Meteora", 2003, linkinPark, new HashSet<>());
        for (String trackName : trackNamesOfLinkinPark2) {
            meteora.addTrack(new Track(trackName));
        }
        Album expiriense = new Album("Expiriense", 1990, prodigy, new HashSet<>());
        List<String> trackNamesOfProdigy = List.of("Jericho", "Music Reach", "Wind It Up", "Your Love", "Hyperspeed",
                "Charly", "Ruff in the Jungle Bizness", "Death of the Prodigy Dancers");
        for (String trackName : trackNamesOfProdigy) {
            expiriense.addTrack(new Track(trackName));
        }

        Album theSlimShadyLp = new Album("The Slim Shady LP", 1999, eminem, new HashSet<>());
        List<String> trackNamesOfEminem = List.of("Public Service Announcement", "My Name Is", "Brain Damage", "If I Had");
        for (String trackName : trackNamesOfEminem) {
            theSlimShadyLp.addTrack(new Track(trackName));
        }

        artistToAlbums.put(linkinPark, List.of(hybridTheory, meteora));
        artistToAlbums.put(prodigy, List.of(expiriense));
        artistToAlbums.put(eminem, List.of(theSlimShadyLp));
        return artistToAlbums;


    }
    public void playTheInstrument(Artist artist, Instrument instrument){
        try{
            artist.playInstruments(instrument);
        } catch (MyExceptions myExceptions) {
            System.out.println(myExceptions.getMessage());
        }
    }

}


