package com.solvd.savich.music;

import com.solvd.savich.music.artist.Artist;
import com.solvd.savich.music.artist.Singer;
import com.solvd.savich.music.exceptions.MyExceptions;
import com.solvd.savich.music.menu.Menu;
import com.solvd.savich.music.properties.Util;
import com.solvd.savich.utils.JsonExec;
import org.apache.log4j.Logger;

import java.util.List;


public class Executor {

    private final static Logger LOGGER = Logger.getLogger(Executor.class);
    private Logger logger;

    public static void main(String[] args) {

    /*    Menu menu = new Menu();
        try {
            menu.showMenu();
        } catch (MyExceptions myExceptions) {
            myExceptions.printStackTrace();
        }
        String test = Util.getPropertiesValue("PASSWORD");

        LOGGER.info(test);

        Util.setPropertiesValueWithResources("PASSWORD_1", "SOLVD");
        Util.printAll();*/

        Menu menu = new Menu();
        JsonExec jsonAction = new JsonExec();
        String jsonStr = jsonAction.convertJavaToJsonString(menu.getSingerFromBase());
        String jsonStr1 = jsonAction.convertJavaToJsonString(Menu.initArtists());
        LOGGER.info(jsonStr);
        LOGGER.info("================");
        LOGGER.info(jsonStr1);

        jsonAction.convertJsonToJavaFile(menu.getSingerFromBase(), "singer.json");

        jsonAction.convertJsonToJavaFile(Menu.initArtists(),"artists.json");

        List<Singer> artist1 = jsonAction.convertJsonStrToListSingerPOJO("singer.json");
        LOGGER.info("Name Artist from POJO: " + artist1.get(1).getName());



    }


}



