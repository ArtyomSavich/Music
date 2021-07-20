package com.solvd.savich.music;

import com.solvd.savich.music.exceptions.MyExceptions;
import com.solvd.savich.music.menu.Menu;
import com.solvd.savich.music.properties.Util;
import org.apache.log4j.Logger;


public class Executor {

    private final static Logger LOGGER = Logger.getLogger(Executor.class);

    public static void main(String[] args) {

        Menu menu = new Menu();
        try {
            menu.showMenu();
        } catch (MyExceptions myExceptions) {
            myExceptions.printStackTrace();
        }
        String test = Util.getPropertiesValue("PASSWORD");

        LOGGER.info(test);

        Util.setPropertiesValueWithResources("PASSWORD_1", "SOLVD");
        Util.printAll();


    }

}




