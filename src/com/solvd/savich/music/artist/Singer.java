package com.solvd.savich.music.artist;

import com.solvd.savich.music.album.Track;

public class Singer extends Artist { //Add Overload method playSong

    private int yearOfBirth;
    public Singer(){

    }
public Singer(String name){
        super(name);
}
    public Singer(String name, Genre genre, int yearOfBirth) {
        super(name, genre);
        this.yearOfBirth = yearOfBirth;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    @Override
    public void playSong() {
        System.out.println("Year of birth "+ getYearOfBirth()+ "/ Singer "+ getName());
    }

    @Override
    public void playSong(Track track) {
        System.out.println("Singer playing "+ track.getName());
    }
}

