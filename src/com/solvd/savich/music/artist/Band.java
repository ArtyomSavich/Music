package com.solvd.savich.music.artist;

import com.solvd.savich.music.album.Track;

import java.util.ArrayList;
import java.util.Arrays;

public class Band extends Artist{ //Add field ArrayList members

    private ArrayList<Singer> members;
    private int numbersOfMembers;

    public Band(String name, Genre genre, int numbersOfMembers, ArrayList<Singer> members) {
        super(name, genre);
        this.numbersOfMembers = numbersOfMembers;
        this.members = members;
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
    public String toString(){return Arrays.toString(members.toArray());}

    @Override
    public void playSong(Track track) {
        System.out.println("Band playing "+ track.getName());
    }
}
