package com.solvd.savich.music;

import com.solvd.savich.music.menu.Menu;
import com.solvd.savich.music.exceptions.MyExceptions;
import com.solvd.savich.music.properties.Util;


public class Executor {

    public static void main(String[] args) {
        /*Menu menu = new Menu();
        try {
            menu.showMenu();
        } catch (MyExceptions myExceptions) {
            myExceptions.printStackTrace();
        }*/
        String test = Util.getPropertiesValue("PASSWORD");

        System.out.println(test);

        Util.setPropertiesValueWithResources("PASSWORD_1", "SOLVD");
        Util.printAll();


    }

}




