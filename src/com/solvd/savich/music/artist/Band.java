package com.solvd.savich.music.artist;

import com.solvd.savich.music.album.Track;
import com.solvd.savich.music.instrument.Instrument;
import com.solvd.savich.music.exceptions.MyExceptions;

import java.util.Arrays;
import java.util.List;

public class Band extends Artist{ //Add field ArrayList members

    private List<Singer> members;
    private int numbersOfMembers;

    public Band(String name, Genre genre, int numbersOfMembers, List<Singer> members) {
        super(name, genre);
        this.numbersOfMembers = numbersOfMembers;
        this.members = members;
    }
    public Band(String name){
        super(name);
    }
    public int getNumbersOfMembers() {
        return numbersOfMembers;
    }

    public void setNumbersOfMembers(int numbersOfMembers) {
        this.numbersOfMembers = numbersOfMembers;
    }

    @Override
    public void playSong() {
        System.out.println("Band with name " + getName()+ " play a song");
    }

    @Override
    public String toString(){
        return "Artist name = '" + getName() + '\'' + ", genre = " + getGenre() + ", " +
                "number of members - " + getNumbersOfMembers() +
                "\nlist of members" + Arrays.toString(members.toArray());}

    @Override
    public void playSong(Track track) {
        System.out.println("Band playing "+ track.getName());
    }

    @Override
    public void playInstruments(Instrument instrument) throws MyExceptions {
       throw new MyExceptions("Band " + getName() + " can not play on " + instrument);
    }


}
