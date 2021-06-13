package com.solvd.savich.music;

import com.solvd.savich.music.album.Album;
import com.solvd.savich.music.album.PlayList;
import com.solvd.savich.music.album.Track;
import com.solvd.savich.music.artist.Artist;
import com.solvd.savich.music.artist.Band;
import com.solvd.savich.music.artist.Singer;
import com.solvd.savich.music.artist.Genre;
import com.solvd.savich.music.instrument.Guitar;
import com.solvd.savich.music.instrument.Piano;

import java.util.*;

public class Executor { //Create switch and scanner

    public static void main(String[] args) {
        Map<Artist, List <Album>> artistToAlbums = new HashMap<>();
        initApplication(artistToAlbums);

        Executor ex = new Executor();
        ex.getArtistsFromConsole();
    }

    public void printDoc(String command) {
        switch (command) {
            case "name":
                System.out.println("Please enter name");
                break;
            case "wrong input":
                System.out.println("Check the input");
                break;
            case "not a number":
                System.out.println("That not a number!, Try again");
                break;
            case "match":
                System.out.println("Input doesn't match number. Try again.");
                break;
            case "wrong type":
                System.out.println("Incorrect type of Artist!");
                break;
            default:
                System.out.println("Please enter number, what a new type of Artist you want to create: 1 - Singer, 2 - Band ?");
        }
    }

    public List<Artist> getArtistsFromConsole() {
        ArrayList<Artist> artists = new ArrayList();

        Scanner scanner = new Scanner(System.in);

        String name;
        Genre genre;
        int earthOfBirth, nameType, numbersOfMembers, index;

        printDoc("empty");

        do {
            while (!scanner.hasNextInt()) {
                printDoc("not a number");
                scanner.next();
            }
            nameType = Integer.parseInt(scanner.nextLine());
            if (nameType < 1 || nameType > 2)
                printDoc("match");
        } while (nameType < 1 || nameType > 2);

        // получить данные для создания артиста или группы
        name = scanner.nextLine();
        genre = Genre.values()[Integer.parseInt(scanner.nextLine())];
        earthOfBirth = Integer.parseInt(scanner.nextLine());
        switch (nameType) {
            case 1:
                Artist singer = new Singer(name, genre, earthOfBirth);
                artists.add(singer);
                break;
            case 2:
                printDoc("members");
                int num = Integer.parseInt(scanner.nextLine());
                ArrayList<Singer> members = fillMembers(num, scanner);
                Artist band = new Band(name, genre, num, members);
                artists.add(band);
                break;
            default:
                printDoc("wrong type");
                break;
        }
        return artists;
    }

    public ArrayList<Singer> fillMembers(int numbersOfMembers, Scanner scanner) {

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
        return members;
    }
    public List<Artist> getArtistFromBase(){
        Artist mikeShinoda = new Singer("Mike Shinoda", Genre.ROCK, 1977);
        Artist bradfordPhillip = new Singer("Bradford Phillip", Genre.ROCK, 1977);
        Artist chesterCharlesBennington = new Singer("Chester Charles Bennington", Genre.ROCK, 1976);
        Artist josephHahn = new Singer("Joseph Hahn", Genre.HIP_HOP, 1977);
        Artist robertGregoryBourdon = new Singer("Robert Gregory Bourdon", Genre.ROCK, 1979);

        ArrayList artists = new ArrayList<>();
        artists.add(mikeShinoda);
        artists.add(bradfordPhillip);
        artists.add(chesterCharlesBennington);
        artists.add(josephHahn);
        artists.add(robertGregoryBourdon);
        return artists;
    }



    public List<PlayList> getMyFavoritePlayList(){
        List<String> trackNames = Arrays.asList("Numb","In the End","Papercut","One Step Closer","With You","Crawling",
                "Runaway","By Myself", "A Place for My Head", "Forgotten", "Cure for the Itch","Pushing Me Away");
        PlayList myFavorite = new PlayList("My favorite list", new LinkedList<>());
                for (String trackName: trackNames){
                    myFavorite.setTrack(new Track(trackName));
                }
        return Collections.singletonList(myFavorite);



             /*Track numb = new Track("Numb");
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
  */

    }

    // artistName -> artist, album, tracks
    // createArtist(name, map<artist -> []albums>) {
    //  artist = artist
    //  for -> 5 track -> artistNameTrack1,2,3,4[]
    //  for -> newAlbum
    //
    // }

public static void initApplication (Map<Artist, List<Album>> artistsToAlbums) {
    Artist linkinPark = new Band("Linkin Park", Genre.ROCK, 5, List.of());

    List<String> trackNames = Arrays.asList("Numb","In the End","Papercut","One Step Closer","With You","Crawling",
            "Runaway","By Myself", "A Place for My Head", "Forgotten", "Cure for the Itch","Pushing Me Away");

    Album hybridTheory = new Album("Hybrid Theory", 2000, linkinPark, new HashSet<>());

    for (String trackName: trackNames){
        hybridTheory.addTrack(new Track(trackName));
    }

    artistsToAlbums.put(linkinPark, List.of(hybridTheory));


        /*    List<String> artistsNames = Arrays.asList("Linkin Park","TOR","Prodigy");
    List<Artist> artists = new ArrayList<>();
    for (String artist: artistsNames) {
        artists.add(new Band(artist));
    }
    Album hybridTheory = new Album("Hybrid Theory", 2000, artists.get(0), new HashSet<>());
    ArrayList<Album> lpAlbums = new ArrayList<>();
    lpAlbums.add(hybridTheory);
    artistsToAlbums.put(artists.get(0), lpAlbums);*/
    // создать артиста
    // альбом
    // треки
    // добавить в мэп ARTISTSTOALBUMS






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

}


}


