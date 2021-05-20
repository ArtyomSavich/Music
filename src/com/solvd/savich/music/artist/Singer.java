package com.solvd.savich.music.artist;

import com.solvd.savich.music.genre.Genre;

public class Singer extends Artist {

    private int yearOfBirth;

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
}
