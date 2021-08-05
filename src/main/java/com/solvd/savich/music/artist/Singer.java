package com.solvd.savich.music.artist;

import com.solvd.savich.music.album.Track;
import com.solvd.savich.music.instrument.Instrument;

import java.util.List;

public class Singer extends Artist {

    private int singer_yearOfBirth;
    List<Singer> singers;
    private String singer_name;

    public Singer(int artist_id, Genre genre, String singer_name, int singer_yearOfBirth) {
              super(artist_id, genre);
              this.singer_name = singer_name;
              this.singer_yearOfBirth = singer_yearOfBirth;
    }

    @Override
    public void playSong() {
        System.out.println("Year of birth "+ getSinger_yearOfBirth()+ "/ Singer "+ getSinger_name());
    }

    @Override
    public void playSong(Track track) {
        System.out.println("Singer playing "+ track.getName());
    }

    @Override
    public void playInstruments(Instrument instrument) {
        System.out.println("Singer "+ getSinger_name() + " play on " + instrument);
    }

    @Override
    public String toString() {
        return "\n"+ "Singer{" +
                "singer ID - "+ getArtist_id()+
                ", singer_yearOfBirth = " + singer_yearOfBirth +

                ", singer_name = '" + singer_name + '\'' +
                "} " + super.toString();
    }

    public void setSinger_name(String singer_name) {
        this.singer_name = singer_name;
    }


     public int getSinger_yearOfBirth() {
        return singer_yearOfBirth;
    }

    public void setSinger_yearOfBirth(int singer_yearOfBirth) {
        this.singer_yearOfBirth = singer_yearOfBirth;
    }

    public String getSinger_name() {
        return singer_name;
    }
}


