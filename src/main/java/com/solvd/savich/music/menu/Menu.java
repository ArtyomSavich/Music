package com.solvd.savich.music.menu;


import com.solvd.savich.database.Connector;
import com.solvd.savich.music.album.Album;
import com.solvd.savich.music.album.Track;
import com.solvd.savich.music.artist.Artist;
import com.solvd.savich.music.artist.Band;
import com.solvd.savich.music.artist.Genre;
import com.solvd.savich.music.artist.Singer;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Menu {

    private final static Logger LOGGER = Logger.getLogger(Menu.class);

    public List<Track> getAllTracks(Connector connector) {
        ArrayList<Track> listTrack = new ArrayList<>();
        String query = "Select * FROM track";
        try (PreparedStatement pst = connector.getConnect().prepareStatement(query)) {
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
                listTrack.add(new Track(resultSet.getInt("track_id"), resultSet.getString("track_name")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listTrack;
    }

    public List<Track> getTracksById(Connector connector, int id) {
        ArrayList<Track> listTrackById = new ArrayList<>();
        String query = "Select track_name from albums Inner Join albums_tracks  \n" +
                "ON albums.artist_id = albums_tracks.album_id \n" +
                "Inner JOIN track ON \n" +
                "albums_tracks.track_id = track.track_id\n" +
                "where albums_tracks.album_id ='" + id + "'";
        try (PreparedStatement pst = connector.getConnect().prepareStatement(query)) {
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
                listTrackById.add(new Track(resultSet.getString("track_name")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listTrackById;
    }


    public Band getBandById(Connector connector, int id) {
        Band getBandById = null;
        String query = "Select * FROM band where artist_id='" + id + "'";
        try (PreparedStatement pst = connector.getConnect().prepareStatement(query)) {
            ResultSet resultSet = pst.executeQuery();
            if (resultSet.next()) {
                String genreFromArtistQuery = "Select * FROM artists where artist_id='" + id + "'";
                ResultSet genreFromArtist = connector.getConnect().prepareStatement(genreFromArtistQuery).executeQuery();
                if (genreFromArtist.next()) {
                    Genre genre = getGenreById(connector, genreFromArtist.getInt(1));
                    getBandById = new Band(resultSet.getInt(1), genre,
                            resultSet.getString(2), resultSet.getInt(3));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return getBandById;

    }

    public Singer getSingerById(Connector connector, int id) {
        Singer getSingerById = null;
        String query = "Select * FROM singer where artist_id='" + id + "'";
        try (PreparedStatement pst = connector.getConnect().prepareStatement(query)) {
            ResultSet resultSet = pst.executeQuery();
            if (resultSet.next()) {
                String genreFromArtistQuery = "Select * FROM artists where artist_id='" + id + "'";
                ResultSet genreFromArtist = connector.getConnect().prepareStatement(genreFromArtistQuery).executeQuery();
                if (genreFromArtist.next()) {
                    Genre genre = getGenreById(connector, genreFromArtist.getInt(2));
                    getSingerById = new Singer(resultSet.getInt(1), genre,
                            resultSet.getString(2), resultSet.getInt(3));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return getSingerById;
    }

    public Genre getGenreById(Connector connector, int id) {
        Genre getGenreById = null;
        String query = "Select * FROM genres where genre_id='" + id + "'";
        try (PreparedStatement pst = connector.getConnect().prepareStatement(query)) {
            ResultSet resultSet = pst.executeQuery();
            if (resultSet.next()) {
                getGenreById = new Genre(resultSet.getInt(1), resultSet.getString(2));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return getGenreById;
    }

    public Artist getArtistById(Connector connector, int id) {
        Artist getArtistById = null;
        String query = "Select * FROM artists where artist_id='" + id + "'";
        try (PreparedStatement pst = connector.getConnect().prepareStatement(query)) {
            ResultSet resultSet = pst.executeQuery();
            if (resultSet.next()) {
                String artistType = resultSet.getString(3);
                if ("singer".equals(artistType)) {
                    getArtistById = getSingerById(connector, id);
                } else {
                    getArtistById = getBandById(connector, id);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return getArtistById;
    }

    // запрос на вывод всех альбомов с их авторами и трэками
    public List<Album> getAllAlbums(Connector connector) {
        ArrayList<Album> listAlbum = new ArrayList<>();
        String query = "Select * from albums Left Join albums_tracks \n" +
                "ON albums.album_id = albums_tracks.album_id \n" +
                "Left JOIN track \n" +
                "ON albums_tracks.track_id = track.track_id\n" +
                "Left JOIN artists \n" +
                "ON albums.artist_id = artists.artist_id\n" +
                "Left JOIN band \n" +
                "ON artists.artist_id = band.artist_id\n" +
                "Left JOIN singer \n" +
                "ON albums.artist_id = singer.artist_id\n";

        try (PreparedStatement pst = connector.getConnect().prepareStatement(query)) {
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
                int artist_id = resultSet.getInt(2);
                Artist artist = getArtistById(connector, artist_id);
                List<Track> uniqueTracks = getAllTracks(connector);
                listAlbum.add(new Album(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getInt(3), artist, uniqueTracks));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listAlbum;
    }


}




   /* public List<Album> getAllAlbums(Connector connector){
        ArrayList<Album> listAlbum = new ArrayList<>();
        String query = "Select * FROM Albums";

        try (PreparedStatement pst = connector.getConnect().prepareStatement(query)) {
            ResultSet resultSet = pst.executeQuery();
            int artist_id = resultSet.getInt(2);
            Artist artist = getArtistById(connector, artist_id);
            Album album = new Album()


            String userInput =  "Select * FROM artists where artist_id = {0}";
            String result = MessageFormat.format(userInput,artist_id);
            ResultSet artistResult = connector.getConnect().prepareStatement(result).executeQuery();



            String artistType = artistResult.getString(3);


            while (resultSet.next()) {
                if( = )
                Artist artist = new Band(resultSet.getInt(1),result,);
                listAlbum.add(new Album(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getInt(3),resultSet.getString(4),
                        resultSet.getString(5)));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listAlbum;
    }*/









