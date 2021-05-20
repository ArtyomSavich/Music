package com.solvd.savich.music.artist;

import com.solvd.savich.music.genre.Genre;

public class Band extends Artist{

   private int numbersOfMembers;

    public Band(String name, Genre genre, int numbersOfMembers) {
        super(name, genre);
        this.numbersOfMembers = numbersOfMembers;
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

}
