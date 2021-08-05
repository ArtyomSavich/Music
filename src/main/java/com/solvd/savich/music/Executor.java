package com.solvd.savich.music;

import com.solvd.savich.database.Connector;
import com.solvd.savich.music.artist.Artist;
import com.solvd.savich.music.artist.Singer;
import com.solvd.savich.music.exceptions.MyExceptions;
import com.solvd.savich.music.menu.Menu;
import com.solvd.savich.music.properties.Util;
import com.solvd.savich.utils.JsonExec;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class Executor {

    private final static Logger LOGGER = Logger.getLogger(Executor.class);
    private Logger logger;

    public static void main(String[] args) {


       /* try {
            menu.showMenu();
        } catch (MyExceptions myExceptions) {
            myExceptions.printStackTrace();
        }*/
      //  Menu menu = new Menu();
        Connector connector = new Connector();
     //   LOGGER.info(menu.getAllTracks(connector));
       // Menu menu1 = new Menu();
       // LOGGER.info(menu1.getBandById(connector, 2));
        Menu menu2 = new Menu();
        LOGGER.info(menu2.getSingerById(connector, 1));
       // Menu menu3 = new Menu();
       // LOGGER.info(menu3.getGenreById(connector, 1));
        Menu menu4 = new Menu();
        LOGGER.info(menu4.getTracksById(connector,1));
        Menu menu5 = new Menu();
        LOGGER.info(menu5.getAllAlbums(connector));
      /*  String query = "Select * FROM track";
        Connector connector = new Connector();
        connector.getConnect();
        try (PreparedStatement pst = connector.getConnect().prepareStatement(query)){
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()){
                LOGGER.info(resultSet.getString("track_name"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
*/


        /*JsonExec jsonAction = new JsonExec();
        String jsonStr = jsonAction.convertJavaToJsonString(menu.getSingerFromBase());
        String jsonStr1 = jsonAction.convertJavaToJsonString(Menu.initArtists());
        LOGGER.info(jsonStr);
        LOGGER.info("================");
        LOGGER.info(jsonStr1);

        jsonAction.convertJsonToJavaFile(menu.getSingerFromBase(), "singer.json");

        jsonAction.convertJsonToJavaFile(Menu.initArtists(),"artists.json");

        List<Singer> artist1 = jsonAction.convertJsonStrToListSingerPOJO("singer.json");
        LOGGER.info("Name Artist from POJO: " + artist1.get(1).getName());
*/


    }


}



